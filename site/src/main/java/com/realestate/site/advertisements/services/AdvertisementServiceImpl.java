package com.realestate.site.advertisements.services;

import com.realestate.site.advertisements.dao.AdvertisementDAO;
import com.realestate.site.advertisements.entities.Advertisement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {


    private AdvertisementDAO advertisementDAO;

    public AdvertisementServiceImpl(AdvertisementDAO advertisementDAO) {
        this.advertisementDAO = advertisementDAO;
    }

    @Override
    public List<Advertisement> findAll() {
        return advertisementDAO.findAll();
    }
    @Override
    public Advertisement findById(Long aLong) {
        return advertisementDAO.findById(aLong);
    }

    @Override
    public Advertisement save(Advertisement object) {
        advertisementDAO.save(object);
        return object;
    }

    @Override
    public void delete(Advertisement object) {
        advertisementDAO.delete(object);
    }

    @Override
    public Page<Advertisement> findPaginated(Pageable pageable) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Advertisement> list;
        int sizeOfListAdvertisement = advertisementDAO.findAll().size();
        if (sizeOfListAdvertisement < startItem){
            list = Collections.emptyList();
        }else {
            int toIndex = Math.min(startItem + pageSize, sizeOfListAdvertisement);
            list = advertisementDAO.findAll().subList(startItem, toIndex);
        }
        Page<Advertisement> advertisementPage = new PageImpl<Advertisement>(list, PageRequest.of(currentPage,pageSize), sizeOfListAdvertisement);
        return advertisementPage;

    }

    @Override
    public List<Advertisement> findAllSell() {
        return advertisementDAO.findAllSell();
    }

    @Override
    public List<Advertisement> findAllRent() {
        return advertisementDAO.findAllRent();
    }
}
