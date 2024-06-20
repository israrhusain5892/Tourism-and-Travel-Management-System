package com.numetry.Travel.and.Tourism.Management.System.Controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.numetry.Travel.and.Tourism.Management.System.Dto.BusDTO;
import com.numetry.Travel.and.Tourism.Management.System.Service.BusService;


@RestController
@RequestMapping("/public/bus")
@CrossOrigin
public class BusController {

    private final BusService busService;

    @Autowired
    public BusController(BusService busService) {
        this.busService = busService;
    }

    @GetMapping
    public ResponseEntity<List<BusDTO>> getAllBuses() {
        List<BusDTO> buses = busService.getAllBuses();
        return ResponseEntity.ok(buses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BusDTO> getBusById(@PathVariable("id") Long id) {
        BusDTO bus = busService.getBusById(id);
        return ResponseEntity.ok(bus);
    }

    @PostMapping
    public ResponseEntity<BusDTO> createBus(@RequestBody BusDTO busDTO) {
        BusDTO createdBus = busService.createBus(busDTO);
        return new ResponseEntity<>(createdBus, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BusDTO> updateBus(@PathVariable("id") Long id, @RequestBody BusDTO busDTO) {
        busDTO.setId(id);
        BusDTO updatedBus = busService.updateBus(busDTO);
        return ResponseEntity.ok(updatedBus);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBus(@PathVariable("id") Long id) {
        busService.deleteBus(id);
        return ResponseEntity.noContent().build();
    }
}
