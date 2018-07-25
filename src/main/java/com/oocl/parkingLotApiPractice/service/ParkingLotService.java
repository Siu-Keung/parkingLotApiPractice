package com.oocl.parkingLotApiPractice.service;

import com.oocl.parkingLotApiPractice.entity.ParkingLot;

import java.util.List;

/**
 * @author Dylan Wei
 * @date 2018-07-25 14:27
 */
public interface ParkingLotService {

    Boolean addParkingLot(ParkingLot parkingLot);

    ParkingLot updateParkingLot(ParkingLot newParkingLot);

    List<ParkingLot> getAllParkingLots();

    List<ParkingLot> getParkingLotsByParkingBoyId(Integer parkingBoyId);

}
