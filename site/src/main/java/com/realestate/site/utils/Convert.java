package com.realestate.site.utils;

import java.text.DecimalFormat;

public class Convert {

    public static double rateYearToMonth(double rate){
        double p = rate / 1200 ;
        DecimalFormat decimalFormat = new DecimalFormat("#.#######");
        String str = decimalFormat.format(p);
        double d = Double.parseDouble(str);
        return d;
    }

    public static double rateInFraction(double rate){
        double p = rate / 100 ;
        return p;
    }



}
