package com.realestate.site.services.calculator;

import com.realestate.site.models.calculator.FormInput;
import com.realestate.site.models.calculator.Payment;

import java.util.List;

public interface PaymentService {

    List<Payment> getListPayment(FormInput formInput);
}
