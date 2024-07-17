package com.numetry.Travel.and.Tourism.Management.System.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.numetry.Travel.and.Tourism.Management.System.Dto.UserDto;
import com.numetry.Travel.and.Tourism.Management.System.Dto.UserEnquiryDto;
import com.numetry.Travel.and.Tourism.Management.System.Model.User;
import com.numetry.Travel.and.Tourism.Management.System.Model.UserEnquery;
import com.numetry.Travel.and.Tourism.Management.System.Repository.UserEnquiryRepository;
import com.numetry.Travel.and.Tourism.Management.System.Repository.UserRepository;

@Service
public class UserEnquiryService {
    
       @Autowired
       private ModelMapper modelMapper;

       @Autowired
       private UserEnquiryRepository userEnquiryRepository;

       @Autowired
       private UserRepository userRepository;

       public UserEnquiryDto postEnquiry(UserEnquiryDto userEnquiryDto,String email){
              
               UserEnquery userEnquery=modelMapper.map(userEnquiryDto,UserEnquery.class);
               User user=userRepository.findByEmail(email);
               List<UserEnquery> list=user.getEnqueries();
               list.add(userEnquery);
               user.setEnqueries(list);
               userEnquery.setUser(user);
               UserEnquery savedUserEnquery=userEnquiryRepository.save(userEnquery);
                UserEnquiryDto userEnquiryDto2=modelMapper.map(savedUserEnquery,UserEnquiryDto.class);
                 userEnquiryDto2.setUserDetail(modelMapper.map(user,UserDto.class));
                 return userEnquiryDto2;
            }

       public List<UserEnquiryDto> getAllEnqueries(){
            
             List<UserEnquiryDto> list=new ArrayList<>();
             
             List<UserEnquery> enqueries=userEnquiryRepository.findAll();
             for(UserEnquery userEnquery:  enqueries){
                 
                   UserEnquiryDto userEnquiryDto=modelMapper.map(userEnquery,UserEnquiryDto.class);
                   userEnquiryDto.setUserDetail(modelMapper.map(userEnquery.getUser(),UserDto.class));
                   list.add(userEnquiryDto);
             }
             return list;
       }

}
