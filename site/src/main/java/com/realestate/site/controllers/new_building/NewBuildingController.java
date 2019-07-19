package com.realestate.site.controllers.new_building;


import com.realestate.site.models.new_building.Address;
import com.realestate.site.services.new_building.interfaces.AddressService;
import com.realestate.site.services.new_building.interfaces.ApartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class NewBuildingController {

    private ApartmentService apartmentService;
    private AddressService addressService;


    public NewBuildingController(ApartmentService apartmentService, AddressService addressService) {
        this.apartmentService = apartmentService;
        this.addressService = addressService;
    }

    @GetMapping("/address")
    public String addressPage(Model model){
        model.addAttribute("listOfAddress",addressService.findAll());

        return "new_building_address";
    }

    @GetMapping(value = "/address/{id}/apartment")
    public String apartmentPage(@PathVariable("id")  Long id, Model model){
        model.addAttribute("listOfApartment", apartmentService.findAllByID(id));

        return "new_building_apartment";
    }

    @GetMapping("/apartment/{id}/order")
    public String orderPage(@PathVariable("id")  Long id, Model model){
        model.addAttribute("apartment", apartmentService.findById(id));
        return "new_building_order";
    }

    @GetMapping("/address/{id}/address-image")
    public void renderImageFromDB(@PathVariable("id")  Long id, HttpServletResponse response) throws IOException {
        Address address = addressService.findById(id);
        ServletOutputStream outputStream =response.getOutputStream();
        try {
            response.setContentType("image/jpeg");
            byte[] image = address.getImage();

            outputStream.write(image);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            outputStream.close();
        }


    }

}
