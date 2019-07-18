package com.realestate.site.config;


import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import com.realestate.site.advertisements.entities.Advertisement;
import com.realestate.site.new_buildings.entities.Address;
import com.realestate.site.new_buildings.entities.Apartment;
import com.realestate.site.users.entities.Admin;
import com.realestate.site.users.entities.Customer;
import com.realestate.site.users.entities.User;
import org.hibernate.SessionFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Properties;


@Configuration
@ComponentScan("com.realestate.site")
@EnableWebMvc
@EnableTransactionManagement
public class HibernateConfiguration {

    private static final Logger log = LoggerFactory.getLogger(HibernateConfiguration.class);

    private static Properties getHibernateProperties() {
        final Properties properties = new Properties();
        properties.put("hibernate.show_sql", "true");
        // properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        properties.put("hbm2ddl.auto", "update");
        return properties;
    }

    {
        log.debug("Here am I: {}");
    }

    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/real-estate-site?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }


    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(final DataSource dataSource) {
        final LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
        sessionBuilder.addResource("/META-INF/Advertisement.xml");
        sessionBuilder.addAnnotatedClasses(Advertisement.class);
        sessionBuilder.addResource("/META-INF/Apartment.xml");
        sessionBuilder.addAnnotatedClasses(Apartment.class);
        sessionBuilder.addResource("/META-INF/Address.xml");
        sessionBuilder.addAnnotatedClasses(Address.class);
        sessionBuilder.addResource("/META-INF/Admin.xml");
        sessionBuilder.addAnnotatedClasses(Admin.class);
        sessionBuilder.addResource("/META-INF/Customer.xml");
        sessionBuilder.addAnnotatedClasses(Customer.class);
        sessionBuilder.addResource("/META-INF/User.xml");
        sessionBuilder.addAnnotatedClasses(User.class);
        sessionBuilder.addProperties(getHibernateProperties());
        return sessionBuilder.buildSessionFactory();
    }


    @Bean(name = "transactionManager")
    public HibernateTransactionManager getTransactionManager(final SessionFactory sessionFactory) {
        final HibernateTransactionManager transactionManager = new HibernateTransactionManager(
                sessionFactory);
        return transactionManager;
    }
}
