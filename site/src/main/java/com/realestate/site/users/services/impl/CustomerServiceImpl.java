package com.realestate.site.users.services.impl;

import com.realestate.site.users.dao.interfaces.CustomerDAO;
import com.realestate.site.users.entities.Customer;
import com.realestate.site.users.services.Postman;
import com.realestate.site.users.services.interfaces.CustomerService;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerDAO customerDAO;

    public CustomerServiceImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public void sendEmail(Customer customer) {
        Postman postman = new Postman("sergeipopof178@gmail.com", "Sirius178!");
        postman.send("Заявка на осмотр", customer,"sergeipopof178@gmail.com", "siriusonestar@yandex.ru");
    }

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public Customer findById(Long aLong) {
        return  customerDAO.findById(aLong);
    }

    public Customer save(Customer object) {
        Customer customer = customerDAO.save(object);
        return customer;
    }

    @Override
    public void delete(Customer object) {

    }

}
