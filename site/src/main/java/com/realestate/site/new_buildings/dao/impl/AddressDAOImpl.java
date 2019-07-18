package com.realestate.site.new_buildings.dao.impl;



import com.realestate.site.new_buildings.dao.interfaces.AddressDAO;
import com.realestate.site.new_buildings.entities.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class AddressDAOImpl implements AddressDAO {

    @Autowired
    private SessionFactory sessionFactory;



    AddressDAOImpl(){}

    @Transactional
    @Override
    public List<Address> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Address> addresses = session.createNativeQuery("select * from addresses", Address.class).list();
        return addresses;
    }


    public Address findById(Long id) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        Address address =  session.load(Address.class, id);
        session.getTransaction().commit();
        return address;
    }
    @Transactional
    @Override
    public Address save(Address object) {
        Session session = sessionFactory.getCurrentSession();
        session.save(object);
        return object;
    }
    @Transactional
    @Override
    public void delete(Address object) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(object);

    }

}
