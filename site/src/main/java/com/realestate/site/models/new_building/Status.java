package com.realestate.site.models.new_building;

public enum Status {

    SOLD("Продано"),
    AVAILABLE("Свободно"),
    RESERVED("Зарезервировано");

    private String displayName;

    Status(String val) {
        this.displayName = val;
    }

    public String getDisplayName() {
        return displayName;
    }


}
