package com.realestate.site.models.post.enums;

public enum BuildingType {
    NONE("---"),
    BLOCHNYI("Блочный"),
    DEREVYANNYI("Деревянный"),
    INDIVIDUAL("Индивидуальный"),
    MONOLYT_Carcas("Монолитно-каркасный"),
    CARCASNO_SHITOVOI("Каркасно-щитовой"),
    KPD("КПД"),
    MALOSEMEINYI("Малосемейный"),
    HRUSHEVSKII("Хрущевский"),
    STALINSKII("Сталинский");

    private String value;
    BuildingType (String val) {
        this.value = val;
    }

    public String getValue() {
        return value;
    }
}
