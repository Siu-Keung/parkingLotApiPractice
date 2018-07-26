package com.oocl.parkingLotApiPractice.controller;

import com.oocl.parkingLotApiPractice.entity.ParkingLot;
import com.oocl.parkingLotApiPractice.service.ParkingLotManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Dylan Wei
 * @date 2018-07-25 14:52
 */
@RestController
public class ParkingLotController {
    @Autowired
    private ParkingLotManagementService parkingLotService;

    @PostMapping("/parkingLots")
    public String addParkingLot(ParkingLot parkingLot){
        if(this.parkingLotService.addParkingLot(parkingLot))
            return "succeeded";
        else
            return "failed";
    }

    @DeleteMapping("/parkingLots/{parkingLotId}")
    public String deleteParkingLot(@PathVariable Integer parkingLotId){
        if(this.parkingLotService.removeParkingLot(parkingLotId))
            return "succeeded";
        else
            return "failed";
    }

    @GetMapping("/parkingLots")
    public List<ParkingLot> getAllParkingLots(){
        return this.parkingLotService.getAllParkingLots();
    }

    @GetMapping("/parkingLots/{parkingLotId}")
    public ParkingLot getParkingLotById(@PathVariable Integer parkingLotId){
        return  this.parkingLotService.getParkingLotById(parkingLotId);
    }

    @PatchMapping("/parkingLots/{parkingLotId}")
    public ParkingLot updateParkinigLot(
            @PathVariable Integer parkingLotId, ParkingLot parkingLot, HttpServletResponse response
    ){
        ParkingLot resultParkingLot = this.parkingLotService.updateParkingLot(parkingLotId, parkingLot);
        if(resultParkingLot == null)
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return resultParkingLot;
    }




}
