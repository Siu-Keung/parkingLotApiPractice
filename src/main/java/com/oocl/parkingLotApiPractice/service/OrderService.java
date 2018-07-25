package com.oocl.parkingLotApiPractice.service;

import com.oocl.parkingLotApiPractice.entity.Order;
import com.oocl.parkingLotApiPractice.entity.Receipt;

import java.util.List;

/**
 * @author Dylan Wei
 * @date 2018-07-25 19:55
 */
public interface OrderService {

    Order createOrder(Receipt receipt);

    List<Order> getUnfinishedOrders();

    List<Order> getAllOrders();

    boolean seckillOrder(int parkingBoyId, String orderId);


}
