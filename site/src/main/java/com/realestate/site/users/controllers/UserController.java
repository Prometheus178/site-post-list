package com.realestate.site.users.controllers;


import com.realestate.site.users.services.interfaces.UserService;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController{


    UserService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registrationView(){

        return "security/registration";

    }


}
