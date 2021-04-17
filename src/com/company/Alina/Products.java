package com.company.Alina;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(
        name = "Products"
)
public class Products {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int product_id;
    @Column(
            name = "product_name"
    )
    private String product_name;
    private int brand_id;
    private int category_id;
    private int model_year;
    private double list_price;


    public Products() {
    }

    public Products(int product_id, String product_name, int brand_id, int category_id,
                    int model_year, double list_price) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.brand_id = brand_id;
        this.category_id = category_id;
        this.model_year = model_year;
        this.list_price = list_price;
    }
}

