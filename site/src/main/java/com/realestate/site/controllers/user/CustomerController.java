package com.realestate.site.controllers.user;


import com.realestate.site.models.new_building.Apartment;
import com.realestate.site.models.user.Customer;

import com.realestate.site.services.new_building.interfaces.ApartmentService;
import com.realestate.site.services.user.interfaces.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ApartmentService apartmentService;

    @GetMapping("/apartment/{id}/order")
    public String orderPage(@PathVariable("id")  Long id, Model model){

        Customer customer = new Customer();
        model.addAttribute("apartmentId",id);
        model.addAttribute("customerAttribute", customer);
        return "new_building_order";
    }

    @PostMapping("/order/visit/{id}")
    public String toOrderAnApartment(@PathVariable("id")Long id, @ModelAttribute Customer customer, Model model) {
        customer.setApartment(apartmentService.findApartmentById(id));
        customer.setDateTime(LocalDateTime.now());
        customerService.saveCustomer(customer);
        customerService.sendEmail(customer);
        model.addAttribute("successMessage", "Спасибо за обращение наши сотрудники с вами свяжутся в ближайщее время");
        return "redirect:/main";
    }


}
