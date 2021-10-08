package com.crossover.salesorder.backend.repo;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.SalesorderBeApplication;
import com.crossover.salesorder.backend.model.Customer;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SalesorderBeApplication.class)
@WebAppConfiguration
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Before
    public void setUp() throws Exception {
        customerRepository.save(createNewCustomer());
    }

    @Test
    public void testFindByCode() {
        Customer customer = customerRepository.findByCode(89898);
        Assert.assertEquals(customer.getCode(), 89898);
    }

    private List<Customer> createNewCustomer() {

        List<Customer> customers = new ArrayList<>();
        Customer customer = new Customer();
        customer.setCode(89898);
        customer.setCurrentCredit(35.5);
        customer.setName("simon");
        customer.setPhoneOne("+201455787");
        customers.add(customer);
        return customers;
    }


    @After
    public void cleanUp() {
        Customer customer = customerRepository.findByCode(89898);
        customerRepository.delete(customer.getId());
    }

}