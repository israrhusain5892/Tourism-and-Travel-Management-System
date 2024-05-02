package com.numetry.Travel.and.Tourism.Management.System.Service;

import com.numetry.Travel.and.Tourism.Management.System.Dto.StateDto;

import java.util.List;
import java.util.UUID;

public interface StateService {

     StateDto addState(StateDto stateDto);
     List<StateDto> getAllSates();

}
