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
import com.crossover.salesorder.backend.model.Product;
import com.crossover.salesorder.backend.services.IProductService;
import com.google.gson.Gson;

/**
 * Home Controller Test Cases.
 *
 * @author Simon Ghobreil.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SalesorderBeApplication.class)
@WebAppConfiguration
public class ProductsEndPointTest {

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    @InjectMocks
    private ProductEndPoint productEndPoint;

    @Mock
    private IProductService productService;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(productEndPoint).build();
    }

    @Test
    public void testGetProductByCode() throws Exception {

        when(productService.getProductByCode(Mockito.anyInt())).thenReturn(getProduct());

        mockMvc.perform(get("/api/products/getProductByCode").param("code", "123456")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json")).andExpect(jsonPath("code").value(123456));
    }

    @Test
    public void testGetProductByCode_Fail() throws Exception {

        when(productService.getProductByCode(Mockito.anyInt())).thenThrow(new Exception("internal error"));

        mockMvc.perform(get("/api/products/getProductByCode").param("code", "123456"))
                .andExpect(status().isInternalServerError());
    }

    @Test
    public void testGetAllProduct() throws Exception {

        when(productService.getAllProducts()).thenReturn(getListOfProducts());

        mockMvc.perform(get("/api/products/getAllProducts")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json")).andExpect(jsonPath("$[0].code").value(123456));
    }

    @Test
    public void testGetAllProduct_Fail() throws Exception {

        when(productService.getAllProducts()).thenThrow(new Exception("internal error"));

        mockMvc.perform(get("/api/products/getAllProducts")).andExpect(status().isInternalServerError());
    }

    @Test
    public void testAddNewProduct() throws Exception {

        when(productService.getAllProducts()).thenReturn(getListOfProducts());

        Gson gson = new Gson();
        String json = gson.toJson(getProduct());

        mockMvc.perform(post("/api/products/addNewProduct").content(json).contentType(contentType))
                .andExpect(status().isOk()).andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].code").value(123456));
    }

    @Test
    public void testAddNewProduct_Fail() throws Exception {

        when(productService.getAllProducts()).thenThrow(new Exception("internal error"));

        Gson gson = new Gson();
        String json = gson.toJson(getProduct());

        mockMvc.perform(post("/api/products/addNewProduct").content(json).contentType(contentType))
                .andExpect(status().isInternalServerError());
    }

    @Test
    public void testEditNewProduct() throws Exception {

        when(productService.editProduct(Mockito.anyObject())).thenReturn(getProduct());

        Gson gson = new Gson();
        String json = gson.toJson(getProduct());

        mockMvc.perform(put("/api/products/editProduct").content(json).contentType(contentType))
                .andExpect(status().isOk()).andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("code").value(123456));
    }

    @Test
    public void testEditNewProduct_Fail() throws Exception {

        when(productService.editProduct(Mockito.anyObject())).thenThrow(new Exception("internal error"));

        Gson gson = new Gson();
        String json = gson.toJson(getProduct());

        mockMvc.perform(put("/api/products/editProduct").content(json).contentType(contentType))
                .andExpect(status().isInternalServerError());
    }

    @Test
    public void testDeleteProduct() throws Exception {

        when(productService.getAllProducts()).thenReturn(getListOfProducts());

        mockMvc.perform(delete("/api/products/deleteProductByCode").param("code", "123456")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json")).andExpect(jsonPath("$[0].code").value(123456));
    }

    @Test
    public void testDeleteProduct_Fail() throws Exception {

        when(productService.getAllProducts()).thenThrow(new Exception("internal error"));

        mockMvc.perform(delete("/api/products/deleteProductByCode").param("code", "123456"))
                .andExpect(status().isInternalServerError());
    }

    @Test
    public void testGetPriceByCode() throws Exception {

        when(productService.getPriceById(Mockito.anyLong())).thenReturn(100.4);

        mockMvc.perform(get("/api/products/getPriceByCode").param("code", "123456")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json")).andExpect(jsonPath("$").value(100.4));
    }

    @Test
    public void testGetPriceByCode_Fail() throws Exception {

        when(productService.getPriceById(Mockito.anyLong())).thenThrow(new Exception("internal error"));

        mockMvc.perform(get("/api/products/getPriceByCode").param("code", "123456"))
                .andExpect(status().isInternalServerError());
    }

    @Test
    public void testCheckProductQuantity() throws Exception {

        when(productService.checkQuantityBalance(Mockito.anyLong(), Mockito.anyInt())).thenReturn(true);

        mockMvc.perform(get("/api/products/checkProductQuantity").param("code", "123456").param("qtn", "1"))
                .andExpect(status().isOk()).andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$").value(true));
    }

    @Test
    public void testCheckProductQuantity_Fail() throws Exception {

        when(productService.checkQuantityBalance(Mockito.anyLong(), Mockito.anyInt()))
                .thenThrow(new Exception("internal error"));

        mockMvc.perform(get("/api/products/checkProductQuantity").param("code", "123456").param("qtn", "1"))
                .andExpect(status().isInternalServerError());
    }

    private Product getProduct() {

        Product product = new Product();
        product.setCode(123456);
        product.setDesc("desc");
        product.setId(1L);
        product.setPrice(100.5);
        product.setQuantity(5);

        return product;
    }

    /**
     * Initiate new product list.
     *
     * @return Product
     */
    private List<Product> getListOfProducts() {
        List<Product> products = new ArrayList<Product>();
        products.add(getProduct());
        return products;
    }

}
