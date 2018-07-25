package com.oocl.parkingLotApiPractice.entity;

/**
 * @author Dylan Wei
 * @date 2018-07-25 19:13
 */
public class Receipt {
    private String no;
    private String carNo;

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public Receipt(String no, String carNo) {

        this.no = no;
        this.carNo = carNo;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Receipt(String no) {

        this.no = no;
    }

    public Receipt() {

    }
}
