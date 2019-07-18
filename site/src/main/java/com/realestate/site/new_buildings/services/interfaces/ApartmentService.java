package com.realestate.site.new_buildings.services.interfaces;


import com.realestate.site.new_buildings.entities.Apartment;
import com.realestate.site.parent.CrudService;

import java.util.List;

public interface ApartmentService extends CrudService<Apartment, Long> {


    List<Apartment> findAllByID(long id);
}
