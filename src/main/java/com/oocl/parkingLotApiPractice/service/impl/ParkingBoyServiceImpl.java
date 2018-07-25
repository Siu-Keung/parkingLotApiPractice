package com.oocl.parkingLotApiPractice.service.impl;

import com.oocl.parkingLotApiPractice.entity.ParkingBoy;
import com.oocl.parkingLotApiPractice.service.ParkingBoyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Dylan Wei
 * @date 2018-07-25 14:14
 */
@Service
public class ParkingBoyServiceImpl implements ParkingBoyService {
    private List<ParkingBoy> allParkingBoys;

    @Autowired
    public ParkingBoyServiceImpl(List<ParkingBoy> allParkingBoys) {
        this.allParkingBoys = allParkingBoys;
    }


    @Override
    public Boolean addParkingBoy(ParkingBoy parkingBoy) {
        if(this.allParkingBoys.indexOf(parkingBoy) != -1)
            return false;
        return this.allParkingBoys.add(parkingBoy);
    }
}
