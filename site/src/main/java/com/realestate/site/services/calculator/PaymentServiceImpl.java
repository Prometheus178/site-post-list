package com.realestate.site.services.calculator;


import com.realestate.site.models.calculator.FormInput;
import com.realestate.site.models.calculator.Payment;
import com.realestate.site.utils.Convert;
import com.realestate.site.utils.PaymentCount;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    public List<Payment> getListPayment(FormInput formInput) {
        List<Payment> payments = new ArrayList<>();
        double rateInMonth = Convert.rateYearToMonth(formInput.getRateInYear());
        double rateInFraction = Convert.rateInFraction(formInput.getRateInYear());


        double annuityPayment = PaymentCount.annuityPaymentInMonth(formInput.getAmount(), rateInMonth, formInput.getPeriod());
        double paymentRate = PaymentCount.countPaymentRate(formInput.getAmount(), rateInFraction);
        double paymentLoan = PaymentCount.countPaymentLoan(annuityPayment, paymentRate);
        double balanceLoan = formInput.getAmount() - paymentLoan;

        Payment payment = new Payment();
        payment.setDate(LocalDate.now().plusMonths(1));
        payment.setPaymentLoan(paymentLoan);
        payment.setPaymentRate(paymentRate);
        payment.setAnnuityPayment(annuityPayment);
        payment.setBalanceLoan(balanceLoan);
        payment.setAnnuityPayment(annuityPayment);
        payments.add(payment);

        int t = 2;

        for (int i = 0; i < formInput.getPeriod() - 1; i++) {

            Payment payment1 = new Payment();
            payment1.setDate(LocalDate.now().plusMonths(t));
            t++;
            payment1.setAnnuityPayment(annuityPayment);
            paymentRate = PaymentCount.countPaymentRate(balanceLoan, rateInFraction);
            payment1.setPaymentRate(paymentRate);
            paymentLoan = PaymentCount.countPaymentLoan(annuityPayment, paymentRate);
            payment1.setPaymentLoan(paymentLoan);
            balanceLoan = balanceLoan - paymentLoan;
            if (balanceLoan < 5) {
                payment1.setBalanceLoan(0);
            } else {
                DecimalFormat decimalFormat = new DecimalFormat("#.##");
                String str = decimalFormat.format(balanceLoan);
                double balanceLoanFormatted = Double.parseDouble(str);
                payment1.setBalanceLoan(balanceLoanFormatted);
            }

            payments.add(payment1);
        }


        return payments;
    }
}
