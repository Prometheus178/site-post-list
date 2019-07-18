package com.realestate.site.users.dao.impl;


import com.realestate.site.users.dao.interfaces.CustomerDAO;
import com.realestate.site.users.entities.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    CustomerDAOImpl(){}
    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public Customer findById(Long aLong) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = session.load(Customer.class, aLong);
        return customer;
    }


    public Customer save(Customer object) {
        Session session = sessionFactory.getCurrentSession();
        session.save(object);
        return object;
    }

    @Override
    public void delete(Customer object) {

    }
}
