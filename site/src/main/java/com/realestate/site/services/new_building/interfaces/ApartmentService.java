package com.realestate.site.services.new_building.interfaces;


import com.realestate.site.models.new_building.Apartment;

import java.util.List;
import java.util.Optional;

public interface ApartmentService{

    Apartment findApartmentById(Long id);
    Apartment saveApartment(Apartment apartment);
    void deleteApartmentById(Long id);
    List<Apartment> findAllApartmentByAddressId(long id);

}
