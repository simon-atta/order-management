package com.crossover.salesorder.backend.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Order Line model class.
 *
 * @author Simon Ghobreil.
 */
@Entity
@Table(name = "order_line")
public class OrderLine {

    @Column(name = "quantity")
    private int quantity;

    @EmbeddedId
    private OrderLineId orderLineId;

    @ManyToOne(optional = false, fetch = FetchType.EAGER, targetEntity = SalesOrder.class)
    @MapsId("salesOrderId")
    private SalesOrder salesOrder;

    @ManyToOne(optional = false, fetch = FetchType.EAGER, targetEntity = Product.class)
    @MapsId("prodId")
    private Product product;

    /**
     * @return the salesOrder
     */
    @JsonIgnore
    public SalesOrder getSalesOrder() {
        return salesOrder;
    }

    /**
     * @param salesOrder
     *        the salesOrder to set
     */
    public void setSalesOrder(SalesOrder salesOrder) {
        this.salesOrder = salesOrder;
    }

    /**
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * @param product
     *        the product to set
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity
     *        the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the orderLineId
     */
    public OrderLineId getOrderLineId() {
        return orderLineId;
    }

    /**
     * @param orderLineId
     *        the orderLineId to set
     */
    public void setOrderLineId(OrderLineId orderLineId) {
        this.orderLineId = orderLineId;
    }

}
