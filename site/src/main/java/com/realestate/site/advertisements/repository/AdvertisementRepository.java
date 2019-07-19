package com.realestate.site.advertisements.repository;


import com.realestate.site.advertisements.entities.Advertisement;
import com.realestate.site.advertisements.entities.enums.DealType;
import com.realestate.site.parent.CrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {

    List<Advertisement> findAllByDateTime();
    List<Advertisement> findAllByDealType(DealType dealType);

}
