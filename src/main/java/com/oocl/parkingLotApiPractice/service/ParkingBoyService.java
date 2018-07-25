package com.oocl.parkingLotApiPractice.service;

import com.oocl.parkingLotApiPractice.entity.ParkingBoy;
import com.oocl.parkingLotApiPractice.model.ParkingBoyModel;

import java.util.List;

/**
 * @author Dylan Wei
 * @date 2018-07-25 14:13
 */
public interface ParkingBoyService {

    Boolean addParkingBoy(ParkingBoy parkingBoy);

    List<ParkingBoyModel> getAllParkingBoyModels();

}
