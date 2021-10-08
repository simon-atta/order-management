package com.crossover.salesorder.backend.repo;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.SalesorderBeApplication;
import com.crossover.salesorder.backend.model.Customer;
import com.crossover.salesorder.backend.model.OrderLine;
import com.crossover.salesorder.backend.model.OrderLineId;
import com.crossover.salesorder.backend.model.Product;
import com.crossover.salesorder.backend.model.SalesOrder;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SalesorderBeApplication.class)
@WebAppConfiguration
@Ignore
public class OrderLineRepositoryTest {

    @Autowired
    private SalesOrderRepository salesOrderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderLineRepository orderLineRepository;


    @Before
    public void setUp() throws Exception {
        customerRepository.save(createNewCustomer());
        productRepository.save(createNewProduct());
        createNewSalesOrder();
        createOrderLine();
    }


    private List<OrderLine> createOrderLine() {
        SalesOrder salesOrder = salesOrderRepository.findByOrderId("order1234");


        OrderLine orderLine = new OrderLine();
        orderLine.setProduct(productRepository.findByCode(89898));
        orderLine.setQuantity(4);
        orderLine.setSalesOrder(salesOrder);
        orderLine.setOrderLineId(new OrderLineId(salesOrder.getId(), 89898L));

        List<OrderLine> lines = new ArrayList<>();
        lines.add(orderLine);

        orderLineRepository.save(lines);
        return lines;
    }

    private void createNewSalesOrder() {
        SalesOrder salesOrder = new SalesOrder();

        salesOrder.setCustomer(customerRepository.findByCode(89898));
        salesOrder.setOrderId("order1234");
        salesOrder.setTotalPrice(150.5);
        salesOrderRepository.save(salesOrder);
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

    private List<Product> createNewProduct() {

        List<Product> products = new ArrayList<>();
        Product product = new Product();
        product.setCode(89898);
        product.setDesc("desc");
        product.setPrice(100.5);
        product.setQuantity(4);


        products.add(product);
        return products;
    }

    @After
    public void cleanUp() {

        SalesOrder salesOrder = salesOrderRepository.findByOrderId("order1234");

        Product product = productRepository.findByCode(89898);
        Customer customer = customerRepository.findByCode(89898);

        OrderLine lines = orderLineRepository.findOne(new OrderLineId(salesOrder.getId(), product.getId()));

        orderLineRepository.delete(lines.getOrderLineId());
        salesOrderRepository.delete(salesOrder.getId());
        productRepository.delete(product.getId());
        customerRepository.delete(customer.getId());
    }




}