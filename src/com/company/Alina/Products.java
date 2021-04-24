package Alina;

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

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getModel_year() {
        return model_year;
    }

    public void setModel_year(int model_year) {
        this.model_year = model_year;
    }

    public double getList_price() {
        return list_price;
    }

    public void setList_price(double list_price) {
        this.list_price = list_price;
    }
}

