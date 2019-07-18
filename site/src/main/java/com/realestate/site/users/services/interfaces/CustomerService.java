package com.realestate.site.users.services.interfaces;


import com.realestate.site.parent.CrudService;
import com.realestate.site.users.entities.Customer;

public interface CustomerService extends CrudService<Customer, Long> {

    void sendEmail(Customer customer);

}
