package com.realestate.site.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {

    @RequestMapping(value = "adminPage", method = RequestMethod.GET)
    public String adminPage(){
        return "admin-pages/index";
    }
}
