package com.realestate.site.models.advertisement.enums;

public enum RealEstateType {
    NONE("-"),
    LIVING ("Жилая"),
    COMMERCIAL ("Коммерческая");

    private String value;
    RealEstateType (String val) {
        this.value = val;
    }

    public String getValue() {
        return value;
    }
}
