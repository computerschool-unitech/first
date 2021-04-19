package com.company.springController;


import Alina.Products;
import Andrey.Orders;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

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
        return new ModelAndView("orders" );
    }

    @GetMapping("/customers")
    public ModelAndView getCustomer(){
        return new ModelAndView("customers" );
    }

    public static void connectDatabase(){
        Configuration config = new Configuration();
        config.configure();

        config.addAnnotatedClass(Products.class);
        config.addAnnotatedClass(Orders.class);

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





/*
    @GetMapping("/")
    public ModelAndView getIndex() {
        connectDatabase();
        HashMap<String, List<Clothes>> model = new HashMap<>();
        model.put("listClothes", getAllClothes());
        return new ModelAndView("index", model);
    }

    @GetMapping("/prod")
    public ModelAndView getProd() {
        connectDatabase();
        HashMap<String, List<Clothes>> model = new HashMap<>();
        model.put("listClothes", getAllClothes());
        return new ModelAndView("products", model);
    }

    @GetMapping("/prods")
    public String getProdsTo() {
        connectDatabase();
        ArrayList<Clothes> clothes = (ArrayList<Clothes>) getAllClothes();
        String s = "";
        for (Clothes c : clothes){
            s = s + c.toString() + "<br>";
        }
        return s;
    }

    @RequestMapping(value = "/prods/{id}")
    public String selProds(@PathVariable Integer id){
        connectDatabase();
        ArrayList<Clothes> clothes = (ArrayList<Clothes>) getAllClothes();
        return clothes.get(id).toString();
    }

    static void connectDatabase() {
        Configuration config = new Configuration();
        config.configure();

        config.addAnnotatedClass(Group.class);
        config.addAnnotatedClass(Clothes.class);

        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
        factory = config.buildSessionFactory(builder.build());
    }

     */


}