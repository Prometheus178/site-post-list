package com.realestate.site.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class FormatDateTime {

    private static FormatDateTime INSTANCE = new FormatDateTime();

    public static FormatDateTime getInstance(){
        return INSTANCE;
    }

    private FormatDateTime(){}

    public String formattedDateTime(String dateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(dateTime).format(formatter);

    }
}
