package com.realestate.site.services.user.interfaces;


import com.realestate.site.models.user.Customer;

import java.util.List;

public interface CustomerService {

    void sendEmail(Customer customer);
    Customer saveCustomer(Customer customer);
    List<Customer> findAllCustomer();
}
