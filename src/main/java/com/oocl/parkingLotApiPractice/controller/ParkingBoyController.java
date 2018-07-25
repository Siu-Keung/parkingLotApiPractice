package com.oocl.parkingLotApiPractice.controller;

import com.oocl.parkingLotApiPractice.entity.ParkingBoy;
import com.oocl.parkingLotApiPractice.entity.ParkingLot;
import com.oocl.parkingLotApiPractice.model.ParkingBoyModel;
import com.oocl.parkingLotApiPractice.service.ParkingBoyService;
import com.oocl.parkingLotApiPractice.service.ParkingLotManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Dylan Wei
 * @date 2018-07-25 14:47
 */
@RestController
public class ParkingBoyController {
    @Autowired
    private ParkingBoyService parkingBoyService;
    @Autowired
    private ParkingLotManagementService parkingLotService;

    @PostMapping("/parkingBoys")
    public String addParkingBoy(ParkingBoy parkingBoy){
        if(this.parkingBoyService.addParkingBoy(parkingBoy))
            return "succeeded";
        else
            return "failed";
    }

    @GetMapping("/parkingBoys")
    public List<ParkingBoyModel> getAllParkingBoyModels(){
        return this.parkingBoyService.getAllParkingBoyModels();
    }

    @PatchMapping("/parkingBoys/{parkingBoyId}/parkingLots/{parkingLotId}")
    public String distributeParkingLotToParkingBoy(
            @PathVariable Integer parkingBoyId, @PathVariable Integer parkingLotId){
        ParkingLot parkingLot = new ParkingLot(parkingLotId);
        parkingLot.setParkingBoyId(parkingBoyId);
        if(this.parkingLotService.updateParkingLot(parkingLot) != null)
            return "succeeded";
        else
            return "failed";
    }

    @GetMapping("/parkingBoys/{parkingBoyId}/parkingLots")
    public List<ParkingLot> getParkingLotsByParkingBoy(@PathVariable Integer parkingBoyId){
        return this.parkingLotService.getParkingLotsByParkingBoyId(parkingBoyId);
    }

}
