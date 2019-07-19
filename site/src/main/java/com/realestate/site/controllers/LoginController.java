package com.realestate.site.controllers;

import com.realestate.site.users.entities.User;
import com.realestate.site.users.services.impl.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;


@Controller
public class LoginController {

    private UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(Principal principal) {

//        if (principal != null) {
//            return "redirect:/main";
//        }
        return "security/login";
    }
    @GetMapping("/registration")
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user",user);
        modelAndView.setViewName("security/registration");
        return modelAndView;
    }

    @PostMapping
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findUserByEmail(user.getEmail());
        if (userExists != null){
            bindingResult.rejectValue("email", "error.user", "Этот email уже существует");
        }
        if (bindingResult.hasErrors()){
            modelAndView.setViewName("security/registration");
        }else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "Пользователь зарегистрирован");
            modelAndView.addObject("user",new User());
            modelAndView.setViewName("security/registration");
        }
        return modelAndView;
    }

}