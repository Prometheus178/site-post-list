package com.realestate.site.users.dao.impl;


import com.realestate.site.users.dao.interfaces.UserDAO;
import com.realestate.site.users.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;


    UserDAOImpl(){}

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(Long aLong) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.find(User.class, aLong);
        return user;
    }

    @Override
    public User save(User object) {
        return null;
    }

    @Override
    public void delete(User object) {

    }

}
