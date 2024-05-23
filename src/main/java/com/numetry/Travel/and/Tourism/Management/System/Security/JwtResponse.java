package com.numetry.Travel.and.Tourism.Management.System.Security;


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
       private String username;
}
