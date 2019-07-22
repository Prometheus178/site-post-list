package com.realestate.site.services.advetisement.interfaces;

import com.realestate.site.models.advertisement.Advertisement;
import com.realestate.site.models.advertisement.enums.DealType;

import java.util.List;

public interface AdvertisementService {

    List<Advertisement> findAllAdvertisementByDateTime();

    List<Advertisement> findAllAdvertisementByDealType(DealType dealType);
    Advertisement findById(Long id);
    void deleteById(Long id);
    Advertisement save(Advertisement advertisement);
    Advertisement updateById(Long id);
}
