package com.oocl.parkingLotApiPractice.service.impl;

import com.oocl.parkingLotApiPractice.entity.ParkingLot;
import com.oocl.parkingLotApiPractice.service.ParkingLotManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Dylan Wei
 * @date 2018-07-25 14:28
 */
@Service
public class ParkingLotManagementServiceImpl implements ParkingLotManagementService {
    private List<ParkingLot> allParkingLots;

    @Autowired
    public ParkingLotManagementServiceImpl(List<ParkingLot> allParkingLots) {
        this.allParkingLots = allParkingLots;
    }

    @Override
    public Boolean addParkingLot(ParkingLot parkingLot) {
        if(this.allParkingLots.indexOf(parkingLot) != -1)
            return false;
        return this.allParkingLots.add(parkingLot);
    }

    @Override
    public ParkingLot updateParkingLot(ParkingLot newParkingLot) {
        int index = this.allParkingLots.indexOf(newParkingLot);
        if(index == -1)
            return  null;
        ParkingLot targetParkingLot = this.allParkingLots.get(index);
        if(newParkingLot.getTotalNum() != null)
            targetParkingLot.setTotalNum(newParkingLot.getTotalNum());
        if(newParkingLot.getAvailableNum() != null)
            targetParkingLot.setAvailableNum(newParkingLot.getAvailableNum());
        if(newParkingLot.getParkingBoyId() != null)
            targetParkingLot.setParkingBoyId(newParkingLot.getParkingBoyId());
        return targetParkingLot;
    }

    @Override
    public List<ParkingLot> getParkingLotsByParkingBoyId(Integer parkingBoyId) {
        return this.allParkingLots.stream()
                .filter(item -> item.getParkingBoyId().equals(parkingBoyId))
                .collect(Collectors.toList());
    }

    @Override
    public List<ParkingLot> getAllParkingLots() {
        return this.allParkingLots;
    }
}
