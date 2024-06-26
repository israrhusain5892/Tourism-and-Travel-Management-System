package com.numetry.Travel.and.Tourism.Management.System.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.numetry.Travel.and.Tourism.Management.System.Dto.SeatDTO;
import com.numetry.Travel.and.Tourism.Management.System.Service.SeatService;

@RestController
@CrossOrigin
@RequestMapping("/public/seat")
public class SeatController {
       
      @Autowired
      private SeatService seatService;

      @PostMapping("/{busId}")
      public List<SeatDTO> creatSeat(@RequestBody List<SeatDTO> seatDtos, @PathVariable Long busId){
            
           return seatService.makeSeat(seatDtos,busId);
      }

      @GetMapping("/{busId}")
      public List<SeatDTO> getAllSeats(@PathVariable Long busId){
           return seatService.getAllSeats(busId);
      }
}
