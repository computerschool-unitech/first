import Alina.Products;

import java.util.List;

import static Alina.Controller.connectDatabase;
import static Alina.Controller.getAllProducts;

public class Main {
    public static void main(String[] args) {
        connectDatabase();
        List<Products> products = getAllProducts();
        for(Products p:products)
            System.out.println(p);
    }

}
