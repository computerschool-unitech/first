package Taras;
import Alina.Products;
import Andrey.Orders;

import javax.persistence.*;
@Entity
@Table(name = "customers")
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customer_id;

    /*
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    Orders order_id;
    */

    @Column(name="order_id")
    protected int order_id;

    @Column(name="first_name")
    protected String first_name;
    @Column(name="last_name")
    protected String last_name;
    @Column(name="phone")
    protected int phone;
    @Column(name="email")
    protected String email;
    @Column(name="street")
    protected String street;
    @Column(name="city")
    protected String city;
    @Column(name="state")
    protected String state;
    @Column(name="zip_code")
    protected int zip_code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    Products product_id;

    public Products getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Products product_id) {
        this.product_id = product_id;
    }
    public Customers(){}

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip_code() {
        return zip_code;
    }

    public void setZip_code(int zip_code) {
        this.zip_code = zip_code;
    }
}
