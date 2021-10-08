package com.crossover.salesorder.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crossover.salesorder.backend.model.Customer;
import com.crossover.salesorder.backend.repo.CustomerRepository;

/**
 * This is concrete implementation of {@link ICustomerService}
 *
 * @author Simon Ghobreil.
 */
@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    /*
     * (non-Javadoc)
     * @see
     * com.crossover.salesorder.backend.services.ICustomerService#addNewCustomer
     * (com.crossover.salesorder.backend.model.Customer)
     */
    @Override
    public void addNewCustomer(Customer customer) throws Exception {
        customerRepository.save(customer);
    }

    /*
     * (non-Javadoc)
     * @see
     * com.crossover.salesorder.backend.services.ICustomerService#editCustomer(
     * com.crossover.salesorder.backend.model.Customer)
     */
    @Override
    public Customer editCustomer(Customer customer) throws Exception {
        return customerRepository.save(customer);
    }

    /*
     * (non-Javadoc)
     * @see com.crossover.salesorder.backend.services.ICustomerService#
     * getCustomerByCode(int)
     */
    @Override
    public Customer getCustomerByCode(int code) throws Exception {
        return customerRepository.findByCode(code);
    }

    /*
     * (non-Javadoc)
     * @see com.crossover.salesorder.backend.services.ICustomerService#
     * deleteCustomerByCode(int)
     */
    @Override
    public void deleteCustomerByCode(int code) throws Exception {
        Customer customer = customerRepository.findByCode(code);
        customerRepository.delete(customer);
    }

    /*
     * (non-Javadoc)
     * @see com.crossover.salesorder.backend.services.ICustomerService#
     * getAllCustomers()
     */
    @Override
    public List<Customer> getAllCustomers() throws Exception {
        return (List<Customer>) customerRepository.findAll();
    }

    /*
     * (non-Javadoc)
     * @see com.crossover.salesorder.backend.services.ICustomerService#
     * checkCustomerCreditBalance(Double,Long)
     */
    @Override
    public Boolean checkCustomerCreditBalance(Double orderPrice, Long userId) {
        Customer customer = customerRepository.findOne(userId);

        Double custBalance = customer.getCreditLimit() - customer.getCurrentCredit();

        if (orderPrice <= custBalance)
            return true;
        else
            return false;
    }

}
