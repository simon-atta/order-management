package com.crossover.salesorder.backend.repo;

import org.springframework.data.repository.CrudRepository;

import com.crossover.salesorder.backend.model.OrderLine;
import com.crossover.salesorder.backend.model.OrderLineId;

/**
 * Order Line repository.
 *
 * @author Simon Ghobreil.
 */
public interface OrderLineRepository extends CrudRepository<OrderLine, OrderLineId> {

}
