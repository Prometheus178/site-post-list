package com.realestate.site.models.calculator;


public class FormInput {

    private double amount;
    private double period;
    private double rateInYear;

    public FormInput(double amount, double period, double rateInYear) {
        this.amount = amount;
        this.period = period;
        this.rateInYear = rateInYear;
    }

    public FormInput(){}

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getPeriod() {
        return period;
    }

    public void setPeriod(double period) {
        this.period = period;
    }

    public double getRateInYear() {
        return rateInYear;
    }

    public void setRateInYear(double rateInYear) {
        this.rateInYear = rateInYear;
    }
}
