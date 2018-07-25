package com.oocl.parkingLotApiPractice.service.impl;

import com.oocl.parkingLotApiPractice.entity.Order;
import com.oocl.parkingLotApiPractice.entity.Receipt;
import com.oocl.parkingLotApiPractice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author Dylan Wei
 * @date 2018-07-25 19:55
 */
public class OrderServiceImpl implements OrderService {
    private List<Order> allOrders;

    @Autowired
    public OrderServiceImpl(List<Order> allOrders){
        this.allOrders = allOrders;
    }

    @Override
    public Order createOrder(Receipt receipt) {
        Order order = new Order(UUID.randomUUID().toString(), receipt);
        this.allOrders.add(order);
        return order;
    }

    @Override
    public List<Order> getUnfinishedOrders() {
        return this.allOrders.stream()
                .filter(item -> !item.isFinished())
                .collect(Collectors.toList());
    }

    @Override
    public boolean seckillOrder(int parkingBoyId, String orderId) {
        Optional<Order> result = this.allOrders.stream()
                .filter(item -> item.getId().equals(orderId))
                .findFirst();
        if(!result.isPresent())
            return false;
        Order order = result.get();
        order.distributeTo(parkingBoyId);
        return true;
    }
}
