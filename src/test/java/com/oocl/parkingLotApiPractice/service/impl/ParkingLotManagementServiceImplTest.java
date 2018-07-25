package com.oocl.parkingLotApiPractice.service.impl;

import com.oocl.parkingLotApiPractice.entity.ParkingLot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Dylan Wei
 * @date 2018-07-25 14:29
 */
class ParkingLotManagementServiceImplTest {
    private ParkingLotManagementServiceImpl parkingLotService;

    private List<ParkingLot> allParkingLots;

    @BeforeEach
    void init() {
        this.allParkingLots = new ArrayList<>();
        allParkingLots.add(new ParkingLot(1, 10, 8, 1));
        allParkingLots.add(new ParkingLot(2, 100, 18, 1));
        allParkingLots.add(new ParkingLot(3, 40, 38, 2));
        allParkingLots.add(new ParkingLot(4, 50, 23, 2));
        allParkingLots.add(new ParkingLot(5, 20, 8, 2));
        this.parkingLotService = new ParkingLotManagementServiceImpl(allParkingLots);
    }

    @Test
    void should_get_true_when_parking_lot_id_valid() {
        ParkingLot parkingLot = new ParkingLot(6, 20, 3);

        boolean succeeded = this.parkingLotService.addParkingLot(parkingLot);

        assertThat(succeeded, is(true));
        assertThat(this.allParkingLots.size(), is(6));
    }

    @Test
    void should_get_false_when_parking_lot_id_exist() {
        ParkingLot parkingLot = new ParkingLot(1, 20, 3);

        boolean succeeded = this.parkingLotService.addParkingLot(parkingLot);

        assertThat(succeeded, is(false));
        assertThat(this.allParkingLots.size(), is(5));
    }


    @Test
    void should_update_successfully(){
        ParkingLot newParkingLot = new ParkingLot(1, 10, 8, 2);

        ParkingLot resultParkingLot = this.parkingLotService.updateParkingLot(newParkingLot);

        assertThat(resultParkingLot.getParkingBoyId(), is(2));
    }
}