package com.oocl.parkingLotApiPractice.service.impl;

import com.oocl.parkingLotApiPractice.entity.ParkingLot;
import com.oocl.parkingLotApiPractice.service.ParkingLotManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
                .filter(item -> parkingBoyId.equals(item.getParkingBoyId()))
                .collect(Collectors.toList());
    }

    @Override
    public ParkingLot getParkingLotById(Integer parkingLotId) {
        return this.allParkingLots.stream()
                .filter(item -> item.getId().equals(parkingLotId))
                .findFirst().get();
    }

    @Override
    public Boolean removeParkingLot(Integer parkingLotId) {
        Optional<ParkingLot> optional = this.allParkingLots.stream()
                .filter(item -> item.getId().equals(parkingLotId))
                .findFirst();
        if(!optional.isPresent())
            return false;
        ParkingLot parkingLot = optional.get();
        if(parkingLot.getAvailableNum() != parkingLot.getTotalNum())
            return false;
        return this.allParkingLots.remove(parkingLot);
    }

    @Override
    public List<ParkingLot> getAllParkingLots() {
        return this.allParkingLots;
    }

    @Override
    public Boolean setInventory(Integer parkingLotId, Integer newInventory) {
        Optional<ParkingLot> optional = this.allParkingLots.stream()
                .filter(item -> item.getId().equals(parkingLotId))
                .findFirst();
        if(!optional.isPresent())
            return false;
        ParkingLot parkingLot = optional.get();
        if(newInventory > parkingLot.getTotalNum())
            return false;
        parkingLot.setAvailableNum(newInventory);
        return true;
    }
}
