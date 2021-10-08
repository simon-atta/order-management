package com.crossover.salesorder.backend.services;

import java.util.List;

import com.crossover.salesorder.backend.model.SalesOrder;
import com.crossover.salesorder.backend.model.exceptions.CreditException;
import com.crossover.salesorder.backend.model.exceptions.QuanityException;

/**
 * This is contract of sales order service.
 *
 * @author Simon Ghobreil.
 */
public interface ISalesOrderService {

    /**
     * Add new sales order.
     *
     * @param salesOrder
     *        SalesOrder
     */
    void addNewSalesOrder(SalesOrder salesOrder) throws CreditException, QuanityException;

    /**
     * Get sales order by id.
     *
     * @param code
     *        Long
     * @return sales order which match id.
     */
    SalesOrder getSalesOrderById(Long id) throws Exception;

    /**
     * Get all sales orders.
     *
     * @return list with all sales orders.
     */
    List<SalesOrder> getAllSalesOrders() throws Exception;

    /**
     * Get sales order by order id.
     *
     * @param orderId
     *        String
     * @return sales order which match order id.
     */
    SalesOrder getSalesOrderByOrderId(String orderId) throws Exception;

    /**
     * Delete sales order by order id.
     *
     * @param salesOrderId
     */
    void deleteSalesOrderByOrderId(String salesOrderId) throws Exception;

}
