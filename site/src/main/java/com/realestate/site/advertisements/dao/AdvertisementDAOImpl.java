package com.realestate.site.advertisements.dao;


import com.realestate.site.advertisements.entities.Advertisement;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class AdvertisementDAOImpl implements AdvertisementDAO {

    private SessionFactory sessionFactory;

    public AdvertisementDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public AdvertisementDAOImpl() {
    }

    @Transactional
    public List<Advertisement> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Advertisement> advertisements = session.createNativeQuery("select * from advertisements order by date_time desc ",Advertisement.class).list();
        return advertisements;
    }


    public Advertisement findById(Long aLong) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Advertisement advertisement = session.load(Advertisement.class, aLong);
        session.getTransaction().commit();
        return advertisement;
    }

    @Transactional
    public Advertisement save(Advertisement object) {
        Session session = sessionFactory.getCurrentSession();
        session.save(object);
        return object;
    }

    @Transactional
    public void delete(Advertisement object) {

    }


    @Transactional
    public List<Advertisement> findAllSell() {
        Session session = sessionFactory.getCurrentSession();
        List<Advertisement> advertisements = session.createNativeQuery("select * from advertisements where deal_type='SELL' order by date_time desc ",Advertisement.class).list();
        return advertisements;
    }

    @Transactional
    public List<Advertisement> findAllRent() {
        Session session = sessionFactory.getCurrentSession();
        List<Advertisement> advertisements = session.createNativeQuery("select * from advertisements where deal_type='RENT' order by date_time desc",Advertisement.class).list();
        return advertisements;
    }
}
