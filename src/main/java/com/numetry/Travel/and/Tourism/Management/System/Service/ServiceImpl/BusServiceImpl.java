package com.numetry.Travel.and.Tourism.Management.System.Service.ServiceImpl;



import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.numetry.Travel.and.Tourism.Management.System.Dto.BusDTO;
import com.numetry.Travel.and.Tourism.Management.System.Dto.RouteDTO;
import com.numetry.Travel.and.Tourism.Management.System.Exceptions.ResourceNotFoundException;
import com.numetry.Travel.and.Tourism.Management.System.Model.Bus;
import com.numetry.Travel.and.Tourism.Management.System.Model.Route;
import com.numetry.Travel.and.Tourism.Management.System.Repository.BusRepository;
import com.numetry.Travel.and.Tourism.Management.System.Repository.RouteRepository;
import com.numetry.Travel.and.Tourism.Management.System.Repository.SeatRepository;
import com.numetry.Travel.and.Tourism.Management.System.Service.BusService;
import com.numetry.Travel.and.Tourism.Management.System.Service.SeatService;



@Service
public class BusServiceImpl implements BusService {

    
    static Long id;
    @Autowired
    private BusRepository busRepository;

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private SeatService seatService;

   

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<BusDTO> getAllBuses() {
        List<Bus> buses = busRepository.findAll();
        return buses.stream().map(this::convertToDto).collect(Collectors.toList());
        
         
    }

    @Override
    public BusDTO getBusById(Long id) {
         
        Bus bus = busRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bus not found"));
        return convertToDto(bus);
    }

    @Override
    @Transactional
    public BusDTO createBus(BusDTO busDTO) {

        List<RouteDTO> routeDtos=busDTO.getRoutes();
          List<Route> routeList=new ArrayList<>();
          for(RouteDTO routeDTO2:routeDtos){
                Route route=modelMapper.map(routeDTO2,Route.class);
                routeList.add(route);
          }
       

        Bus bus = new Bus();
        bus.setBusType(busDTO.getBusType());
        bus.setBus_number(busDTO.getBus_number());
        bus.setCapacity(busDTO.getCapacity());
        
         List<Route> routes=bus.getRoutes();
        for(Route route:routeList){
            routes.add(route);
            route.setBus(bus);
        }
         bus.setRoutes(routes);
        routeRepository.saveAll(routeList);
       
        bus.setImageUrl(busDTO.getImageUrl());
        busRepository.save(bus);
        return convertToDto(bus);
    }

    @Override
    @Transactional
    public BusDTO updateBus(BusDTO busDTO) {
        Bus bus = busRepository.findById(busDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Bus not found"));

                List<Route> routeList = routeRepository.findAll();
        
        bus.setBus_number(busDTO.getBus_number());
        bus.setBusType(busDTO.getBusType());
        
        bus.setCapacity(busDTO.getCapacity());
        List<Route> routes=bus.getRoutes();
        for(Route route:routeList){
            routes.add(route);
            route.setBus(bus);
        }
         bus.setRoutes(routes);
        busRepository.save(bus);
        return convertToDto(bus);
    }

    @Override
    @Transactional
    public void deleteBus(Long id) {
        Bus bus = busRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bus not found"));
        busRepository.delete(bus);
    }

    private BusDTO convertToDto(Bus bus) {
        List<Route> routes=bus.getRoutes();
        List<RouteDTO> list=new ArrayList<>();
        for(Route route : routes){
        RouteDTO routeDTO = new RouteDTO(
              
                route.getId(),
                route.getOrigin(),
                route.getDestination(),
                route.getDistance(),
                route.getDepartTime(),
                route.getArriveTime()
            );

            list.add(routeDTO);
        }

       

        return new BusDTO(
                bus.getId(),
                bus.getBus_number(),
                bus.getBusType(),
                bus.getCapacity(),
                seatService.getAllSeats(bus.getId()).size(),
                list,
                bus.getImageUrl()
                
               
        );
    }


}

