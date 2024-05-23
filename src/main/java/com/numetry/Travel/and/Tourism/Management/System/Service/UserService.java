package com.numetry.Travel.and.Tourism.Management.System.Service;

import com.numetry.Travel.and.Tourism.Management.System.Dto.UserDto;

import java.util.List;
import java.util.UUID;

public interface UserService {

    UserDto addUser(UserDto userDto);
    UserDto getUser(Integer id);
    List<UserDto> getUsers();

    String deleteUser(Integer id);

    UserDto updateUser(UserDto userDto,Integer id);

}
