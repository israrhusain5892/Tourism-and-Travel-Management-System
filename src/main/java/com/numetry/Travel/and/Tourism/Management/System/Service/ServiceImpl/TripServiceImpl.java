package com.numetry.Travel.and.Tourism.Management.System.Service.ServiceImpl;

import com.numetry.Travel.and.Tourism.Management.System.Dto.TripDto;
import com.numetry.Travel.and.Tourism.Management.System.Dto.TripResponse;
import com.numetry.Travel.and.Tourism.Management.System.Model.City;
import com.numetry.Travel.and.Tourism.Management.System.Model.State;
import com.numetry.Travel.and.Tourism.Management.System.Model.Trip;
import com.numetry.Travel.and.Tourism.Management.System.Model.TripCategory;
import com.numetry.Travel.and.Tourism.Management.System.Repository.CityRepository;
import com.numetry.Travel.and.Tourism.Management.System.Repository.StateRepository;
import com.numetry.Travel.and.Tourism.Management.System.Repository.TripCategoryRepository;
import com.numetry.Travel.and.Tourism.Management.System.Repository.TripRepository;
import com.numetry.Travel.and.Tourism.Management.System.Service.TripService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TripServiceImpl  implements TripService {

     @Autowired
     private TripRepository tripRepository;

     @Autowired
     private StateRepository stateRepository;

     @Autowired
     private CityRepository cityRepository;

     @Autowired
     private TripCategoryRepository tripCategoryRepository;
     @Autowired
     private ModelMapper modelMapper;
    @Override
    public TripResponse addTrip(TripDto tripDto, String stateName, String cityName,
                                String tripCateoryName, MultipartFile file) throws IOException {
         State state=stateRepository.findByStateName(stateName);
         City city=cityRepository.findByCityName(cityName);
         TripCategory tripCategory=tripCategoryRepository.findByCategoryName(tripCateoryName);

          Trip trip=modelMapper.map(tripDto,Trip.class);
           trip.setTripCategory(tripCategory);
           trip.setCity(city);
           trip.setState(state);
           trip.setTripPhoto(file.getBytes());
           trip.setFileType(file.getContentType());
           trip.setTripPhotoName(file.getOriginalFilename());
           return modelMapper.map(tripRepository.save(trip),TripResponse.class);

    }

    @Override
    public List<TripResponse> getAllTrips() {
         List<TripResponse>list=new ArrayList<>();
         List<Trip> trips=tripRepository.findAll();
        for(Trip trip:trips){
            String url="";
             TripResponse res=modelMapper.map(trip,TripResponse.class);
             res.setCategoryName(trip.getTripCategory().getCategoryName());
             res.setStateName(trip.getState().getStateName());
             res.setCityName(trip.getCity().getCityName());
            url= ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/trip/download/")
                    .path(res.getTripId()+"")
                    .toUriString();
            res.setUrl(url);
            list.add(res);
        }
        return list;
    }

    @Override
    public List<TripResponse> getTripsByStateName(String stateName) {
         List<TripResponse> list=new ArrayList<>();
         State state=stateRepository.findByStateName(stateName);
         List<Trip> trips=tripRepository.findTripByState(state);

        for(Trip trip:trips){
            String url="";
            TripResponse res=modelMapper.map(trip,TripResponse.class);
            url= ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/trip/download/")
                    .path(res.getTripId()+"")
                    .toUriString();
            res.setUrl(url);
            list.add(res);
        }
        return list;
    }

    @Override
    public List<TripResponse> getTripsByCityName(String cityName) {

        List<TripResponse> list=new ArrayList<>();
        City city=cityRepository.findByCityName(cityName);
        List<Trip> trips=tripRepository.findTripByCity(city);

        for(Trip trip:trips){
            String url="";
            TripResponse res=modelMapper.map(trip,TripResponse.class);
            url= ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/trip/download/")
                    .path(res.getTripId()+"")
                    .toUriString();
            res.setUrl(url);
            list.add(res);
        }
        return list;

    }

    @Override
    public List<TripResponse> getTripsByCategoryName(String categoryName) {

        List<TripResponse> list=new ArrayList<>();
        TripCategory tripCategory=tripCategoryRepository.findByCategoryName(categoryName);
        List<Trip> trips=tripRepository.findByTripCategory(tripCategory);

        for(Trip trip:trips){
            String url="";
            TripResponse res=modelMapper.map(trip,TripResponse.class);
            url= ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/trip/download/")
                    .path(res.getTripId()+"")
                    .toUriString();
            res.setUrl(url);
            list.add(res);
        }
        return list;

    }

    public TripDto getTripById(UUID id) {
        return modelMapper.map(tripRepository.findById(id).get(),TripDto.class);
    }
}
