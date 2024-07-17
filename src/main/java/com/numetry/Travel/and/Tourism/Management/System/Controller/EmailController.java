package com.numetry.Travel.and.Tourism.Management.System.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.numetry.Travel.and.Tourism.Management.System.Service.EmailService;

import jakarta.mail.MessagingException;

import java.io.IOException;

@RestController
@CrossOrigin
@RequestMapping("/public")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/simple/send-email")
    public String sendEmail(
            @RequestParam String to,
            @RequestParam String subject,
            @RequestParam String text) {
                
        emailService.sendSimpleEmail(to, subject, text);
        return "Email sent successfully!";
    }

    @PostMapping("/send-email")
    public String sendEmail(
            @RequestParam String to,
            @RequestParam String subject,
            @RequestParam String text,
            @RequestParam MultipartFile attachment) {
        try {
            emailService.sendEmailWithAttachment(to, subject, text, attachment);
            return "Email sent successfully!";
        } catch (MessagingException | IOException e) {
            return "Failed to send email: " + e.getMessage();
        }
    }
}

