package com.realestate.site.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConventionController {

    @GetMapping("/main/privacy")
    public String privacyPage(){
        return "convention/privacy";
    }

    @GetMapping("/main/terms")
    public String termsPage(){
        return "convention/terms";
    }
}
