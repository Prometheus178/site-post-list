package com.realestate.site.services.new_building.interfaces;


import com.realestate.site.models.new_building.Apartment;

import java.util.List;

public interface ApartmentService{

    List<Apartment> findAllApartment();
    Apartment findApartmentById(Long id);
    Apartment saveApartment(Apartment apartment);
    void deleteApartment(Apartment apartment);
    List<Apartment> findAllApartmentById(long id);

}
