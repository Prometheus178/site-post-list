package com.realestate.site.daos.dao.interfaces;




import com.realestate.site.models.new_building.Apartment;
import com.realestate.site.daos.dao.CrudService;

import java.util.List;

public interface ApartmentDAO extends CrudService<Apartment, Long> {

    List<Apartment> findAllByID(long id);
}
