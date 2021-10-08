package com.crossover.salesorder.backend.repo;

import org.springframework.data.repository.CrudRepository;

import com.crossover.salesorder.backend.model.SalesOrder;

/**
 * Sales Order repository.
 *
 * @author Simon Ghobreil.
 */
public interface SalesOrderRepository extends CrudRepository<SalesOrder, Long> {

    /**
     * Find sales order by sales order id.
     *
     * @param orderId
     *        String
     * @return SalesOrder
     */
    SalesOrder findByOrderId(String orderId);
}
