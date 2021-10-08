package com.crossover.salesorder.backend.services;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.SalesorderBeApplication;
import com.crossover.salesorder.backend.model.Customer;
import com.crossover.salesorder.backend.model.OrderLine;
import com.crossover.salesorder.backend.model.OrderLineId;
import com.crossover.salesorder.backend.model.Product;
import com.crossover.salesorder.backend.model.SalesOrder;
import com.crossover.salesorder.backend.model.exceptions.CreditException;
import com.crossover.salesorder.backend.model.exceptions.QuanityException;
import com.crossover.salesorder.backend.repo.CustomerRepository;
import com.crossover.salesorder.backend.repo.OrderLineRepository;
import com.crossover.salesorder.backend.repo.ProductRepository;
import com.crossover.salesorder.backend.repo.SalesOrderRepository;

/**
 * Test case for sales order service class.
 *
 * @author Simon Ghobreil.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SalesorderBeApplication.class)
@WebAppConfiguration
public class SalesOrderServiceTest {

    @InjectMocks
    private SalesOrderService salesOrderService;

    @Mock
    private ICustomerService customerService;

    @Mock
    private IProductService productService;

    @Mock
    private SalesOrderRepository salesOrderRepository;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private OrderLineRepository orderLineRepository;

    @Captor
    ArgumentCaptor<SalesOrder> captor;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Test method for
     * {@link com.crossover.salesorder.backend.services.SalesOrderService#addNewSalesOrder(SalesOrder)}.
     *
     * @throws QuanityException
     * @throws CreditException
     */
    @Test(expected = CreditException.class)
    public void testAddNewSalesOrder_Fail_Balance() throws CreditException, QuanityException {
        when(customerService.checkCustomerCreditBalance(Mockito.anyDouble(), Mockito.anyLong())).thenReturn(false);
        salesOrderService.addNewSalesOrder(getSalesOrder());
    }

    /**
     * Test method for
     * {@link com.crossover.salesorder.backend.services.SalesOrderService#addNewSalesOrder(SalesOrder)}.
     *
     * @throws QuanityException
     * @throws CreditException
     */
    @Test(expected = QuanityException.class)
    public void testAddNewSalesOrder_Fail_Quanity() throws CreditException, QuanityException {
        when(customerService.checkCustomerCreditBalance(Mockito.anyDouble(), Mockito.anyLong())).thenReturn(true);
        when(productService.checkOrderLineQuantities(Mockito.anyList())).thenReturn(getResultsFail());
        salesOrderService.addNewSalesOrder(getSalesOrder());
    }

    /**
     * Test method for
     * {@link com.crossover.salesorder.backend.services.SalesOrderService#addNewSalesOrder(SalesOrder)}.
     *
     * @throws QuanityException
     * @throws CreditException
     */
    @Test
    public void testAddNewSalesOrder_Save() throws CreditException, QuanityException {
        when(customerService.checkCustomerCreditBalance(Mockito.anyDouble(), Mockito.anyLong())).thenReturn(true);
        when(productService.checkOrderLineQuantities(Mockito.anyList())).thenReturn(getResultsSuccess());
        when(salesOrderRepository.findByOrderId(Mockito.anyString())).thenReturn(null);
        when(productRepository.findOne(Mockito.anyLong())).thenReturn(createProduct());
        when(customerRepository.findOne(Mockito.anyLong())).thenReturn(createNewCustomer());

        salesOrderService.addNewSalesOrder(getSalesOrder());

        verify(salesOrderRepository, times(1)).save(captor.capture());

        Assert.assertEquals(captor.getValue().getOrderId(), "order123");
    }

    /**
     * Test method for
     * {@link com.crossover.salesorder.backend.services.SalesOrderService#addNewSalesOrder(SalesOrder)}.
     *
     * @throws QuanityException
     * @throws CreditException
     */
    @Test
    public void testAddNewSalesOrder_Edit() throws CreditException, QuanityException {
        when(customerService.checkCustomerCreditBalance(Mockito.anyDouble(), Mockito.anyLong())).thenReturn(true);
        when(productService.checkOrderLineQuantities(Mockito.anyList())).thenReturn(getResultsSuccess());
        when(salesOrderRepository.findByOrderId(Mockito.anyString())).thenReturn(getSalesOrder());
        when(productRepository.findOne(Mockito.anyLong())).thenReturn(createProduct());
        when(customerRepository.findOne(Mockito.anyLong())).thenReturn(createNewCustomer());

        salesOrderService.addNewSalesOrder(getEditedSalesOrder());

        verify(salesOrderRepository, times(1)).save(captor.capture());

        Assert.assertEquals(captor.getValue().getOrderId(), "order1234");
    }

    /**
     * Test method for
     * {@link com.crossover.salesorder.backend.services.SalesOrderService#getSalesOrderById(Long)}.
     */
    @Test
    public void testGetSalesOrderById() {
        when(salesOrderRepository.findOne(1L)).thenReturn(getSalesOrder());
        SalesOrder salesOrder = salesOrderService.getSalesOrderById(1L);
        Assert.assertEquals(salesOrder.getOrderId(), "order123");
    }

    /**
     * Test method for
     * {@link com.crossover.salesorder.backend.services.SalesOrderService#getAllSalesOrders()}.
     */
    @Test
    public void testGetAllSalesOrders() {
        when(salesOrderRepository.findAll()).thenReturn(getSalesOrderList());
        List<SalesOrder> salesOrders = salesOrderService.getAllSalesOrders();
        Assert.assertEquals(salesOrders.size(), 1);
    }

    /**
     * Test method for
     * {@link com.crossover.salesorder.backend.services.SalesOrderService#getSalesOrderByOrderId(String)}.
     */
    @Test
    public void testGetSalesOrderByOrderId() {
        when(salesOrderRepository.findByOrderId(Mockito.anyString())).thenReturn(getSalesOrder());
        SalesOrder salesOrder = salesOrderService.getSalesOrderByOrderId("order123");
        Assert.assertEquals(salesOrder.getOrderId(), "order123");
    }

    /**
     * Test method for
     * {@link com.crossover.salesorder.backend.services.SalesOrderService#getSalesOrderByOrderId(String)}.
     */
    @Test
    public void testDeleteSalesOrderByOrderId() throws Exception {

        SalesOrder salesOrder = getSalesOrder();
        when(salesOrderRepository.findByOrderId(Mockito.anyString())).thenReturn(salesOrder);
        salesOrderService.deleteSalesOrderByOrderId("order112");

        verify(salesOrderRepository, times(1)).findByOrderId("order112");
        verify(salesOrderRepository, times(1)).delete(salesOrder);
        verifyNoMoreInteractions(salesOrderRepository);
    }

    private SalesOrder getEditedSalesOrder() {

        SalesOrder salesOrder = new SalesOrder();
        salesOrder.setCustomer(new Customer());
        salesOrder.setOrderId("order1234");
        salesOrder.setTotalPrice(150.4);
        salesOrder.setOrderLines(getEditedOrderLines());
        return salesOrder;
    }

    private SalesOrder getSalesOrder() {

        SalesOrder salesOrder = new SalesOrder();
        salesOrder.setCustomer(new Customer());
        salesOrder.setOrderId("order123");
        salesOrder.setTotalPrice(150.4);
        salesOrder.setOrderLines(getOrderLines());
        return salesOrder;
    }

    private List<SalesOrder> getSalesOrderList() {

        List<SalesOrder> salesOrders = new ArrayList<SalesOrder>();

        salesOrders.add(getSalesOrder());
        return salesOrders;
    }

    private List<OrderLine> getOrderLines() {

        List<OrderLine> orderLines = new ArrayList<OrderLine>();
        OrderLine orderLine = new OrderLine();
        orderLine.setQuantity(10);
        orderLine.setProduct(createProduct());
        orderLine.setOrderLineId(new OrderLineId(null, 1L));

        orderLines.add(orderLine);
        return orderLines;
    }

    private List<OrderLine> getEditedOrderLines() {

        List<OrderLine> orderLines = new ArrayList<OrderLine>(getOrderLines());
        OrderLine orderLine = new OrderLine();
        orderLine.setQuantity(4);
        orderLine.setProduct(createProduct2());
        orderLine.setOrderLineId(new OrderLineId(null, 2L));

        orderLines.add(orderLine);
        return orderLines;
    }

    private Product createProduct() {

        Product product = new Product();
        product.setCode(123456);
        product.setDesc("desc");
        product.setId(1L);
        product.setPrice(100.5);
        product.setQuantity(5);

        return product;
    }

    private Product createProduct2() {

        Product product = new Product();
        product.setCode(123426);
        product.setDesc("desc");
        product.setId(2L);
        product.setPrice(100.5);
        product.setQuantity(5);

        return product;
    }

    private Map<Long, Boolean> getResultsFail() {
        Map<Long, Boolean> map = new HashMap<Long, Boolean>();
        map.put(1L, false);
        return map;
    }

    private Map<Long, Boolean> getResultsSuccess() {
        Map<Long, Boolean> map = new HashMap<Long, Boolean>();
        map.put(1L, true);
        return map;
    }

    private Customer createNewCustomer() {

        Customer customer = new Customer();
        customer.setCode(89898);
        customer.setCurrentCredit(35.5);
        customer.setCreditLimit(100.000);
        customer.setName("simon");
        customer.setPhoneOne("+201455787");
        return customer;
    }

}
