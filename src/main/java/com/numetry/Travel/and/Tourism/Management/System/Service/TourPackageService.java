package com.numetry.Travel.and.Tourism.Management.System.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.numetry.Travel.and.Tourism.Management.System.Dto.BusDTO;
import com.numetry.Travel.and.Tourism.Management.System.Dto.HotelResponse;
import com.numetry.Travel.and.Tourism.Management.System.Dto.TourPackageDto;
import com.numetry.Travel.and.Tourism.Management.System.Dto.TripResponse;
import com.numetry.Travel.and.Tourism.Management.System.Model.Bus;
import com.numetry.Travel.and.Tourism.Management.System.Model.Hotel;
import com.numetry.Travel.and.Tourism.Management.System.Model.TourPackage;
import com.numetry.Travel.and.Tourism.Management.System.Model.TourPlace;
import com.numetry.Travel.and.Tourism.Management.System.Repository.HotelRepository;
import com.numetry.Travel.and.Tourism.Management.System.Repository.TourPackageRepo;
import com.numetry.Travel.and.Tourism.Management.System.Service.ServiceImpl.BusServiceImpl;
import com.numetry.Travel.and.Tourism.Management.System.Service.ServiceImpl.TripServiceImpl;
import jakarta.persistence.EntityNotFoundException;
// import org.springframework.transaction.annotation.Transactional;

@Service
public class TourPackageService {

      @Autowired
      private ModelMapper modelMapper;


      @Autowired
      private HotelRepository hotelRepository;


      @Autowired
      private TourPackageRepo tourPackageRepo;

      @Autowired
      private BusServiceImpl busServiceImpl;

      @Autowired
      private TripServiceImpl tripServiceImpl;

    

     
      public TourPackageDto createTourPackage(Long hotelId, Long busId, String stateName) {

            List<TripResponse> tripResponses = tripServiceImpl.getTripsByStateName(stateName);

            Hotel hotel = hotelRepository.findById(hotelId)
                        .orElseThrow(() -> new EntityNotFoundException("Hotel not found with id: " + hotelId));

            BusDTO busDto = busServiceImpl.getBusById(busId);
            Bus bus = modelMapper.map(busDto, Bus.class);

            TourPackage tourPackage = new TourPackage();
            tourPackage.setHotel(hotel);
            tourPackage.setBus(bus);
            double price=0;
             
            List<TourPlace> places = tourPackage.getPlaces();
            for (TripResponse response : tripResponses) {
                   
                  price+=response.getTripPrice();
                  TourPlace tour = new TourPlace();
                  tour.setPlaceName(response.getTripName());
                  tour.setPrice(response.getTripPrice());
                  tour.setAddress(response.getTripAddress());
                  tour.setPlaceCateogry(response.getCategoryName());
                  tour.setCity(response.getCityName());
                  tour.setState(response.getStateName());
                  tour.setImageUrl(response.getUrl());

                  places.add(tour);
            }
            tourPackage.setPackagePrice(price);
            tourPackage.setPlaces(places);

            for (TourPlace tour : places) {
                  tour.setTourPackage(tourPackage);
            }

            TourPackage savedTourPackage = tourPackageRepo.save(tourPackage);

            TourPackageDto tourPackageDto = modelMapper.map(savedTourPackage, TourPackageDto.class);
            HotelResponse res = tourPackageDto.getHotel();
            String url = "";
            url = ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("/public/hotel/download/")
                        .path(res.getId() + "")
                        .toUriString();
            res.setUrl(url);
            tourPackageDto.setBus(busDto);

            return tourPackageDto;
      }

      public List<TourPackageDto> getAllTourPackage() {

            List<TourPackageDto> list1 = new ArrayList<>();

            List<TourPackage> tourPackages = tourPackageRepo.findAll();

            for (TourPackage tourPackage : tourPackages) {

                  BusDTO busDto = busServiceImpl.getBusById(tourPackage.getBus().getId());
                  TourPackageDto tourPackageDto = modelMapper.map(tourPackage, TourPackageDto.class);

                  HotelResponse res = tourPackageDto.getHotel();
                  String url = "";
                  url = ServletUriComponentsBuilder.fromCurrentContextPath()
                              .path("/public/hotel/download/")
                              .path(res.getId() + "")
                              .toUriString();
                  res.setUrl(url);
                  tourPackageDto.setBus(busDto);

                  list1.add(tourPackageDto);

            }
            return list1;
      }

     
      public String deletePackage(Long id) {
            Optional<TourPackage> tourPackageOpt = tourPackageRepo.findById(id);

            if (!tourPackageOpt.isPresent()) {
                  return "Tour Package not found";
            }

            TourPackage tourPackage = tourPackageOpt.get();

            // Nullify the associations
            tourPackage.setHotel(null);
            tourPackage.setBus(null);

            // Delete the tour package
            tourPackageRepo.delete(tourPackage);

            // Check if the tour package still exists (which it shouldn't)
            Optional<TourPackage> tourPackageCheck = tourPackageRepo.findById(id);

            if (tourPackageCheck.isPresent()) {
                  tourPackageRepo.delete(tourPackageCheck.get());
            }

            return "Tour Package Deleted Successfully";
      }

}
