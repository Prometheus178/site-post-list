package com.realestate.site.users.dao.impl;


import com.realestate.site.users.dao.interfaces.AdminDAO;
import com.realestate.site.users.entities.Admin;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

public class AdminDAOImpl implements AdminDAO {

    @Override
    public List<Admin> findAll() {
        return null;
    }

    @Override
    public Admin findById(Long aLong) {
        return null;
    }

    @Override
    public Admin save(Admin object) {
        return null;
    }

    @Override
    public void delete(Admin object) {

    }

}
