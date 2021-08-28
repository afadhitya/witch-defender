package com.afadhitya.witchdefender.model;

public class YearNumberKeeper {
    private Integer number;
    private YearNumberKeeper prev;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public YearNumberKeeper getPrev() {
        return prev;
    }

    public void setPrev(YearNumberKeeper prev) {
        this.prev = prev;
    }
}
