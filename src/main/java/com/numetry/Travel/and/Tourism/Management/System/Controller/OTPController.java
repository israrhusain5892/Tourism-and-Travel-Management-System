package com.numetry.Travel.and.Tourism.Management.System.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.numetry.Travel.and.Tourism.Management.System.Service.OTPService;

@RestController
@RequestMapping("/api/otp")
@CrossOrigin
public class OTPController {
    @Autowired
    private OTPService otpService;

    @PostMapping("/generate")
    public String generateOTP(@RequestParam String mobileNumber) {
        otpService.generateAndSendOTP(mobileNumber);
        return "OTP sent to your mobile number.";
    }

    @PostMapping("/verify")
    public String verifyOTP(@RequestParam String mobileNumber, @RequestParam String mobileotp) {
        boolean isValid = otpService.verifyOTP(mobileNumber, mobileotp);
        return isValid ? "OTP is valid." : "Invalid or expired OTP.";
    }
}

