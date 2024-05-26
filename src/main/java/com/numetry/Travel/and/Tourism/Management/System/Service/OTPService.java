package com.numetry.Travel.and.Tourism.Management.System.Service;





import com.vonage.client.VonageClient;
import com.vonage.client.sms.SmsSubmissionResponse;
import com.vonage.client.sms.messages.TextMessage;

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


    @Value("${nexmo.api.key}")
    private String apiKey;

    @Value("${nexmo.api.secret}")
    private String apiSecret;

    @Value("${nexmo.phone.number}")
    private String fromNumber;

    private VonageClient vonageClient;

    @PostConstruct
    public void init() {
        this.vonageClient = VonageClient.builder()
                .apiKey(apiKey)
                .apiSecret(apiSecret)
                .build();
    }

    public void sendSMS(String toNumber, String message) {
           String number="91"+toNumber;
        TextMessage textMessage = new TextMessage(fromNumber, number, message);
        SmsSubmissionResponse response = vonageClient.getSmsClient().submitMessage(textMessage);
        
    }

    public void generateAndSendOTP(String mobileNumber) {
        String otp = OTPGenerator.generateOTP();
        String message = "Your OTP is: " + otp;
         sendSMS(mobileNumber, message);

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


