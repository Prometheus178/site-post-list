package com.realestate.site.services.new_building.impl;


import com.realestate.site.models.new_building.Apartment;
import com.realestate.site.repositories.new_building.ApartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApartmentService{

    private ApartmentRepository apartmentRepository;

    public ApartmentService(ApartmentRepository apartmentRepository) {
        this.apartmentRepository = apartmentRepository;
    }

    List<Apartment> findAllById(Long id){
        return apartmentRepository.findAllById(id);
    }
}
