package com.realestate.site.services.new_building.impl;

import com.realestate.site.models.new_building.Apartment;
import com.realestate.site.repositories.new_building.ApartmentRepository;
import com.realestate.site.services.new_building.interfaces.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class ApartmentServiceImpl implements ApartmentService {

    @Autowired
    private ApartmentRepository apartmentRepository;


    @Override
    public Apartment findApartmentById(Long id) {
        return apartmentRepository.getOne(id);
    }

    @Override
    public Apartment saveApartment(Apartment apartment) {
        return apartmentRepository.save(apartment);
    }

    @Override
    public void deleteApartmentById(Long id) {
        apartmentRepository.deleteById(id);
    }

    @Override
    public List<Apartment> findAllApartmentByAddressId(long id) {
        return apartmentRepository.findAllApartmentByAddress_Id(id);
    }
}
