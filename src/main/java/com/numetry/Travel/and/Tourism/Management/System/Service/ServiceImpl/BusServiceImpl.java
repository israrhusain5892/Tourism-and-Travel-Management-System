package com.numetry.Travel.and.Tourism.Management.System.Service.ServiceImpl;



import java.util.List;
import java.util.stream.Collectors;

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
import com.numetry.Travel.and.Tourism.Management.System.Service.BusService;



@Service
public class BusServiceImpl implements BusService {

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private RouteRepository routeRepository;

//     @Autowired
//     private OperatorRepository operatorRepository;

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
        Route route = routeRepository.findById(busDTO.getRoute().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Route not found"));
       

        Bus bus = new Bus();
        bus.setBusType(busDTO.getBusType());
        bus.setCapacity(busDTO.getCapacity());
        bus.setRoute(route);
        busRepository.save(bus);
        return convertToDto(bus);
    }

    @Override
    @Transactional
    public BusDTO updateBus(BusDTO busDTO) {
        Bus bus = busRepository.findById(busDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Bus not found"));

        Route route = routeRepository.findById(busDTO.getRoute().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Route not found"));
        

        bus.setBusType(busDTO.getBusType());
        bus.setCapacity(busDTO.getCapacity());
        bus.setRoute(route);
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
        RouteDTO routeDTO = new RouteDTO(
                bus.getRoute().getId(),
                bus.getRoute().getOrigin(),
                bus.getRoute().getDestination(),
                bus.getRoute().getDistance()
        );

       

        return new BusDTO(
                bus.getId(),
                bus.getBusNumber(),
                bus.getBusType(),
                bus.getCapacity(),
                routeDTO
               
        );
    }


}

