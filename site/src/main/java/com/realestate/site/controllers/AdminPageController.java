package com.realestate.site.controllers;



import com.realestate.site.exception.FileStorageException;
import com.realestate.site.models.new_building.Address;
import com.realestate.site.models.new_building.Apartment;
import com.realestate.site.models.user.Customer;
import com.realestate.site.services.new_building.interfaces.AddressService;
import com.realestate.site.services.new_building.interfaces.ApartmentService;
import com.realestate.site.services.user.interfaces.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.IOException;


@Controller
@RequestMapping(value = "/admin")
public class AdminPageController {

    @Autowired
    private ApartmentService apartmentService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private CustomerService customerService;


    @GetMapping(value = "/apartments/{id}")
    public String apartmentsPage(@PathVariable("id") Long id, Model model) {
        Apartment apartment = new Apartment();
        model.addAttribute("apartment", apartment);
        model.addAttribute("addressId", id);
        model.addAttribute("listOfApartment", apartmentService.findAllApartmentByAddressId(id));
        Address address = addressService.findAddressById(id);

        return "admin-pages/apartment";
    }

    @PostMapping(value = "/save-apartment/{id}")
    public String saveOrUpdateApartment(@PathVariable("id") Long id,
                                        @ModelAttribute Apartment apartment) {
        Address address = addressService.findAddressById(id);
        apartment.setAddress(address);
        apartmentService.saveApartment(apartment);
        return "redirect:/admin/address";
    }


    @PostMapping(value = "/delete-address/{id}")
    public String deleteAddress(@PathVariable("id") Long id) {
        addressService.deleteAddressById(id);
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
                                      @RequestParam("image") MultipartFile file) {
        try{
            address.setImage(file.getBytes());
        }catch (IOException e){
            throw new FileStorageException("Could not store file " + file + ". Please try again!", e);
        }



        addressService.saveAddress(address);
        return "redirect:/admin/address";
    }

    @GetMapping("customers")
    public String customerPage(Model model){
        model.addAttribute("listOfCustomer",customerService.findAllCustomer());
        return "admin-pages/customer";
    }


}
