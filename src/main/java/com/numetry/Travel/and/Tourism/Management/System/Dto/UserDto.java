package com.numetry.Travel.and.Tourism.Management.System.Dto;


import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

import com.numetry.Travel.and.Tourism.Management.System.Model.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {


    private Integer userId;

    @NotBlank(message="username is mandatory")
    private String name;

    @NotBlank(message="mobile is mandatory")
    @Size(min=10,message = "mobile should be contain 10 digits ")
    private String mobileNumber;

    @NotBlank(message="Email is mandatory")
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}"
            ,message="email is not valid"
    )
    private String email;

    @NotNull(message="password is required")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$"
            ,message="password should contain at least one Capital Letter, one small , one digit and" +
            "one special character"
    )
    private String password;


    private Set<Role> roles;

//    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$")

}
