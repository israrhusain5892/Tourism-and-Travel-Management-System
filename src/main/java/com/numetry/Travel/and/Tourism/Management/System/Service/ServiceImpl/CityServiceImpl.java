package com.numetry.Travel.and.Tourism.Management.System.Service.ServiceImpl;

import com.numetry.Travel.and.Tourism.Management.System.Dto.CityDto;
import com.numetry.Travel.and.Tourism.Management.System.Model.City;
import com.numetry.Travel.and.Tourism.Management.System.Model.State;
import com.numetry.Travel.and.Tourism.Management.System.Repository.CityRepository;
//import com.numetry.Travel.and.Tourism.Management.System.Repository.SateRepository;
import com.numetry.Travel.and.Tourism.Management.System.Repository.StateRepository;
import com.numetry.Travel.and.Tourism.Management.System.Service.CityService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private StateRepository stateRepo;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CityDto addCity(CityDto cityDto, String stateName) {
        State state=stateRepo.findByStateName(stateName);
        City city=modelMapper.map(cityDto,City.class);
        city.setState(state);
        return modelMapper.map(cityRepository.save(city),CityDto.class);

    }

    @Override
    public List<CityDto> getAllCitiesByStateName(String stateName) {
           List<CityDto>list=new ArrayList<>();

           State state=stateRepo.findByStateName(stateName);
           List<City> cityList=cityRepository.findByState(state);
           for(City city:cityList){
               CityDto cityDto=modelMapper.map(city,CityDto.class);
               list.add(cityDto);

           }
        return list;
    }


    public List<CityDto> getAllCities() {
        List<CityDto>list=new ArrayList<>();

//        State state=stateRepo.findByStateName(stateName);
        List<City> cityList=cityRepository.findAll();
        for(City city:cityList){
            CityDto cityDto=modelMapper.map(city,CityDto.class);
            State state =city.getState();
            if(state==null){
                String cityName="Uttar Pradesh";
                cityDto.setStateName(cityName);
            }
            else{
                 cityDto.setStateName(city.getState().getStateName());
            }

            list.add(cityDto);

        }
        return list;
    }


}
