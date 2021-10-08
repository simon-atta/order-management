package com.crossover.salesorder.backend.endpoints;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.SalesorderBeApplication;
import com.crossover.salesorder.backend.model.Customer;
import com.crossover.salesorder.backend.model.OrderLine;
import com.crossover.salesorder.backend.model.Product;
import com.crossover.salesorder.backend.model.SalesOrder;
import com.crossover.salesorder.backend.model.exceptions.CreditException;
import com.crossover.salesorder.backend.model.exceptions.QuanityException;
import com.crossover.salesorder.backend.services.ISalesOrderService;
import com.google.gson.Gson;

/**
 * Home Controller Test Cases.
 *
 * @author Simon Ghobreil.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SalesorderBeApplication.class)
@WebAppConfiguration
public class SalesOrderEndPointTest {

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    @InjectMocks
    private SalesOrderEndPoint salesOrderEndPoint;

    @Mock
    private ISalesOrderService salesOrderService;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(salesOrderEndPoint).build();
    }

    @Test
    public void testAddNewOrder() throws Exception {

        when(salesOrderService.getSalesOrderById(Mockito.anyObject())).thenReturn(getSalesOrder());

        Gson gson = new Gson();
        String json = gson.toJson(getSalesOrder());

        mockMvc.perform(post("/api/salesorder/addNewOrder").content(json).contentType(contentType))
                .andExpect(status().isOk()).andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("orderId").value("order123"));
    }

    @Test
    public void testAddNewOrder_CreditException() throws Exception {

        doThrow(CreditException.class).when(salesOrderService).addNewSalesOrder(any(SalesOrder.class));

        Gson gson = new Gson();
        String json = gson.toJson(getSalesOrder());

        mockMvc.perform(post("/api/salesorder/addNewOrder").content(json).contentType(contentType))
                .andExpect(status().isOk()).andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$").value(false));

    }

    @Test
    public void testAddNewOrder_QuanityException() throws Exception {

        Map<Long, Boolean> results = new HashMap<Long, Boolean>();
        results.put(1L, false);

        doThrow(new QuanityException(results)).when(salesOrderService).addNewSalesOrder(any(SalesOrder.class));

        Gson gson = new Gson();
        String json = gson.toJson(getSalesOrder());

        mockMvc.perform(post("/api/salesorder/addNewOrder").content(json).contentType(contentType))
                .andExpect(status().isOk()).andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$").value("1,"));

    }

    @Test
    public void testAddNewOrder_QuanityException_True() throws Exception {

        Map<Long, Boolean> results = new HashMap<Long, Boolean>();
        results.put(1L, false);
        results.put(2L, true);

        doThrow(new QuanityException(results)).when(salesOrderService).addNewSalesOrder(any(SalesOrder.class));

        Gson gson = new Gson();
        String json = gson.toJson(getSalesOrder());

        mockMvc.perform(post("/api/salesorder/addNewOrder").content(json).contentType(contentType))
                .andExpect(status().isOk()).andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$").value("1,"));

    }

    @Test
    public void testGetSalesOrderById() throws Exception {

        when(salesOrderService.getSalesOrderById(Mockito.anyLong())).thenReturn(getSalesOrder());

        mockMvc.perform(get("/api/salesorder/getSalesOrderById").param("id", "123456")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json")).andExpect(jsonPath("orderId").value("order123"));
    }

    @Test
    public void testGetSalesOrderById_Fail() throws Exception {

        when(salesOrderService.getSalesOrderById(Mockito.anyLong())).thenThrow(new Exception("internal error"));

        mockMvc.perform(get("/api/salesorder/getSalesOrderById").param("id", "123456"))
                .andExpect(status().isInternalServerError());
    }

    @Test
    public void testGetSalesOrderByOrderId() throws Exception {

        when(salesOrderService.getSalesOrderByOrderId(Mockito.anyString())).thenReturn(getSalesOrder());

        mockMvc.perform(get("/api/salesorder/getSalesOrderByOrderId").param("orderId", "ord123"))
                .andExpect(status().isOk()).andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("orderId").value("order123"));
    }

    @Test
    public void testGetSalesOrderByOrderId_Fail() throws Exception {

        when(salesOrderService.getSalesOrderByOrderId(Mockito.anyString())).thenThrow(new Exception("internal error"));

        mockMvc.perform(get("/api/salesorder/getSalesOrderByOrderId").param("orderId", "123456"))
                .andExpect(status().isInternalServerError());
    }

    @Test
    public void testGetAllSalesOrders() throws Exception {

        when(salesOrderService.getAllSalesOrders()).thenReturn(getSalesOrderList());

        mockMvc.perform(get("/api/salesorder/getAllSalesOrders")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].orderId").value("order123"));
    }

    @Test
    public void testGetAllSalesOrders_Fail() throws Exception {

        when(salesOrderService.getAllSalesOrders()).thenThrow(new Exception("internal error"));

        mockMvc.perform(get("/api/salesorder/getAllSalesOrders")).andExpect(status().isInternalServerError());
    }

    @Test
    public void testDeleteSalesOrder() throws Exception {

        when(salesOrderService.getAllSalesOrders()).thenReturn(getSalesOrderList());

        mockMvc.perform(delete("/api/salesorder/deleteSalesOrder").param("salesOrderId", "123456"))
                .andExpect(status().isOk()).andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].orderId").value("order123"));
    }

    @Test
    public void testDeleteSalesOrder_Fail() throws Exception {

        when(salesOrderService.getAllSalesOrders()).thenThrow(new Exception("internal error"));

        mockMvc.perform(delete("/api/salesorder/deleteSalesOrder").param("salesOrderId", "123456"))
                .andExpect(status().isInternalServerError());
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

}
