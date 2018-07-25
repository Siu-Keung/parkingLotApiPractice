package com.oocl.parkingLotApiPractice.controller;

import com.oocl.parkingLotApiPractice.entity.ParkingBoy;
import com.oocl.parkingLotApiPractice.entity.ParkingLot;
import com.oocl.parkingLotApiPractice.model.ParkingBoyModel;
import com.oocl.parkingLotApiPractice.service.ParkingBoyService;
import com.oocl.parkingLotApiPractice.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Dylan Wei
 * @date 2018-07-25 14:47
 */
@RestController
@RequestMapping("/parkingBoys")
public class ParkingBoyController {
    @Autowired
    private ParkingBoyService parkingBoyService;
    @Autowired
    private ParkingLotService parkingLotService;

    @PostMapping
    public String addParkingBoy(ParkingBoy parkingBoy){
        if(this.parkingBoyService.addParkingBoy(parkingBoy))
            return "succeeded";
        else
            return "failed";
    }

    @PatchMapping("/{parkingBoyId}/parkingLots")
    public String addParkingLotForParkingBoy(
            @PathVariable Integer parkingBoyId, Integer parkingLotId){
        ParkingLot parkingLot = new ParkingLot(parkingLotId);
        parkingLot.setParkingBoyId(parkingBoyId);
        if(this.parkingLotService.updateParkingLot(parkingLot) != null)
            return "succeeded";
        else
            return "failed";
    }

    @GetMapping
    public List<ParkingBoyModel> getAllParkingBoyModels(){
        return this.parkingBoyService.getAllParkingBoyModels();
    }


}
