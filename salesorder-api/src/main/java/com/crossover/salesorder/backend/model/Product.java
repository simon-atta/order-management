package com.crossover.salesorder.backend.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Product model class.
 *
 * @author Simon Ghobreil.
 */
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "prod_id")
    private Long id;

    @Column(name = "prod_code", unique = true, nullable = true)
    private int code;
    @Column(name = "prod_desc")
    private String desc;
    @Column(name = "prod_quantity")
    private int quantity;
    @Column(name = "prod_price")
    private double price;

    @OneToMany(mappedBy = "product")
    private List<OrderLine> orderLines;

    /**
     * Setter for name field.
     *
     * @param name
     */
    public void setDesc(String name) {
        this.desc = name;
    }

    /**
     * @return the name
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Setter for quantity field.
     *
     * @param quantity
     *        int
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Setter for price field.
     *
     * @param price
     *        double
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @return the productId
     */
    public int getCode() {
        return code;
    }

    /**
     * @param productId
     *        the productId to set
     */
    public void setCode(int productId) {
        this.code = productId;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     *        the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

}
