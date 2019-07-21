package com.realestate.site.controllers;



//import com.realestate.site.advertisements.services.AdvertisementService;
import com.realestate.site.models.user.User;
import com.realestate.site.services.advetisement.impl.AdvertisementServiceImpl;
import com.realestate.site.services.user.interfaces.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainPageController {


    private AdvertisementServiceImpl advertisementService;
    private UserService userService;
    public MainPageController(AdvertisementServiceImpl advertisementService, UserService userService) {
        this.advertisementService = advertisementService;
        this.userService = userService;
    }

    @GetMapping({"/","/main"})
    public String main(){
        return "main";
    }


//    @GetMapping("/main/all-sell")
//    public String findAllSell(Model model) {
//        model.addAttribute("listOfAdvertisementByStatusSell", advertisementService.findAllSell());
//        return "main";
//    }
//
//    @GetMapping("/main/all-rent")
//    public String findAllRent(Model model) {
//        model.addAttribute("listOfAdvertisementByStatusRent", advertisementService.findAllRent());
//        return "main";
//    }

   
}
