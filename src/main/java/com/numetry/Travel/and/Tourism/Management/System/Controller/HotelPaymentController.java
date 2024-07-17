package com.numetry.Travel.and.Tourism.Management.System.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.numetry.Travel.and.Tourism.Management.System.Dto.HotelBookingDto;
import com.numetry.Travel.and.Tourism.Management.System.Dto.HotelPaymentOrderDto;
import com.numetry.Travel.and.Tourism.Management.System.Model.HotelPaymentOrder;
import com.numetry.Travel.and.Tourism.Management.System.Service.HotelPaymentService;
import com.razorpay.Order;

@RestController
@RequestMapping("/public")
@CrossOrigin
public class HotelPaymentController {
       
    @Autowired
    private HotelPaymentService hotelPaymentService;
     
    @PostMapping("/create-order/{amount}")
    @ResponseBody
    public String createOrder(@PathVariable Integer amount) throws Exception{
          
            return hotelPaymentService.doPayment(amount);
             
    }

    @PostMapping("/update-order/{userId}/{hotelBookingId}")
    public HotelPaymentOrderDto updateOrder(@RequestBody HotelPaymentOrderDto hotelPaymentOrderDto,@PathVariable Integer userId,
    @PathVariable String hotelBookingId) {
             
            // Long id=(long)(hotelBookingId.charAt(hotelBookingId.length()-1) - '0');
           Long id= (long)Integer.parseInt(hotelBookingId.replaceAll("[^0-9]",""));
            System.out.println(id);
            return hotelPaymentService.updateOrder(hotelPaymentOrderDto,userId,id);
             
    }
}
