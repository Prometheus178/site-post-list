package com.realestate.site.new_buildings.services.impl;



import com.realestate.site.new_buildings.dao.interfaces.ApartmentDAO;
import com.realestate.site.new_buildings.entities.Apartment;
import com.realestate.site.new_buildings.services.interfaces.ApartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Component
@Service
public class ApartmentServiceImpl implements ApartmentService {

    private final ApartmentDAO apartmentDAO;


    public ApartmentServiceImpl(ApartmentDAO apartmentDAO) {
        this.apartmentDAO = apartmentDAO;
    }


    @Override
    public List<Apartment> findAll() {
        return apartmentDAO.findAll();
    }

    @Override
    public Apartment findById(Long aLong) {
        return apartmentDAO.findById(aLong);
    }



    @Override
    public Apartment save(Apartment apartment) {
        apartmentDAO.save(apartment);
        return apartment;
    }

    @Override
    public void delete(Apartment object) {
        apartmentDAO.delete(object);
    }


    public List<Apartment> findAllByID(long id) {
        return apartmentDAO.findAllByID(id);
    }
}
