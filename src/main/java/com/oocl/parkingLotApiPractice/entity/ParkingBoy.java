package com.oocl.parkingLotApiPractice.entity;

import java.util.Objects;

/**
 * @author Dylan Wei
 * @date 2018-07-25 13:59
 */
public class ParkingBoy {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ParkingBoy() {

    }

    public ParkingBoy(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParkingBoy)) return false;
        ParkingBoy that = (ParkingBoy) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
