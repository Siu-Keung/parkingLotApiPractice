package com.oocl.parkingLotApiPractice.service.impl;

import com.oocl.parkingLotApiPractice.entity.ParkingBoy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Dylan Wei
 * @date 2018-07-25 14:15
 */
class ParkingBoyServiceImplTest {
    private ParkingBoyServiceImpl parkingBoyService;

    private List<ParkingBoy> allParkingBoys;

    @BeforeEach
    public void init(){
        this.allParkingBoys = new ArrayList<>();
        allParkingBoys.add(new ParkingBoy(1));
        allParkingBoys.add(new ParkingBoy(2));
        this.parkingBoyService = new ParkingBoyServiceImpl(allParkingBoys);
    }

    @Test
    void should_get_true_when_given_valid_boy() {
        ParkingBoy newParkingBoy = new ParkingBoy(3);

        boolean succeeded = parkingBoyService.addParkingBoy(newParkingBoy);

        assertThat(succeeded, is(true));
        assertThat(this.allParkingBoys.size(), is(3));
    }

    @Test
    void should_get_false_when_boy_id_exists(){
        ParkingBoy newParkingBoy = new ParkingBoy(2);

        boolean succeeded = parkingBoyService.addParkingBoy(newParkingBoy);

        assertThat(succeeded, is(false));
        assertThat(this.allParkingBoys.size(), is(2));
    }
}