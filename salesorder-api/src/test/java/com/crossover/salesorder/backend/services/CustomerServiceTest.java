package com.crossover.salesorder.backend.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.SalesorderBeApplication;
import com.crossover.salesorder.backend.model.Customer;
import com.crossover.salesorder.backend.repo.CustomerRepository;

/**
 * @author simon-pc
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SalesorderBeApplication.class)
@WebAppConfiguration
public class CustomerServiceTest {

    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    private Customer customer;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Test method for
     * {@link com.crossover.salesorder.backend.services.CustomerService#addNewCustomer(com.crossover.salesorder.backend.model.Customer)}.
     * @throws Exception
     */
    @Test
    public void testAddNewCustomer() throws Exception {
        when(customerRepository.save(any(Customer.class))).thenAnswer(new Answer<Customer>() {
            @Override
            public Customer answer(InvocationOnMock invocation) throws Throwable {
                customer = (Customer) invocation.getArguments()[0];
                customer = createNewCustomer();
                return customer;
            }
        });

        customerService.addNewCustomer(new Customer());

        assertNotNull(customer.getCode());
        assertTrue(customer.getCode() > 0);
    }

    /**
     * Test method for
     * {@link com.crossover.salesorder.backend.services.CustomerService#editCustomer(com.crossover.salesorder.backend.model.Customer)}.
     * @throws Exception
     */
    @Test
    public void testEditCustomer() throws Exception {
        when(customerRepository.save(any(Customer.class))).thenAnswer(new Answer<Customer>() {
            @Override
            public Customer answer(InvocationOnMock invocation) throws Throwable {
                customer = (Customer) invocation.getArguments()[0];
                customer = createNewCustomer();
                return customer;
            }
        });

        customerService.editCustomer(new Customer());

        assertNotNull(customer.getCode());
        assertTrue(customer.getCode() > 0);
    }

    /**
     * Test method for
     * {@link com.crossover.salesorder.backend.services.CustomerService#getCustomerByCode(int)}.
     * @throws Exception
     */
    @Test
    public void testGetCustomerByCode() throws Exception {
        when(customerRepository.findByCode(Mockito.anyInt())).thenReturn(createNewCustomer());
        Customer customer = customerService.getCustomerByCode(2121);
        Assert.assertEquals(customer.getCode(), 89898);
    }

    /**
     * Test method for
     * {@link com.crossover.salesorder.backend.services.CustomerService#deleteCustomerByCode(int)}.
     * @throws Exception
     */
    @Test
    public void testDeleteCustomerByCode() throws Exception {
        when(customerRepository.findByCode(Mockito.anyInt())).thenReturn(createNewCustomer());
        customerService.deleteCustomerByCode(89898);

        verify(customerRepository, times(1)).findByCode(89898);
        verify(customerRepository, times(1)).delete(customer);
        verifyNoMoreInteractions(customerRepository);
    }

    /**
     * Test method for
     * {@link com.crossover.salesorder.backend.services.CustomerService#getAllCustomers()}.
     * @throws Exception
     */
    @Test
    public void testGetAllCustomers() throws Exception {
        when(customerRepository.findAll()).thenReturn(getListOfCustomers());
        List<Customer> customers = customerService.getAllCustomers();
        Assert.assertEquals(customers.size(), 1);
    }

    /**
     * Test method for
     * {@link com.crossover.salesorder.backend.services.CustomerService#checkCustomerCreditBalance(double,long)}.
     *
     */
    @Test
    public void checkCustomerCreditBalance_Success() throws Exception{
        when(customerRepository.findOne(Mockito.anyLong())).thenReturn(createNewCustomer());
        Boolean results = customerService.checkCustomerCreditBalance(40.0, 1L);
        Assert.assertEquals(results, true);
    }

    /**
     * Test method for
     * {@link com.crossover.salesorder.backend.services.CustomerService#checkCustomerCreditBalance(double,long)}.
     *
     */
    @Test
    public void checkCustomerCreditBalance_Fail() {
        when(customerRepository.findOne(Mockito.anyLong())).thenReturn(createNewCustomer());
        Boolean results = customerService.checkCustomerCreditBalance(200.0, 1L);
        Assert.assertEquals(results, false);
    }


    private Customer createNewCustomer() {

        customer = new Customer();
        customer.setCode(89898);
        customer.setCurrentCredit(35.5);
        customer.setCreditLimit(100.000);
        customer.setName("simon");
        customer.setPhoneOne("+201455787");
        return customer;
    }

    /**
     * Initiate new product list.
     *
     * @return Product
     */
    private List<Customer> getListOfCustomers() {
        List<Customer> customers = new ArrayList<Customer>();
        customers.add(customer);
        return customers;
    }

}
