package com.realestate.site.controllers.user;



import com.realestate.site.models.user.User;
import com.realestate.site.services.post.interfaces.PostService;
import com.realestate.site.services.user.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;


@Controller
public class UserController{
    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;

    @GetMapping("/user/profile")
    public String user(Model model, Principal principal)  {
        User user =  userService.findUserByEmail(principal.getName());
        model.addAttribute("listOfPostsByUser",postService.findAllByUser(user));
        return "profile";
    }


}
