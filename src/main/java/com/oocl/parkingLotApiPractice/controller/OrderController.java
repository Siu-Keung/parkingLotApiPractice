package com.oocl.parkingLotApiPractice.controller;

import com.oocl.parkingLotApiPractice.entity.Order;
import com.oocl.parkingLotApiPractice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Dylan Wei
 * @date 2018-07-25 20:40
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;


    @GetMapping("/orders")
    public List<Order> getOrders(@RequestParam(required = false) Boolean isFinished){
        if(isFinished != null && !isFinished)
            return orderService.getUnfinishedOrders();
        else
            return orderService.getAllOrders();
    }





}
