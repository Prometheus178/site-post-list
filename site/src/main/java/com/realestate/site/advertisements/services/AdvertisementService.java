package com.realestate.site.advertisements.services;


import com.realestate.site.advertisements.entities.Advertisement;
import com.realestate.site.parent.CrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface AdvertisementService extends CrudService<Advertisement, Long> {

    Page<Advertisement> findPaginated(Pageable pageable);
    List<Advertisement> findAllSell();
    List<Advertisement> findAllRent();


}
