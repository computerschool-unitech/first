import Alina.Products;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        Controller.connectDatabase();
        List<Products> products = Controller.getAllProducts();
        for(Products p:products)
            System.out.println(p);
    }

}
