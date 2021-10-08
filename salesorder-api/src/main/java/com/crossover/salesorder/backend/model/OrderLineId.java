package com.crossover.salesorder.backend.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Order Line ID model class.
 *
 * @author Simon Ghobreil.
 */
@Embeddable
public class OrderLineId implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Column(name = "sales_order_id", nullable = false)
    private Long salesOrderId;

    @Column(name = "prod_id", nullable = false)
    private Long prodId;

    public OrderLineId() {
    }

    /**
     * @param salesOrderId
     * @param prodId
     */
    public OrderLineId(Long salesOrderId, Long prodId) {
        super();
        this.salesOrderId = salesOrderId;
        this.prodId = prodId;
    }

    /**
     * @return the salesOrderId
     */
    public Long getSalesOrderId() {
        return salesOrderId;
    }

    /**
     * @param salesOrderId
     *        the salesOrderId to set
     */
    public void setSalesOrderId(Long salesOrderId) {
        this.salesOrderId = salesOrderId;
    }

    /**
     * @return the prodId
     */
    public Long getProdId() {
        return prodId;
    }

    /**
     * @param prodId
     *        the prodId to set
     */
    public void setProdId(Long prodId) {
        this.prodId = prodId;
    }



    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        OrderLineId other = (OrderLineId) obj;
        if (prodId == null) {
            if (other.prodId != null) return false;
        } else if (!prodId.equals(other.prodId)) return false;
        if (salesOrderId == null) {
            if (other.salesOrderId != null) return false;
        } else if (!salesOrderId.equals(other.salesOrderId)) return false;
        return true;
    }



}
