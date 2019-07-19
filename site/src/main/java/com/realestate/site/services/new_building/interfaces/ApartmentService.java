package com.realestate.site.services.new_building.interfaces;


import com.realestate.site.models.new_building.Apartment;
import com.realestate.site.parent.CrudService;

import java.util.List;

public interface ApartmentService extends CrudService<Apartment, Long> {


    List<Apartment> findAllByID(long id);
}
