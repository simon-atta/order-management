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
import com.crossover.salesorder.backend.model.SalesOrder;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SalesorderBeApplication.class)
@WebAppConfiguration
public class SalesOrderRepositoryTest {

    @Autowired
    private SalesOrderRepository salesOrderRepository;

    @Autowired
    private CustomerRepository customerRepository;



    @Before
    public void setUp() throws Exception {
        customerRepository.save(createNewCustomer());
        createNewSalesOrder();
    }


    @Test
    public void testFindByOrderId() {
        SalesOrder salesOrder = salesOrderRepository.findByOrderId("order1234");
        Assert.assertEquals(salesOrder.getOrderId(), "order1234");
    }

    private void createNewSalesOrder() {
        SalesOrder salesOrder = new SalesOrder();

        salesOrder.setCustomer(customerRepository.findByCode(89898));
        salesOrder.setOrderId("order1234");
        salesOrder.setTotalPrice(150.5);
        salesOrderRepository.save(salesOrder);
    }


    private List<Customer> createNewCustomer() {

        List<Customer> customers = new ArrayList<Customer>();
        Customer customer = new Customer();
        customer.setCode(89898);
        customer.setCurrentCredit(35.5);
        customer.setName("simon");
        customer.setPhoneOne("+201455787");
        customers.add(customer);
        return customers;
    }


    @After
    public void cleanUp() throws Exception {
        SalesOrder salesOrder = salesOrderRepository.findByOrderId("order1234");
        salesOrderRepository.delete(salesOrder.getId());
        Customer customer = customerRepository.findByCode(89898);
        customerRepository.delete(customer.getId());
    }




}