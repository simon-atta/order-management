package com.crossover.salesorder.backend.services;

import java.util.List;

import com.crossover.salesorder.backend.model.Customer;

/**
 * This is contract of customer service.
 *
 * @author Simon Ghobreil.
 */
public interface ICustomerService {

    /**
     * Add new customer.
     *
     * @param customer
     *        Customer
     */
    void addNewCustomer(Customer customer) throws Exception;

    /**
     * Edit customer.
     *
     * @param customer
     *        Customer
     * @return customer after edit.
     */
    Customer editCustomer(Customer customer) throws Exception;

    /**
     * Get customer by code.
     *
     * @param code
     *        int
     * @return customer which match code.
     */
    Customer getCustomerByCode(int code) throws Exception;

    /**
     * Delete customer by code.
     *
     * @param code
     *        int
     */
    void deleteCustomerByCode(int code) throws Exception;

    /**
     * Get all customers.
     *
     * @return list of customers.
     */
    List<Customer> getAllCustomers() throws Exception;


    /**
     * Check if customer eligible for placing order or not.
     *
     * @return list of customers.
     */
    Boolean checkCustomerCreditBalance(Double orderPrice, Long userId);


}
