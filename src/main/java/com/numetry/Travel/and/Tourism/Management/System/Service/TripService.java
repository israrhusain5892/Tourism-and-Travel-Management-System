package com.numetry.Travel.and.Tourism.Management.System.Service;

import com.numetry.Travel.and.Tourism.Management.System.Dto.TripDto;
import com.numetry.Travel.and.Tourism.Management.System.Dto.TripResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface TripService {

    TripResponse addTrip(TripDto tripDto, String stateName, String cityName,
                         String tripCateoryName, MultipartFile file) throws IOException;
    List<TripResponse> getAllTrips();
    List<TripResponse> getTripsByStateName(String stateName);

    List<TripResponse> getTripsByCityName(String cityName);

    List<TripResponse> getTripsByCategoryName(String categoryName);
}
