package com.oocl.parkingLotApiPractice.controller;

import com.oocl.parkingLotApiPractice.entity.Receipt;
import com.oocl.parkingLotApiPractice.service.OrderService;
import com.oocl.parkingLotApiPractice.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author Dylan Wei
 * @date 2018-07-25 20:26
 */
@RestController
public class ReceiptController {
    @Autowired
    private ParkingService parkingService;
    @Autowired
    private OrderService orderService;

    @PostMapping("/receipts")
    public Receipt createReceipt(String carNo){
        Receipt receipt = new Receipt(UUID.randomUUID().toString(), carNo);
        orderService.createOrder(receipt);
        return receipt;
    }

}
