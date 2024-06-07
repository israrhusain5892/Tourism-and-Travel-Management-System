package com.numetry.Travel.and.Tourism.Management.System.Controller;


import com.numetry.Travel.and.Tourism.Management.System.Dto.StateDto;
import com.numetry.Travel.and.Tourism.Management.System.Service.ServiceImpl.StateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/state")
@CrossOrigin
public class StateController {

    @Autowired
    private StateServiceImpl stateService;

    @PostMapping("/")
    public StateDto addState(@RequestBody StateDto stateDto){
          return stateService.addState(stateDto);
    }
    @GetMapping("/")
    public List<StateDto> getAllStates(){
         return stateService.getAllSates();
    }
    
}
