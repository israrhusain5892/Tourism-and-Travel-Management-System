package com.numetry.Travel.and.Tourism.Management.System.Service;

import java.util.List;

import java.util.stream.Collectors;
import java.util.*;
// import org.hibernate.mapping.List;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.numetry.Travel.and.Tourism.Management.System.Dto.HotelBookingDto;
import com.numetry.Travel.and.Tourism.Management.System.Dto.HotelPaymentOrderDto;

import com.numetry.Travel.and.Tourism.Management.System.Model.HotelBooking;
import com.numetry.Travel.and.Tourism.Management.System.Model.HotelPaymentOrder;
import com.numetry.Travel.and.Tourism.Management.System.Model.User;
import com.numetry.Travel.and.Tourism.Management.System.Repository.HotelBookingRepository;
import com.numetry.Travel.and.Tourism.Management.System.Repository.HotelPaymentOrderRepo;

import com.numetry.Travel.and.Tourism.Management.System.Repository.UserRepository;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;

@Service
public class HotelPaymentService {

    @Autowired
    private HotelPaymentOrderRepo hotelPaymentOrderRepo;

    @Autowired
    private HotelBookingRepository hotelBookingRepo;


    @Autowired
    private HotelBookingService hotelBookingService;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private ModelMapper modelMapper;

    public String doPayment(Integer amt) throws Exception {

        RazorpayClient razorpay = new RazorpayClient("rzp_test_m9GtDw9SM8uFLX", "pvELoNMJuG107DKyjLapBhI7");
        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount", amt*100);
        orderRequest.put("currency", "INR");
        orderRequest.put("receipt", "txn_43455443");
        

        Order order = razorpay.orders.create(orderRequest);


        System.out.println(order);
        return order.toString();
    }

    public HotelPaymentOrderDto updateOrder(HotelPaymentOrderDto hotelPaymentOrderDto,Integer userId, Long hotelBookingId){

            HotelPaymentOrder hotelPaymentOrder=modelMapper.map(hotelPaymentOrderDto, HotelPaymentOrder.class);
            HotelBooking hotelBooking=hotelBookingRepo.findById(hotelBookingId).get();
            hotelBooking.setPaymentStatus("Success");
            hotelBookingRepo.save(hotelBooking);
            User user = userRepo.findById(userId).get();
            hotelPaymentOrder.setHotelBooking(hotelBooking);
            hotelPaymentOrder.setUser(user);
             hotelPaymentOrder.setPaymentStatus("Success");
            hotelPaymentOrder.setDate(new Date());
            HotelPaymentOrderDto hotelPaymentOrderDt = modelMapper.map(hotelPaymentOrderRepo.save(hotelPaymentOrder), HotelPaymentOrderDto.class);     
             HotelBookingDto hotelBookingDto=hotelBookingService.getBookingById(hotelBooking.getBookingId());;
            hotelPaymentOrderDt.setBookingId(hotelBookingDto.getBookingId());
              System.out.println(hotelBookingDto.getHotel().getId());
            hotelPaymentOrderDt.setBookingStatus(hotelBookingDto.getBookingStatus()); 
            
            hotelPaymentOrderDt.setHotelDetails(hotelBookingDto.getHotel());
            hotelPaymentOrderDt.setStayDuration(hotelBookingDto.getBookForDays());

            return hotelPaymentOrderDt;
        }

    public List<HotelPaymentOrderDto> getAllOrders(){

        List<HotelPaymentOrder> list=hotelPaymentOrderRepo.findAll();

        List<HotelPaymentOrderDto> newList =list.stream().map(order-> modelMapper.map(order,HotelPaymentOrderDto.class)
        ).collect(Collectors.toList());
        return newList;  
    }
}
