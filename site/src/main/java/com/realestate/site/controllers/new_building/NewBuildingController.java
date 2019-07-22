package com.realestate.site.controllers.new_building;


import com.realestate.site.models.new_building.Address;
import com.realestate.site.services.new_building.interfaces.AddressService;
import com.realestate.site.services.new_building.interfaces.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class NewBuildingController {
    @Autowired
    private ApartmentService apartmentService;
    @Autowired
    private AddressService addressService;




    @GetMapping("/address")
    public String addressPage(Model model){
        model.addAttribute("listOfAddress",addressService.findAllAddress());

        return "new_building_address";
    }

    @GetMapping(value = "/address/{id}/apartment")
    public String apartmentPage(@PathVariable("id")  Long id, Model model){
        model.addAttribute("listOfApartment", apartmentService.findAllApartmentById(id));

        return "new_building_apartment";
    }

    @GetMapping("/apartment/{id}/order")
    public String orderPage(@PathVariable("id")  Long id, Model model){
        model.addAttribute("apartment", apartmentService.findApartmentById(id));
        return "new_building_order";
    }

    @GetMapping("/address/{id}/address-image")
    public void renderImageFromDB(@PathVariable("id")  Long id, HttpServletResponse response) throws IOException {
        Address address = addressService.findAddressById(id);
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
