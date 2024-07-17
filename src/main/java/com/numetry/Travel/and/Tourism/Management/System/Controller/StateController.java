package com.numetry.Travel.and.Tourism.Management.System.Controller;


import com.numetry.Travel.and.Tourism.Management.System.Dto.CityDto;
import com.numetry.Travel.and.Tourism.Management.System.Dto.StateDto;
import com.numetry.Travel.and.Tourism.Management.System.Service.ServiceImpl.StateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public/state")
@CrossOrigin
public class StateController {

    @Autowired
    private StateServiceImpl stateService;

    @PostMapping("/")
    public ResponseEntity<?> addState(@RequestBody StateDto stateDto){

         List<StateDto> states=stateService.getAllSates();
             boolean exist=states.stream().anyMatch(
                state->state.getStateName().toLowerCase().equals(stateDto.getStateName().toLowerCase()));
             if(exist){
                return new ResponseEntity<>(stateDto.getStateName()+" state already exist",HttpStatus.BAD_REQUEST);
             }
              StateDto stateDto2=stateService.addState(stateDto);
             return new ResponseEntity<>(stateDto2,HttpStatus.ACCEPTED);
          
    }
    @GetMapping("/")
    public List<StateDto> getAllStates(){
         return stateService.getAllSates();
    }
    
}
