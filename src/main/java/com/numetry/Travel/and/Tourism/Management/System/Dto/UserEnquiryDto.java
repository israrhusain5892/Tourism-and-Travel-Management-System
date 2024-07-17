package com.numetry.Travel.and.Tourism.Management.System.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEnquiryDto {
    
    private Long queryId;
    private  String querySubject;
    private String messsage;
    private UserDto userDetail;
        
}
