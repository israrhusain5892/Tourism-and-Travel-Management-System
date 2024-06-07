package com.numetry.Travel.and.Tourism.Management.System.Service;





import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;


import com.twilio.type.PhoneNumber;
import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.security.SecureRandom;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@Service
public class OTPService {

         private static final long OTP_VALID_DURATION = TimeUnit.MINUTES.toMillis(5); // 5 minutes
         private final Map<String, OTPDetails> otpStorage = new ConcurrentHashMap<>();


    // @Value("${nexmo.api.key}")
    // private String apiKey;

    // @Value("${nexmo.api.secret}")
    // private String apiSecret;

    // @Value("${nexmo.phone.number}")
    // private String fromNumber;

    @Value("${twilio.accountSid}")
    private String accountSid;

    @Value("${twilio.authToken}")
    private String authToken;

    @Value("${twilio.phoneNumber}")
    private String fromPhoneNumber;


    public OTPService(@Value("${twilio.accountSid}") String accountSid,
                         @Value("${twilio.authToken}") String authToken) {
        Twilio.init(accountSid, authToken);
    }

    

    

    public void sendSMS(String toPhoneNumber) {
         String otp= OTPGenerator.generateOTP();
        Message.creator(
                new PhoneNumber(toPhoneNumber),
                new PhoneNumber(fromPhoneNumber),
                "Your OTP is: " + otp
        ).create();
    }

    public void generateAndSendOTP(String mobileNumber) {
        String otp = OTPGenerator.generateOTP();
        String message = "Your OTP is: " + otp;
         sendSMS(mobileNumber);

         OTPDetails otpDetails = new OTPDetails(otp, System.currentTimeMillis());
        otpStorage.put(mobileNumber, otpDetails);
    }


    public boolean verifyOTP(String mobileNumber, String otp) {
        OTPDetails otpDetails = otpStorage.get(mobileNumber);
        if (otpDetails == null) {
            return false;
        }

        long currentTime = System.currentTimeMillis();
        if (currentTime > otpDetails.getTimestamp() + OTP_VALID_DURATION) {
            otpStorage.remove(mobileNumber);
            return false;
        }

        if (otpDetails.getOtp().equals(otp)) {
            otpStorage.remove(mobileNumber);
            return true;
        }

        return false;
    }

    private static class OTPDetails {
        private final String otp;
        private final long timestamp;

        public OTPDetails(String otp, long timestamp) {
            this.otp = otp;
            this.timestamp = timestamp;
        }

        public String getOtp() {
            return otp;
        }

        public long getTimestamp() {
            return timestamp;
        }
    }


    

public class OTPGenerator {
    private static final int OTP_LENGTH = 6;
    private static final String DIGITS = "0123456789";
    private static final SecureRandom RANDOM = new SecureRandom();

    public static String generateOTP() {
        StringBuilder otp = new StringBuilder(OTP_LENGTH);
        for (int i = 0; i < OTP_LENGTH; i++) {
            otp.append(DIGITS.charAt(RANDOM.nextInt(DIGITS.length())));
        }
        return otp.toString();
    }
}

}


