package com.realestate.site.models.post.enums;

public enum RentType {
    NONE("---"),
    LONG_TERM_RENT("Долгосрочная"),
    BY_THE_DAY ("Посуточно");

    private String value;
    RentType (String val) {
        this.value = val;
    }

    public String getValue() {
        return value;
    }
}
