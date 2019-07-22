package com.realestate.site.services.advetisement.impl;

import com.realestate.site.models.advertisement.Advertisement;
import com.realestate.site.models.advertisement.enums.DealType;
import com.realestate.site.repositories.advertisement.AdvertisementRepository;
import com.realestate.site.services.advetisement.interfaces.AdvertisementService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    private AdvertisementRepository advertisementRepository;

    public AdvertisementServiceImpl(AdvertisementRepository advertisementRepository) {
        this.advertisementRepository = advertisementRepository;
    }
    @Override
    public List<Advertisement> findAllAdvertisementByDateTime(){
        return advertisementRepository.findAll();
    }
    @Override
    public List<Advertisement> findAllAdvertisementByDealType(DealType dealType){
        return advertisementRepository.findAllByDealType(dealType);
    }

    @Override
    public Advertisement findById(Long id) {
        return advertisementRepository.getOne(id);
    }

    @Override
    public void deleteById(Long id) {
        advertisementRepository.deleteById(id);
    }

    @Override
    public Advertisement save(Advertisement advertisement) {
        return null;
    }

    @Override
    public Advertisement updateById(Long id) {
        return null;
    }

}
