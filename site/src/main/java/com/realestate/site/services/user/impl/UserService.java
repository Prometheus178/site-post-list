package com.realestate.site.services.user.impl;

import com.realestate.site.repositories.user.RoleRepository;
import com.realestate.site.repositories.user.UserRepository;
import com.realestate.site.models.user.Role;
import com.realestate.site.models.user.User;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserService {

    private UserRepository userRepository;

    private RoleRepository roleRepository;


    public UserService( UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public User findUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public User saveUser(User user){
        user.setActive(1);
        Role userRole = roleRepository.findByRole("USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
        return user;
    }
}
