//package com.realestate.site.daos.dao;
//
//
//import com.realestate.site.models.advertisements.entities.Post;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//
//@Repository
//public class AdvertisementDAOImpl implements AdvertisementDAO {
//
//    @Autowired
//    private SessionFactory sessionFactory;
//
//
//    public AdvertisementDAOImpl() {
//    }
//
//    @Transactional
//    public List<Post> findAll() {
//        Session session =  this.sessionFactory.getCurrentSession();
//        List<Post> advertisements = session.createNativeQuery("select * from advertisements order by date_time desc ",Post.class).list();
//        return advertisements;
//    }
//
//
//    public Post findById(Long aLong) {
//        Session session = this.sessionFactory.openSession();
//        session.beginTransaction();
//        Post advertisement = session.load(Post.class, aLong);
//        session.getTransaction().commit();
//        return advertisement;
//    }
//
//    @Transactional
//    public Post save(Post object) {
//        Session session = this.sessionFactory.getCurrentSession();
//        session.save(object);
//        return object;
//    }
//
//    @Transactional
//    public void delete(Post object) {
//
//    }
//
//
//    @Transactional
//    public List<Post> findAllSell() {
//        Session session = this.sessionFactory.getCurrentSession();
//        List<Post> advertisements = session.createNativeQuery("select * from advertisements where deal_type='SELL' order by date_time desc ",Post.class).list();
//        return advertisements;
//    }
//
//    @Transactional
//    public List<Post> findAllRent() {
//        Session session = this.sessionFactory.getCurrentSession();
//        List<Post> advertisements = session.createNativeQuery("select * from advertisements where deal_type='RENT' order by date_time desc",Post.class).list();
//        return advertisements;
//    }
//}
