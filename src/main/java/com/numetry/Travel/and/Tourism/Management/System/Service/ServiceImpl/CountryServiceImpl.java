//package com.numetry.Travel.and.Tourism.Management.System.Service.ServiceImpl;
//
//import com.numetry.Travel.and.Tourism.Management.System.Dto.CountryDto;
//import com.numetry.Travel.and.Tourism.Management.System.Model.Country;
//import com.numetry.Travel.and.Tourism.Management.System.Repository.CountryRepository;
//import com.numetry.Travel.and.Tourism.Management.System.Service.CountryService;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class CountryServiceImpl implements CountryService {
//
//      @Autowired
//      private CountryRepository countryRepository;
//
//      @Autowired
//      private ModelMapper modelMapper;
//    @Override
//    public CountryDto addCountry(CountryDto countryDto) {
//           Country country=modelMapper.map(countryDto, Country.class);
//         return modelMapper.map(countryRepository.save(country),CountryDto.class);
//
//    }
//
//    @Override
//    public List<CountryDto> getCountries() {
//
//        List<CountryDto> list=new ArrayList<>();
//        List<Country> countryList=countryRepository.findAll();
//        for(Country country:countryList){
//             CountryDto countryDto=modelMapper.map(country,CountryDto.class);
//             list.add(countryDto);
//        }
//        return list;
//    }
//}
