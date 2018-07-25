package com.oocl.parkingLotApiPractice.service;

import com.oocl.parkingLotApiPractice.entity.Receipt;

/**
 * @author Dylan Wei
 * @date 2018-07-25 18:57
 */
public interface ParkingService {

    Receipt createReceipt(String carNo);

}
