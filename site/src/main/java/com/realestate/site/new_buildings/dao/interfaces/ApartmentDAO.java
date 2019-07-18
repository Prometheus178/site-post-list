package com.realestate.site.new_buildings.dao.interfaces;




import com.realestate.site.new_buildings.entities.Apartment;
import com.realestate.site.parent.CrudService;

import java.util.List;

public interface ApartmentDAO extends CrudService<Apartment, Long> {

    List<Apartment> findAllByID(long id);
}
