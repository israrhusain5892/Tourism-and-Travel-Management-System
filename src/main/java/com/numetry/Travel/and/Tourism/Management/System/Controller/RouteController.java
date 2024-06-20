package com.numetry.Travel.and.Tourism.Management.System.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.numetry.Travel.and.Tourism.Management.System.Dto.RouteDTO;
import com.numetry.Travel.and.Tourism.Management.System.Service.RouteService;

@RestController
@RequestMapping("/public/route")
@CrossOrigin
public class RouteController {

    @Autowired
    private RouteService routeService;

    @PostMapping
    public RouteDTO addRoute(@RequestBody RouteDTO routeDTO) {

        return routeService.addRoute(routeDTO);
    }

    @GetMapping
    public List<RouteDTO> getAllRoutes() {
        return routeService.getAllRoutes();
    }
}
