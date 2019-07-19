package com.realestate.site.repositories.advertisement;


import com.realestate.site.models.advertisement.Advertisement;
import com.realestate.site.models.advertisement.enums.DealType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {

    List<Advertisement> findAll();
    List<Advertisement> findAllByDealType(DealType dealType);

}
