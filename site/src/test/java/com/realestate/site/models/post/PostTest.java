package com.realestate.site.models.post;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.*;

public class PostTest {


    @Test
    public void formattedDateTime() {
        String dateTime = "2019-07-28T15:19:09.300";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String showTime = LocalDateTime.parse(dateTime).format(formatter);
        System.out.println(showTime);
    }
}
