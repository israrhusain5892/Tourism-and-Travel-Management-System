package com.numetry.Travel.and.Tourism.Management.System.Service.ServiceImpl;

import com.numetry.Travel.and.Tourism.Management.System.Dto.StateDto;
//import com.numetry.Travel.and.Tourism.Management.System.Model.Country;
import com.numetry.Travel.and.Tourism.Management.System.Model.State;
//import com.numetry.Travel.and.Tourism.Management.System.Repository.CountryRepository;
//import com.numetry.Travel.and.Tourism.Management.System.Repository.SateRepository;
import com.numetry.Travel.and.Tourism.Management.System.Repository.StateRepository;
import com.numetry.Travel.and.Tourism.Management.System.Service.StateService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class StateServiceImpl implements StateService {



     @Autowired
     private StateRepository sateRepository;

     @Autowired
     private ModelMapper modelMapper;

    @Override
    public StateDto addState(StateDto stateDto) {
//         Country country=countryRepository.findById(countryId).get();
         State state=modelMapper.map(stateDto,State.class);
//         state.setCountry(country);
         return modelMapper.map(sateRepository.save(state),StateDto.class);

    }

    @Override
    public List<StateDto> getAllSates() {

        List<StateDto> list=new ArrayList<>();
//           Country country=countryRepository.findByName(countryName);

        List<State> stateList=sateRepository.findAll();
        for(State state:stateList){
            StateDto stateDto=modelMapper.map(state,StateDto.class);
            list.add(stateDto);
        }

        return list;

    }

}
