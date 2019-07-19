package com.realestate.site.services.advetisement;

import com.realestate.site.models.advertisement.Advertisement;
import com.realestate.site.models.advertisement.enums.DealType;
import com.realestate.site.repositories.advertisement.AdvertisementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisementServiceTEST {

    private AdvertisementRepository advertisementRepository;

    public AdvertisementServiceTEST(AdvertisementRepository advertisementRepository) {
        this.advertisementRepository = advertisementRepository;
    }

    public List<Advertisement> findAllByDateTime(){
        return advertisementRepository.findAll();
    }
    public List<Advertisement> findAllByDealType(DealType dealType){
        return advertisementRepository.findAllByDealType(dealType);
    }

}
