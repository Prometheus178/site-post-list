package com.realestate.site.models.post.enums;

public enum Commercial {
    NONE("---"),
    OFFICE("Офис"),
    BUILDING("Здание"),
    TRADING_Area("Торговая площадка"),
    FREE_APOINTMENT_ROOM("Свободное помещение"),
    PRODUCTION("Производство"),
    STOCK("Склад"),
    READY_BUSINESS("Готовый бизнес"),
    COMMERCIAL_STEAD("Коммерческая земля");

    private String value;
    Commercial (String val) {
        this.value = val;
    }

    public String getValue() {
        return value;
    }
}
