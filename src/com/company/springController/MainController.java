package com.company.springController;

import Alina.Products;
import Andrey.Orders;
import Taras.Customers;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

@RestController
public class MainController {
    private static SessionFactory factory;

   @GetMapping("/")
    public ModelAndView getIndex(){
       return new ModelAndView("index" );
    }

    @GetMapping("/products")
    public ModelAndView getProducts(){
        return new ModelAndView("products" );
    }

    @GetMapping("/orders")
    public ModelAndView getOrders(){
        connectDatabase();
        HashMap<String, List<Orders>> model = new HashMap<>();
        model.put("listOrders", getAllOrders());
        return new ModelAndView("orders", model );
    }

    @GetMapping("/customers")
    public ModelAndView getCustomer(){
        connectDatabase();
        HashMap<String, List<Customers>> model = new HashMap<>();
        model.put("listCustomers", getAllCustomers());

       return new ModelAndView("customers", model );
    }

    static void connectDatabase() {
        Configuration config = new Configuration();
        config.configure();

        config.addAnnotatedClass(Products.class);
        config.addAnnotatedClass(Orders.class);
        config.addAnnotatedClass(Customers.class);

        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
        factory = config.buildSessionFactory(builder.build());
    }
    public static List<Products> getAllProducts(){
        List<Products> products = (List<Products>) factory.openSession().createQuery("from Products").list();
        return products;
    }
    public static List<Orders> getAllOrders(){
        List<Orders> orders= (List<Orders>) factory.openSession().createQuery("from Orders").list();
        return orders;
    }
    public static List<Customers> getAllCustomers(){
        List<Customers> customers= (List<Customers>) factory.openSession().createQuery("from Customers").list();
        return customers;
    }



}