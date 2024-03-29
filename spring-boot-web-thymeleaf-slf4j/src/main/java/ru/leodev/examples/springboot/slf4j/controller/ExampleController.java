package ru.leodev.examples.springboot.slf4j.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class ExampleController {
    // с помощью этой аннотации значение из application.properties будет подставлено в поле message
    @Value("${welcome.message:test}")
    private String message = "Hello World";

    @RequestMapping("/")
    public String home(Map<String, Object> model) {
        model.put("message", this.message);
        return "home";
    }

}
