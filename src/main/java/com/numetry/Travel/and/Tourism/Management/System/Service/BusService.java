package com.numetry.Travel.and.Tourism.Management.System.Service;

import com.numetry.Travel.and.Tourism.Management.System.Dto.BusDTO;


import java.util.List;

public interface BusService {

    List<BusDTO> getAllBuses();

    BusDTO getBusById(Long id);

    BusDTO createBus(BusDTO busDTO);

    BusDTO updateBus(BusDTO busDTO);

    void deleteBus(Long id);
}
