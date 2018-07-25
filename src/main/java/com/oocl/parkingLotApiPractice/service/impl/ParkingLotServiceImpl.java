package com.oocl.parkingLotApiPractice.service.impl;

import com.oocl.parkingLotApiPractice.entity.ParkingLot;
import com.oocl.parkingLotApiPractice.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Dylan Wei
 * @date 2018-07-25 14:28
 */
@Service
public class ParkingLotServiceImpl implements ParkingLotService {
    private List<ParkingLot> allParkingLots;

    @Autowired
    public ParkingLotServiceImpl(List<ParkingLot> allParkingLots) {
        this.allParkingLots = allParkingLots;
    }

    @Override
    public Boolean addParkingLot(ParkingLot parkingLot) {
        if(this.allParkingLots.indexOf(parkingLot) != -1)
            return false;
        return this.allParkingLots.add(parkingLot);
    }
}
