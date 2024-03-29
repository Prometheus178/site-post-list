package com.realestate.site.models.post.enums;

public enum Repairs {
    NONE("---"),
    COSMETIC("Косметический"),
    EURO("Евро"),
    DESIGNER("Дизайнерский"),
    WITHOUT_REPAIR("Без ремонта");

    private String value;
    Repairs (String val) {
        this.value = val;
    }

    public String getValue() {
        return value;
    }
}
