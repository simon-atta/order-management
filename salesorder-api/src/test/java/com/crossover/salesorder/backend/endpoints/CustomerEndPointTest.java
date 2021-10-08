package com.crossover.salesorder.backend.endpoints;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

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
import com.crossover.salesorder.backend.services.ICustomerService;
import com.google.gson.Gson;

/**
 * Home Controller Test Cases.
 *
 * @author Simon Ghobreil.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SalesorderBeApplication.class)
@WebAppConfiguration
public class CustomerEndPointTest {

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    @InjectMocks
    private CustomerEndPoint customerEndPoint;

    @Mock
    private ICustomerService customerService;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(customerEndPoint).build();
    }

    @Test
    public void testGetCustomerByCode() throws Exception {

        when(customerService.getCustomerByCode(Mockito.anyInt())).thenReturn(createNewCustomer());

        mockMvc.perform(get("/api/customers/getCustomerByCode").param("code", "123456")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json")).andExpect(jsonPath("code").value(89898));
    }

    @Test
    public void testGetCustomerByCode_Fail() throws Exception {

        when(customerService.getCustomerByCode(Mockito.anyInt())).thenThrow(new Exception("internal error"));

        mockMvc.perform(get("/api/customers/getCustomerByCode").param("code", "123456"))
                .andExpect(status().isInternalServerError());
    }

    @Test
    public void testGetAllCustomers() throws Exception {

        when(customerService.getAllCustomers()).thenReturn(getListOfCustomers());

        mockMvc.perform(get("/api/customers/getAllCustomers")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json")).andExpect(jsonPath("$[0].code").value(89898));
    }

    @Test
    public void testGetAllCustomers_Fail() throws Exception {

        when(customerService.getAllCustomers()).thenThrow(new Exception("internal error"));

        mockMvc.perform(get("/api/customers/getAllCustomers")).andExpect(status().isInternalServerError());
    }

    @Test
    public void testAddNewCustomer() throws Exception {

        when(customerService.getAllCustomers()).thenReturn(getListOfCustomers());

        Gson gson = new Gson();
        String json = gson.toJson(createNewCustomer());

        mockMvc.perform(post("/api/customers/addNewCustomer").content(json).contentType(contentType))
                .andExpect(status().isOk()).andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].code").value(89898));
    }

    @Test
    public void testAddNewCustomer_Fail() throws Exception {

        when(customerService.getAllCustomers()).thenThrow(new Exception("internal error"));

        Gson gson = new Gson();
        String json = gson.toJson(createNewCustomer());

        mockMvc.perform(post("/api/customers/addNewCustomer").content(json).contentType(contentType))
                .andExpect(status().isInternalServerError());
    }

    @Test
    public void testEditCustomer() throws Exception {

        when(customerService.editCustomer(Mockito.anyObject())).thenReturn(createNewCustomer());

        Gson gson = new Gson();
        String json = gson.toJson(createNewCustomer());

        mockMvc.perform(put("/api/customers/editCustomer").content(json).contentType(contentType))
                .andExpect(status().isOk()).andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("code").value(89898));
    }

    @Test
    public void testEditCustomer_Fail() throws Exception {

        when(customerService.editCustomer(Mockito.anyObject())).thenThrow(new Exception("internal error"));

        Gson gson = new Gson();
        String json = gson.toJson(createNewCustomer());

        mockMvc.perform(put("/api/customers/editCustomer").content(json).contentType(contentType))
                .andExpect(status().isInternalServerError());
    }

    @Test
    public void testDeleteCustomer() throws Exception {

        when(customerService.getAllCustomers()).thenReturn(getListOfCustomers());

        mockMvc.perform(delete("/api/customers/deleteCustomerByCode").param("code", "123456")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json")).andExpect(jsonPath("$[0].code").value(89898));
    }

    @Test
    public void testDeleteCustomer_Fail() throws Exception {

        when(customerService.getAllCustomers()).thenThrow(new Exception("internal error"));

        mockMvc.perform(delete("/api/customers/deleteCustomerByCode").param("code", "123456"))
                .andExpect(status().isInternalServerError());
    }

    private Customer createNewCustomer() {

        Customer customer = new Customer();
        customer.setCode(89898);
        customer.setCurrentCredit(35.5);
        customer.setName("simon");
        customer.setPhoneOne("+201455787");
        return customer;
    }

    /**
     * Initiate new customer list.
     *
     * @return list of customers
     */
    private List<Customer> getListOfCustomers() {
        List<Customer> customers = new ArrayList<Customer>();
        customers.add(createNewCustomer());
        return customers;
    }


}
