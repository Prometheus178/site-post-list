package com.realestate.site.utils;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class PaymentCount {

    public static double annuityPaymentInMonth(double amount, double rateInMonth, double period) {
        double payment = amount * (rateInMonth + (rateInMonth / (Math.pow(1 + rateInMonth, period) - 1)));
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setRoundingMode(RoundingMode.CEILING);
        String str = decimalFormat.format(payment);
        double paymentCeiling = Double.parseDouble(str);
        return paymentCeiling;

    }

    public static double countPaymentRate(double amount, double rateInFraction) {
        double p = (amount * rateInFraction) / 12;
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String str = decimalFormat.format(p);
        double d = Double.parseDouble(str);
        return d;
    }

    public static double countPaymentLoan(double loan, double paymentRate) {
        double p = loan - paymentRate;
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String str = decimalFormat.format(p);
        double d = Double.parseDouble(str);
        return d;
    }

}
