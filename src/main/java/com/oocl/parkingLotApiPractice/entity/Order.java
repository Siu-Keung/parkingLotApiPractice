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

    public Order(String id, Receipt receipt){
        this.id = id;
        this.receiptNo = receipt.getNo();
        this.carNo = receipt.getCarNo();
    }

    /**
     * 将订单分配给指定的停车小哥并将状态设置为“已完成”，之后该订单将处于不可抢的状态。
     * @return 是否分配成功
     */
    public synchronized boolean distributeTo(int parkingBoyId){
        if(this.isFinished)
            return false;
        this.isFinished = true;
        this.parkingBoyId = parkingBoyId;
        return true;
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

    public Integer getParkingBoyId() {
        return parkingBoyId;
    }


    public Integer getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(Integer parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

}
