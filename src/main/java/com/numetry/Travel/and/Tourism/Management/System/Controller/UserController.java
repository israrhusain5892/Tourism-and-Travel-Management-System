package com.numetry.Travel.and.Tourism.Management.System.Controller;


import com.numetry.Travel.and.Tourism.Management.System.Dto.UserDto;
import com.numetry.Travel.and.Tourism.Management.System.Security.JwtResponse;
import com.numetry.Travel.and.Tourism.Management.System.Service.ServiceImpl.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/public/user")
public class UserController {

      @Autowired
      private UserServiceImpl userService;


      @PutMapping("/update/{id}")
      public UserDto updateUser(@RequestBody UserDto userDto , @PathVariable Integer id){
           return userService.updateUser(userDto,id);
      }
    @GetMapping("/get/{id}")
    public UserDto getUser(@PathVariable  Integer id){
           return userService.getUser(id);
      }

      @DeleteMapping("/delete/{id}")
       public String deleteUser(@PathVariable Integer id){
          return userService.deleteUser(id);
      }
      @GetMapping("/get")
      public List<UserDto> getUsers(){
          return userService.getUsers();
      }
}
