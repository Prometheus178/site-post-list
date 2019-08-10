package com.realestate.site.models.post.enums;

public enum Living {
    NONE("---"),
    APARTMENT("Квартира"),
    ROOM("Комната"),
    HOUSE("Дом"),
    DACHA("Дача"),
    STEAD("Земля"),
    GARAGE("Гараж");
    private String value;
    Living (String val) {
        this.value = val;
    }

    public String getValue() {
        return value;
    }
}
