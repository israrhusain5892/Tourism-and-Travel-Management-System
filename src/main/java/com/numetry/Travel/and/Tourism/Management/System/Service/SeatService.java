package com.numetry.Travel.and.Tourism.Management.System.Service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.numetry.Travel.and.Tourism.Management.System.Dto.SeatDTO;
import com.numetry.Travel.and.Tourism.Management.System.Exceptions.ResourceNotFoundException;
import com.numetry.Travel.and.Tourism.Management.System.Model.Bus;
import com.numetry.Travel.and.Tourism.Management.System.Model.Seat;
import com.numetry.Travel.and.Tourism.Management.System.Repository.BusRepository;
import com.numetry.Travel.and.Tourism.Management.System.Repository.SeatRepository;

@Service
public class SeatService {

     @Autowired
     private SeatRepository seatRepository;

     @Autowired
     private ModelMapper modelMapper;

     @Autowired
     private BusRepository  busRepository;


     public List<SeatDTO> makeSeat(List<SeatDTO> seatDtos ,Long busId){

          List<Seat> seatList=new ArrayList<>();

           for(SeatDTO seatDto:seatDtos) {
                Seat seat=modelMapper.map(seatDto, Seat.class);
                seatList.add(seat);
           }

          Bus bus=busRepository.findById(busId).orElseThrow(() -> new ResourceNotFoundException("Bus not found"));
          
            for(Seat seat:seatList){
                 seat.setSeatBookStatus("PENDING");
                 seat.setBus(bus);
                 
            }
           
            
             

             List<Seat> savedSeat=seatRepository.saveAll(seatList);
             List<SeatDTO> outList=new ArrayList<>();
             for(Seat savedSeat2:savedSeat){
                   SeatDTO seatDTO=modelMapper.map(savedSeat2,SeatDTO.class);
                   outList.add(seatDTO);
             }
             return outList;
        }

    public List<SeatDTO> getAllSeats(Long busId){
           String status="PENDING";
           List<SeatDTO> list=new ArrayList<>();
          Bus bus=busRepository.findById(busId).get();
           List<Seat> seats=seatRepository.findByBus(bus);

           for(Seat seat: seats){
            
                  if(seat.getSeatBookStatus().equals(status)){
                    SeatDTO seatDTO=modelMapper.map(seat,SeatDTO.class);
                    list.add(seatDTO);
                  }
                  
                 
           }
           
           return list;
    }
    
}
