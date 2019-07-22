package com.realestate.site.controllers;



import com.realestate.site.models.new_building.Address;
import com.realestate.site.models.new_building.Apartment;
import com.realestate.site.services.new_building.interfaces.AddressService;
import com.realestate.site.services.new_building.interfaces.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.commons.CommonsMultipartFile;




@Controller
@RequestMapping(value = "/admin")
public class AdminPageController {

    @Autowired
    private ApartmentService apartmentService;
    @Autowired
    private AddressService addressService;



    @GetMapping(value = "/apartments/{id}")
    public String apartmentsPage(@PathVariable("id") Long id, Model model) {
        Apartment apartment = new Apartment();
        Long addressId = id;
        model.addAttribute("apartment", apartment);
        model.addAttribute("addressId", addressId);
        model.addAttribute("listOfApartment", apartmentService.findAllApartment());
        Address address = addressService.findAddressById(id);

        return "admin-pages/apartment";
    }

    @PostMapping(value = "/save-apartment/{id}")
    public String saveOrUpdateApartment(@PathVariable("id") Long id, @ModelAttribute Apartment apartment) {
        Address address = addressService.findAddressById(id);
        apartment.setAddress(address);
        apartmentService.saveApartment(apartment);
        return "redirect:/admin/address";
    }

    @GetMapping("/address")
    public String addressesPage(Model model) {
        Address address = new Address();
        model.addAttribute("addressAttribute", address);
        model.addAttribute("listOfAddresses", addressService.findAllAddress());

        return "admin-pages/index";
    }

    @PostMapping(value = "/save-address")
    public String saveOrUpdateAddress(@ModelAttribute("addressAttribute") Address address,
                                      BindingResult bindingResult,
                                      @RequestParam("image") CommonsMultipartFile[] image) {
        for (CommonsMultipartFile multipartFile : image) {
            address.setImage(multipartFile.getBytes());
        }

        addressService.saveAddress(address);
        return "redirect:/admin/address";
    }



}
