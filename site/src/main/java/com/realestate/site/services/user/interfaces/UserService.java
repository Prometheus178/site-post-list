package com.realestate.site.services.user.interfaces;

import com.realestate.site.models.user.User;

public interface UserService {
    User findUserByEmail(String email);
    User saveUser(User user);
}
