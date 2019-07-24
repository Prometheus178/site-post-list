package com.realestate.site.services.user.impl;


import com.realestate.site.models.user.Customer;
import com.realestate.site.repositories.user.CustomerRepository;
import com.realestate.site.services.user.Postman;
import com.realestate.site.services.user.interfaces.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void sendEmail(Customer customer) {
        Postman postman = new Postman("sergeipopof178@gmail.com", "Sirius178!");
        postman.send("Заявка на осмотр", customer,"sergeipopof178@gmail.com", "siriusonestar@yandex.ru");
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> findAllCustomer() {
        return customerRepository.findAll();
    }

}
