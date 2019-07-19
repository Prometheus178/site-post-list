package com.realestate.site.models.new_building;

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
