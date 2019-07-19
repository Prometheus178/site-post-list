package com.realestate.site.advertisements.services;

import com.realestate.site.advertisements.entities.Advertisement;
import com.realestate.site.advertisements.entities.enums.DealType;
import com.realestate.site.advertisements.repository.AdvertisementRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisementServiceTEST {

    private AdvertisementRepository advertisementRepository;

    public AdvertisementServiceTEST(AdvertisementRepository advertisementRepository) {
        this.advertisementRepository = advertisementRepository;
    }

    public List<Advertisement> findAllByDateTime(){
        return advertisementRepository.findAllByDateTime();
    }
    public List<Advertisement> findAllByDealType(DealType dealType){
        return advertisementRepository.findAllByDealType(dealType);
    }

}
