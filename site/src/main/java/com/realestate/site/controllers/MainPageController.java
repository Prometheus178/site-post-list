package com.realestate.site.controllers;



//import com.realestate.site.advertisements.services.PostService;
import com.realestate.site.models.post.enums.DealType;
import com.realestate.site.services.post.interfaces.PostService;
import com.realestate.site.services.user.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {

    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;

    @GetMapping({"/","/main"})
    public String main(Model model){
        model.addAttribute("listOfPost" ,postService.findAllPost());
        return "main";
    }

        @GetMapping("/main/all-sell")
    public String findAllSell(Model model) {

        model.addAttribute("listOfPostByStatusSell", postService.findAllPostByDealType(DealType.SELL));
        return "main";
    }

    @GetMapping("/main/all-rent")
    public String findAllRent(Model model) {
        model.addAttribute("listOfPostByStatusRent", postService.findAllPostByDealType(DealType.RENT));
        return "main";
    }


   
}
