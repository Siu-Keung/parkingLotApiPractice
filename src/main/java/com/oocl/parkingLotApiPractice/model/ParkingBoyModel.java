package com.oocl.parkingLotApiPractice.model;

import com.oocl.parkingLotApiPractice.entity.ParkingBoy;
import com.oocl.parkingLotApiPractice.entity.ParkingLot;

import java.util.List;

/**
 * @author Dylan Wei
 * @date 2018-07-25 14:04
 */
public class ParkingBoyModel extends ParkingBoy {
    private List<ParkingLot> parkingLots;

    public ParkingBoyModel(Integer id, List<ParkingLot> parkingLots) {
        super(id);
        this.parkingLots = parkingLots;
    }

    public ParkingBoyModel(ParkingBoy parkingBoy, List<ParkingLot> parkingLots){
        super(parkingBoy.getId());
        this.parkingLots = parkingLots;
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public void setParkingLots(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }
}
