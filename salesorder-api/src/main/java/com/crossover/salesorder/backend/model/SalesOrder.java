package com.crossover.salesorder.backend.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Sales order model class.
 *
 * @author Simon Ghobreil.
 */
@Entity
@Table(name = "sales_order")
public class SalesOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "so_id")
    private Long id;

    @Column(name = "so_total_price")
    private Double totalPrice;

    @Column(name = "so_order_id", unique = true, nullable = true)
    private String orderId;

    @OneToMany(mappedBy = "salesOrder", fetch = FetchType.EAGER)
    private List<OrderLine> orderLines;

    @ManyToOne(optional = false, fetch = FetchType.EAGER, targetEntity = Customer.class)
    private Customer customer;

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

    /**
     * @return the orderLines
     */
    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    /**
     * @param orderLines
     *        the orderLines to set
     */
    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    /**
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer
     *        the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * @return the totalPrice
     */
    public Double getTotalPrice() {
        return totalPrice;
    }

    /**
     * @param totalPrice
     *        the totalPrice to set
     */
    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * @return the orderId
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * @param orderId
     *        the orderId to set
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

}
