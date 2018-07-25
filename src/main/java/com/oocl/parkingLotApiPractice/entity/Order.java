package com.oocl.parkingLotApiPractice.entity;

/**
 * @author Dylan Wei
 * @date 2018-07-25 19:13
 */
public class Order {
    private String id;
    private String receiptNo;
    private String carNo;
    private boolean isFinished = false;
    private Integer parkingBoyId;
    private Integer parkingLotId;

    public Order(String id, String receiptNo, String carNo) {
        this.id = id;
        this.receiptNo = receiptNo;
        this.carNo = carNo;
    }

    public String getId() {
        return id;
    }


    public String getReceiptNo() {
        return receiptNo;
    }


    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public Integer getParkingBoyId() {
        return parkingBoyId;
    }

    public void setParkingBoyId(Integer parkingBoyId) {
        this.parkingBoyId = parkingBoyId;
    }

    public Integer getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(Integer parkingLotId) {
        this.parkingLotId = parkingLotId;
    }
}
