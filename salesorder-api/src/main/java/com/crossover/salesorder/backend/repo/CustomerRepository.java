package com.crossover.salesorder.backend.repo;

import org.springframework.data.repository.CrudRepository;

import com.crossover.salesorder.backend.model.Customer;

/**
 * Customer repository.
 *
 * @author Simon Ghobreil.
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    /**
     * Find by code will query for customer with specific code.
     *
     * @param code
     *        int
     * @return Customer
     */
    Customer findByCode(int code);

}
