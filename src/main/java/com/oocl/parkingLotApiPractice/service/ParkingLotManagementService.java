package com.oocl.parkingLotApiPractice.service;

import com.oocl.parkingLotApiPractice.entity.ParkingLot;

import java.util.List;

/**
 * @author Dylan Wei
 * @date 2018-07-25 14:27
 */
public interface ParkingLotManagementService {

    Boolean addParkingLot(ParkingLot parkingLot);

    Boolean removeParkingLot(Integer parkingLotId);

    ParkingLot updateParkingLot(ParkingLot newParkingLot);

    ParkingLot getParkingLotById(Integer parkingLotId);

    List<ParkingLot> getAllParkingLots();

    List<ParkingLot> getParkingLotsByParkingBoyId(Integer parkingBoyId);

}
