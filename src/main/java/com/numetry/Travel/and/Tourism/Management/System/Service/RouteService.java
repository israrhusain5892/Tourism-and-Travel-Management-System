package com.numetry.Travel.and.Tourism.Management.System.Service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.numetry.Travel.and.Tourism.Management.System.Dto.RouteDTO;
import com.numetry.Travel.and.Tourism.Management.System.Model.Route;
import com.numetry.Travel.and.Tourism.Management.System.Repository.RouteRepository;
import com.spotify.docker.client.shaded.org.jvnet.hk2.annotations.Service;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private ModelMapper modelMapper;

    public RouteDTO addRoute(RouteDTO routeDTO) {
        Route route = modelMapper.map(routeDTO, Route.class);
        Route savedRoute = routeRepository.save(route);

        return modelMapper.map(savedRoute, RouteDTO.class);
    }

    public List<RouteDTO> getAllRoutes(){
           
         List<RouteDTO> list=new ArrayList<>();
         List<Route> routes=routeRepository.findAll();

         for(Route route:routes){
               RouteDTO routeDTO=modelMapper.map(route,RouteDTO.class);
               list.add(routeDTO);
         }
         return list;
    }

}
