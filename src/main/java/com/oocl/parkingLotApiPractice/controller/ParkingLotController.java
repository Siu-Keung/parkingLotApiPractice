package com.oocl.parkingLotApiPractice.controller;

import com.oocl.parkingLotApiPractice.entity.ParkingLot;
import com.oocl.parkingLotApiPractice.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Dylan Wei
 * @date 2018-07-25 14:52
 */
@RestController
@RequestMapping("/parkingLots")
public class ParkingLotController {
    @Autowired
    private ParkingLotService parkingLotService;

    @PostMapping
    public String addParkingLot(ParkingLot parkingLot){
        if(this.parkingLotService.addParkingLot(parkingLot))
            return "succeeded";
        else
            return "failed";
    }

    @GetMapping
    public List<ParkingLot> getAllParkingLots(){
        return this.parkingLotService.getAllParkingLots();
    }



}
