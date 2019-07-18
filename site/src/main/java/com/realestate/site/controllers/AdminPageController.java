package com.realestate.site.controllers;



import com.realestate.site.new_buildings.entities.Address;
import com.realestate.site.new_buildings.entities.Apartment;
import com.realestate.site.new_buildings.services.interfaces.AddressService;
import com.realestate.site.new_buildings.services.interfaces.ApartmentService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.commons.CommonsMultipartFile;




@Controller
@RequestMapping(value = "/admin")
public class AdminPageController {

    private ApartmentService apartmentService;
    private AddressService addressService;


    public AdminPageController(ApartmentService apartmentService, AddressService addressService) {
        this.apartmentService = apartmentService;
        this.addressService = addressService;
    }


    @GetMapping("/admin-page")
    public String adminPanel() {
        return "admin-pages/index";
    }

    @GetMapping(value = "/apartments/{id}")
    public String apartmentsPage(@PathVariable("id") Long id, Model model) {

        model.addAttribute("address", addressService.findById(id));
//        model.addAttribute("listOfApartment", apartmentService.findAll());
        return "admin-pages/apartment";
    }

    @PostMapping(value = "/save-apartment/{id}")
    public String saveOrUpdateApartment(@PathVariable("id") Long id, @ModelAttribute Apartment apartment) {
        Address address = addressService.findById(id);
        apartment.setAddress(address);
        apartmentService.save(apartment);
        return "redirect:/admin/address";
    }

    @GetMapping("/address")
    public String addressesPage(Model model) {
        Address address = new Address();
        model.addAttribute("addressAttribute", address);
        model.addAttribute("listOfAddresses", addressService.findAll());
        return "admin-pages/address";
    }

    @PostMapping(value = "/save-address")
    public String saveOrUpdateAddress(@ModelAttribute("addressAttribute") Address address,
                                      BindingResult bindingResult,
                                      @RequestParam("image") CommonsMultipartFile[] image) {
        for (CommonsMultipartFile multipartFile : image) {
            address.setImage(multipartFile.getBytes());
        }
        addressService.save(address);
        return "redirect:/admin/address";
    }


    @GetMapping("/403")
    public String page403() {
        return "admin-pages/403";
    }
}
