package com.realestate.site.services.user.impl;

import com.realestate.site.repositories.user.RoleRepository;
import com.realestate.site.repositories.user.UserRepository;
import com.realestate.site.models.user.Role;
import com.realestate.site.models.user.User;
import com.realestate.site.services.user.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public User findUserByEmail(String email){
        return userRepository.findByEmail(email);
    }
    @Override
    public User saveUser(User user){
        user.setActive(1);
        Role userRole = roleRepository.findByRole("USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
        return user;
    }
}
