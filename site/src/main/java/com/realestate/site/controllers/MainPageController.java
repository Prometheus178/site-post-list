package com.realestate.site.controllers;



import com.realestate.site.advertisements.entities.Advertisement;
import com.realestate.site.advertisements.services.AdvertisementService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class MainPageController {


    private AdvertisementService advertisementService;

    public MainPageController(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }


    @GetMapping({"/main", "/"})
    public String mainFindAll(Model model,
                       @RequestParam("page") Optional<Integer> page,
                       @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(8);
        Page<Advertisement> advertisementPage = advertisementService.findPaginated(PageRequest.of(currentPage-1,pageSize));
        model.addAttribute("advertisementPage", advertisementPage);

        int totalPages = advertisementPage.getTotalPages();
        if (totalPages > 0){
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "main";
    }

    @GetMapping("/all-sell")
    public String findAllSell(Model model) {
        model.addAttribute("listOfAdvertisementByStatusSell", advertisementService.findAllSell());
        return "main";
    }

    @GetMapping("/all-rent")
    public String findAllRent(Model model) {
        model.addAttribute("listOfAdvertisementByStatusRent", advertisementService.findAllRent());
        return "main";
    }

   
}
