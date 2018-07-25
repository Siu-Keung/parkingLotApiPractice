package com.oocl.parkingLotApiPractice.entity;

import java.util.Objects;

/**
 * @author Dylan Wei
 * @date 2018-07-25 14:00
 */
public class ParkingLot {
    private Integer id;
    private Integer totalNum;
    private Integer availableNum;
    private Integer parkingBoyId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getAvailableNum() {
        return availableNum;
    }

    public void setAvailableNum(Integer availableNum) {
        this.availableNum = availableNum;
    }

    public Integer getParkingBoyId() {
        return parkingBoyId;
    }

    public void setParkingBoyId(Integer parkingBoyId) {
        this.parkingBoyId = parkingBoyId;
    }

    public ParkingLot(Integer id, Integer totalNum, Integer availableNum) {
        this.id = id;
        this.totalNum = totalNum;
        this.availableNum = availableNum;
    }

    public ParkingLot(Integer id) {

        this.id = id;
    }

    public ParkingLot(Integer id, Integer totalNum, Integer availableNum, Integer parkingBoyId) {

        this.id = id;
        this.totalNum = totalNum;
        this.availableNum = availableNum;
        this.parkingBoyId = parkingBoyId;
    }

    public ParkingLot() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParkingLot)) return false;
        ParkingLot that = (ParkingLot) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());
    }
}
