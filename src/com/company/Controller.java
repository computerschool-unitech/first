import Alina.Products;
import Andrey.Orders;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Controller {
    private static SessionFactory factory;


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
        List<Orders> Order = (List<Orders>) factory.openSession().createQuery("from Orders").list();
        return Order;
    }



}
