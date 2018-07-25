package com.oocl.parkingLotApiPractice.service.impl;

import com.oocl.parkingLotApiPractice.entity.Order;
import com.oocl.parkingLotApiPractice.entity.Receipt;
import com.oocl.parkingLotApiPractice.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Dylan Wei
 * @date 2018-07-25 19:50
 */
public class ParkingServiceImpl implements ParkingService {
    private List<Order> allOrders;

    @Autowired
    public ParkingServiceImpl(List<Order> allOrders){
        this.allOrders = allOrders;
    }

    @Override
    public Receipt createReceipt(String carNo) {
        Receipt receipt = new Receipt(carNo);
        return receipt;
    }
}
