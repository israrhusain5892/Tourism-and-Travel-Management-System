package com.numetry.Travel.and.Tourism.Management.System.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.numetry.Travel.and.Tourism.Management.System.Service.ForgottonPassword;

@RestController
@RequestMapping("/public")
@CrossOrigin
public class ForgotPasswordController {
      
      @Autowired
      private ForgottonPassword forgottonPassword;
       
       @PostMapping("/send-link/{email}")
       public ResponseEntity<String> sendLink(@PathVariable String email, @RequestParam String link){
              
                try{
                    return new ResponseEntity<>(forgottonPassword.checkUser(email, link),HttpStatus.ACCEPTED);
                }

                catch(Exception e){
                       return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
                }

             
       }



       @PostMapping("/resetPassword/{email}/{password}")
       public ResponseEntity<String> resetPass(@PathVariable String email, @PathVariable String password){
              
                try{
                    return new ResponseEntity<>(forgottonPassword.resetPassword(email, password),HttpStatus.ACCEPTED);
                }

                catch(Exception e){
                       return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
                }

             
       }
}
