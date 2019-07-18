package com.realestate.site.advertisements.dao;




import com.realestate.site.advertisements.entities.Advertisement;
import com.realestate.site.parent.CrudService;

import java.util.List;

public interface AdvertisementDAO extends CrudService<Advertisement, Long> {

    List<Advertisement> findAllSell();
    List<Advertisement> findAllRent();
}
