package com.company;


public class Main {

    public static void main(String[] args) {
	// write your code here
        connectDatabase();
        List<Products> products = getAllProducts();
        for(Product p:products)
            System.out.println(p);
    }
}
