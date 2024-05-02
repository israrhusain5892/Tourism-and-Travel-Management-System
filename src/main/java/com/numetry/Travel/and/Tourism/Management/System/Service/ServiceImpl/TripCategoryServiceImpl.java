package com.numetry.Travel.and.Tourism.Management.System.Service.ServiceImpl;


import com.numetry.Travel.and.Tourism.Management.System.Dto.TripCategoryDto;
import com.numetry.Travel.and.Tourism.Management.System.Model.TripCategory;
import com.numetry.Travel.and.Tourism.Management.System.Repository.TripCategoryRepository;
import com.numetry.Travel.and.Tourism.Management.System.Service.TripCategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TripCategoryServiceImpl implements TripCategoryService {

    @Autowired
    private TripCategoryRepository tripCategoryRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public TripCategoryDto addTripCategory(TripCategoryDto tripCategoryDto) {
        TripCategory tripCategory=modelMapper.map(tripCategoryDto,TripCategory.class);
        return modelMapper.map(tripCategoryRepository.save(tripCategory),TripCategoryDto.class);

    }

    @Override
    public List<TripCategoryDto> getAllTrips() {
        List<TripCategoryDto> list=new ArrayList<>();
        List<TripCategory> list1=tripCategoryRepository.findAll();
        for(TripCategory tripCategory:list1){
            TripCategoryDto tripCategoryDto=modelMapper.map(tripCategory,TripCategoryDto.class);
            list.add(tripCategoryDto);
        }
        return list;
    }
}
