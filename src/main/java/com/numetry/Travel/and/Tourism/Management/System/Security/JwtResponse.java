package com.numetry.Travel.and.Tourism.Management.System.Security;


import com.numetry.Travel.and.Tourism.Management.System.Dto.UserDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class JwtResponse {

       private String token;
       private UserDto userDto;
}
