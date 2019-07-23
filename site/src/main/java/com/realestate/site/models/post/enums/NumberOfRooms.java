package com.realestate.site.models.post.enums;

public enum NumberOfRooms {
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX_OR_MORE("6 и более"),
    STUDIO("Студия"),
    FREE_LAYOUT("Свободная планировка");

    private String value;
    NumberOfRooms (String val) {
        this.value = val;
    }

    public String getValue() {
        return value;
    }


}
