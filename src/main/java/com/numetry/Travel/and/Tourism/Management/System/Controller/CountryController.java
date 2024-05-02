//package com.numetry.Travel.and.Tourism.Management.System.Controller;
//
//import com.numetry.Travel.and.Tourism.Management.System.Dto.CountryDto;
//import com.numetry.Travel.and.Tourism.Management.System.Service.ServiceImpl.CountryServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/country")
//public class CountryController {
//
//    @Autowired
//    private CountryServiceImpl countryService;
//
//    @PostMapping("/")
//     public CountryDto addCountry(@RequestBody CountryDto countryDto){
//           return countryService.addCountry(countryDto);
//     }
//
//     @GetMapping("/")
//    public List<CountryDto> getCountries(){
//         return countryService.getCountries();
//     }
//}
