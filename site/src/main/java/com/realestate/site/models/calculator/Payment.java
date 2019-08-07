package com.realestate.site.models.calculator;

import java.time.LocalDate;

public class Payment {
    private LocalDate date;
    private double annuityPayment;
    private double paymentLoan;
    private double paymentRate;
    private double balanceLoan;

    public Payment(LocalDate date, double annuityPayment, double paymentLoan, double paymentRate, double balanceLoan) {
        this.date = date;
        this.annuityPayment = annuityPayment;
        this.paymentLoan = paymentLoan;
        this.paymentRate = paymentRate;
        this.balanceLoan = balanceLoan;
    }


    public Payment(){}
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getAnnuityPayment() {
        return annuityPayment;
    }

    public void setAnnuityPayment(double annuityPayment) {
        this.annuityPayment = annuityPayment;
    }

    public double getPaymentLoan() {
        return paymentLoan;
    }

    public void setPaymentLoan(double paymentLoan) {
        this.paymentLoan = paymentLoan;
    }

    public double getPaymentRate() {
        return paymentRate;
    }

    public void setPaymentRate(double paymentRate) {
        this.paymentRate = paymentRate;
    }

    public double getBalanceLoan() {
        return balanceLoan;
    }

    public void setBalanceLoan(double balanceLoan) {
        this.balanceLoan = balanceLoan;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "date=" + date +
                ", annuityPayment=" + annuityPayment +
                ", paymentLoan=" + paymentLoan +
                ", paymentRate=" + paymentRate +
                ", balanceLoan=" + balanceLoan +
                '}';
    }
}
