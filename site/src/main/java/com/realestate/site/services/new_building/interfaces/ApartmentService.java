package com.realestate.site.services.new_building.interfaces;


import com.realestate.site.models.new_building.Apartment;

import java.util.List;
import java.util.Optional;

public interface ApartmentService{

    List<Apartment> findAllApartment();
    Apartment findApartmentById(Long id);
    Apartment saveApartment(Apartment apartment);
    void deleteApartment(Long id);
    List<Apartment> findAllApartmentById(long id);

}
