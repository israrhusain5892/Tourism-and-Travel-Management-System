package com.numetry.Travel.and.Tourism.Management.System.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.numetry.Travel.and.Tourism.Management.System.Dto.UserEnquiryDto;
import com.numetry.Travel.and.Tourism.Management.System.Service.UserEnquiryService;

@RestController
@RequestMapping("/public/query")
@CrossOrigin
public class UserEnquiryController {

    @Autowired
    private UserEnquiryService userEnquiryService;

    @PostMapping("/{email}")
    public UserEnquiryDto addEnquiry(@RequestBody UserEnquiryDto userEnquiryDto, @PathVariable String email) {

        return userEnquiryService.postEnquiry(userEnquiryDto, email);
    }

    @GetMapping
    public List<UserEnquiryDto> getAll() {
        return userEnquiryService.getAllEnqueries();
    }

}
