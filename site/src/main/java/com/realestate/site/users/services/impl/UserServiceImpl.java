package com.realestate.site.users.services.impl;


import com.realestate.site.users.dao.interfaces.UserDAO;
import com.realestate.site.users.entities.User;
import com.realestate.site.users.services.interfaces.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    UserDAO userDAO;

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(Long aLong) {
        return userDAO.findById(aLong);
    }

    @Override
    public User save(User object) {
        return null;
    }

    @Override
    public void delete(User object) {

    }

}
