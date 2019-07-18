package com.realestate.site.advertisements.entities.enums;

public enum AccountType {
    OWNER ("Собственник"),
    AGENT ("Агент");

    private String value;
    AccountType(String val) {
        this.value = val;
    }

    public String getValue() {
        return value;
    }

}
