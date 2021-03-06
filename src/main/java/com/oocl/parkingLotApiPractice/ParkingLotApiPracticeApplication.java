package com.oocl.parkingLotApiPractice;

import com.oocl.parkingLotApiPractice.entity.Order;
import com.oocl.parkingLotApiPractice.entity.ParkingBoy;
import com.oocl.parkingLotApiPractice.entity.ParkingLot;
import com.oocl.parkingLotApiPractice.entity.Receipt;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ParkingLotApiPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingLotApiPracticeApplication.class, args);
	}


	@Bean
    public List<ParkingBoy> allParkingBoys(){
	    List<ParkingBoy> allParkingBoys = new ArrayList<>();
	    allParkingBoys.add(new ParkingBoy(1));
	    allParkingBoys.add(new ParkingBoy(2));
	    return allParkingBoys;
    }

	@Bean
    public List<ParkingLot> allParkingLots(){
	    List<ParkingLot> allParkingLots = new ArrayList<>();
	    allParkingLots.add(new ParkingLot(1, 10, 8, 1));
	    allParkingLots.add(new ParkingLot(2, 100, 18, 1));
	    allParkingLots.add(new ParkingLot(3, 40, 38, 2));
	    allParkingLots.add(new ParkingLot(4, 50, 23, 2));
	    allParkingLots.add(new ParkingLot(5, 20, 20, 2));
	    return allParkingLots;
    }

    @Bean
    public List<Order> allOrders(){
	    List<Order> allOrders = new ArrayList<>();
	    allOrders.add(new Order("1", new Receipt("1", "粤c952")));
	    allOrders.add(new Order("2", new Receipt("2", "粤c222")));
	    allOrders.add(new Order("3", new Receipt("3", "粤c153")));
	    return allOrders;
    }

}
