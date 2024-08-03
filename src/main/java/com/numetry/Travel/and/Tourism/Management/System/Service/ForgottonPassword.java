package com.numetry.Travel.and.Tourism.Management.System.Service;

import org.sonatype.plexus.components.sec.dispatcher.PasswordDecryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.numetry.Travel.and.Tourism.Management.System.Model.User;
import com.numetry.Travel.and.Tourism.Management.System.Repository.UserRepository;

@Service
public class ForgottonPassword {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

     @Autowired
      private PasswordEncoder passwordEncoder;

    public String checkUser(String email, String link) throws Exception {

        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new Exception("User does not exist !!");
        }

        String msg =
                "Dear "+user.getName() +",\n\n" +
                "We have received a request to reset the password for your account. If you made this request, please click the link below to reset your password:\n\n"
                +
                "password reset link: "+link +"\n\n"+
                "If you did not request a password reset, please ignore this email or contact our support team for assistance.\n\n"
                +
                "For security reasons, this link will expire in 24 hours. After resetting your password, please ensure it is strong and unique to protect your account.\n\n"
                +
                "Thank you,\n" +
                "[Your Company Name] Support Team\n\n" +
                "---\n\n" +
                "Note: Do not share this link with anyone. If you have any questions or need further assistance, please contact us at [Support Contact Information].";

        // String msg = "your password reset link " + link;
        String subject = "Password Reset Request";
        emailService.sendSimpleEmail(email, subject, msg);
        return "Password reset link has been sent to your email";

    }

    public String resetPassword(String email, String password) throws Exception {
        // TODO Auto-generated method stub
           User user=userRepository.findByEmail(email);
           if (user==null) {
                throw new Exception("User does not exist !!");
           }
            user.setPassword(passwordEncoder.encode(password));
            userRepository.save(user);
            return "Password changed successfully !!";
    }

} 