package Andrey;
import Alina.Products;
import Taras.Customers;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int order_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    Customers customer_id;



    /*@Column(name = "customer_id")
    protected int customer_id;

     */


    @Column(name = "order_status")
    protected int order_status;
    @Column(name = "order_date")
    protected Date order_date;
    @Column(name = "required_date")
    protected  Date required_date;
    @Column(name = "shipped_date")
    protected Date shipped_date;




   @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
   Products product_id;



    /*@Column(name = "product_id")
    protected int product_id;

     */


    public Orders() {
    }


    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public Customers getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Customers customer_id) {
        this.customer_id = customer_id;
    }

    public int getOrder_status() {
        return order_status;
    }

    public void setOrder_status(int order_status) {
        this.order_status = order_status;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public Date getRequired_date() {
        return required_date;
    }

    public void setRequired_date(Date required_date) {
        this.required_date = required_date;
    }

    public Date getShipped_date() {
        return shipped_date;
    }

    public void setShipped_date(Date shipped_date) {
        this.shipped_date = shipped_date;
    }

    public Products getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Products product_id) {
        this.product_id = product_id;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "order_id=" + order_id +
                ", customer_id=" + customer_id +
                ", order_status=" + order_status +
                ", order_date='" + order_date + '\'' +
                ", required_date='" + required_date + '\'' +
                ", shipped_date='" + shipped_date + '\'' +
                ", product_id=" + product_id +
                '}';
    }

}
