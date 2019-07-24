package com.realestate.site.services.user.interfaces;

import com.realestate.site.models.user.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findUserByUsername(String username);
    User  findUserByEmail(String email);
    User saveUser(User user);

}
