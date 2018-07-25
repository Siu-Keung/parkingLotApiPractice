package com.oocl.parkingLotApiPractice.service.impl;

import com.oocl.parkingLotApiPractice.entity.ParkingBoy;
import com.oocl.parkingLotApiPractice.model.ParkingBoyModel;
import com.oocl.parkingLotApiPractice.service.ParkingBoyService;
import com.oocl.parkingLotApiPractice.service.ParkingLotManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dylan Wei
 * @date 2018-07-25 14:14
 */
@Service
public class ParkingBoyServiceImpl implements ParkingBoyService {
    @Autowired
    private ParkingLotManagementService parkingLotService;
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

    @Override
    public List<ParkingBoyModel> getAllParkingBoyModels() {
        List<ParkingBoyModel> parkingBoyModels = new ArrayList<>();
        for(ParkingBoy parkingBoy : this.allParkingBoys){
            ParkingBoyModel parkingBoyModel = new ParkingBoyModel(parkingBoy);
            parkingBoyModel.setParkingLots(this.parkingLotService.getParkingLotsByParkingBoyId(parkingBoy.getId()));
            parkingBoyModels.add(parkingBoyModel);
        }
        return parkingBoyModels;
    }
}
