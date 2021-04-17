package com.company.Alina;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Controller {
    private static SessionFactory factory;


    static void connectDatabase(){
        Configuration config = new Configuration();
        config.configure();

        config.addAnnotatedClass(Products.class);


        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
        factory = config.buildSessionFactory(builder.build());
    }
    static List<Products> getAllProducts(){
        List<Products> products = (List<Products>) factory.openSession().createQuery("from Products").list();
        return products;
    }

}
