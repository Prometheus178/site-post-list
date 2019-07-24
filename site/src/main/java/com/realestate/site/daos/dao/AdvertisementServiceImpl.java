//package com.realestate.site.advertisements.services;
//
//import com.realestate.site.daos.dao.AdvertisementDAO;
//import com.realestate.site.models.advertisements.entities.Post;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//import java.util.Collections;
//import java.util.List;
//
//@Service
//public class PostServiceImpl implements PostService {
//
//
//    private AdvertisementDAO advertisementDAO;
//
//    public PostServiceImpl(AdvertisementDAO advertisementDAO) {
//        this.advertisementDAO = advertisementDAO;
//    }
//
//    @Override
//    public List<Post> findAll() {
//        return advertisementDAO.findAll();
//    }
//    @Override
//    public Post findById(Long aLong) {
//        return advertisementDAO.findById(aLong);
//    }
//
//    @Override
//    public Post save(Post object) {
//        advertisementDAO.save(object);
//        return object;
//    }
//
//    @Override
//    public void delete(Post object) {
//        advertisementDAO.delete(object);
//    }
//
//    @Override
//    public Page<Post> findPaginated(Pageable pageable) {
//        int pageSize = pageable.getPageSize();
//        int currentPage = pageable.getPageNumber();
//        int startItem = currentPage * pageSize;
//        List<Post> list;
//        int sizeOfListAdvertisement = advertisementDAO.findAll().size();
//        if (sizeOfListAdvertisement < startItem){
//            list = Collections.emptyList();
//        }else {
//            int toIndex = Math.min(startItem + pageSize, sizeOfListAdvertisement);
//            list = advertisementDAO.findAll().subList(startItem, toIndex);
//        }
//        Page<Post> advertisementPage = new PageImpl<Post>(list, PageRequest.of(currentPage,pageSize), sizeOfListAdvertisement);
//        return advertisementPage;
//
//    }
//
//    @Override
//    public List<Post> findAllSell() {
//        return advertisementDAO.findAllSell();
//    }
//
//    @Override
//    public List<Post> findAllRent() {
//        return advertisementDAO.findAllRent();
//    }
//}
