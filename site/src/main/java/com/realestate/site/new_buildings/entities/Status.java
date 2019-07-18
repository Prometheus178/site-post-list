package com.realestate.site.new_buildings.entities;

public enum Status {

    SOLD("Продано"),
    AVAILABLE("Свободно"),
    RESERVED("Зарезервировано");

    private String value;

    Status(String val) {
        this.value = val;
    }

    public String getValue() {
        return value;
    }


}
