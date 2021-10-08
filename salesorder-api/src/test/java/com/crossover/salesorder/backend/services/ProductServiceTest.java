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
import java.util.Map;

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
import com.crossover.salesorder.backend.model.OrderLine;
import com.crossover.salesorder.backend.model.OrderLineId;
import com.crossover.salesorder.backend.model.Product;
import com.crossover.salesorder.backend.repo.ProductRepository;

/**
 * Test case for product service class.
 *
 * @author Simon Ghobreil.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SalesorderBeApplication.class)
@WebAppConfiguration
public class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    private Product product;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Test method for
     * {@link com.crossover.salesorder.backend.services.ProductService#addNewProduct(com.crossover.salesorder.backend.model.Product)}.
     */
    @Test
    public void testAddNewProduct() {
        when(productRepository.save(any(Product.class))).thenAnswer(new Answer<Product>() {
            @Override
            public Product answer(InvocationOnMock invocation) throws Throwable {
                product = (Product) invocation.getArguments()[0];
                product = createProduct();
                return product;
            }
        });

        productService.addNewProduct(new Product());

        assertNotNull(product.getId());
        assertTrue(product.getId() > 0);
    }

    /**
     * Test method for
     * {@link com.crossover.salesorder.backend.services.ProductService#editProduct(com.crossover.salesorder.backend.model.Product)}.
     */
    @Test
    public void testEditProduct() {
        when(productRepository.save(any(Product.class))).thenAnswer(new Answer<Product>() {
            @Override
            public Product answer(InvocationOnMock invocation) throws Throwable {
                product = (Product) invocation.getArguments()[0];
                product = createProduct();
                return product;
            }
        });

        productService.editProduct(product);

        assertNotNull(product.getId());
        assertTrue(product.getId() > 0);
    }

    /**
     * Test method for
     * {@link com.crossover.salesorder.backend.services.ProductService#getProductByCode(int)}.
     */
    @Test
    public void testGetProductByCode() {
        when(productRepository.findByCode(Mockito.anyInt())).thenReturn(createProduct());
        Product product = productService.getProductByCode(123456);
        Assert.assertEquals(product.getCode(), 123456);
    }

    /**
     * Test method for
     * {@link com.crossover.salesorder.backend.services.ProductService#deleteProductByCode(int)}.
     */
    @Test
    public void testDeleteProductByCode() {
        when(productRepository.findByCode(Mockito.anyInt())).thenReturn(createProduct());
        productService.deleteProductByCode(123456);

        verify(productRepository, times(1)).findByCode(123456);
        verify(productRepository, times(1)).delete(product);
        verifyNoMoreInteractions(productRepository);
    }

    /**
     * Test method for
     * {@link com.crossover.salesorder.backend.services.ProductService#getAllProducts()}.
     */
    @Test
    public void testGetAllProducts() {
        when(productRepository.findAll()).thenReturn(getListOfProducts());
        List<Product> product = productService.getAllProducts();
        Assert.assertEquals(product.size(), 1);
    }

    /**
     * Test method for
     * {@link com.crossover.salesorder.backend.services.ProductService#getPriceByCode()}.
     */
    @Test
    public void testGetProductPriceByCode() {
        when(productRepository.getPriceById(1L)).thenReturn(100.5);
        Double price = productService.getPriceById(1L);
        Assert.assertEquals(price, 100.5, 100.5);
    }

    /**
     * Test method for
     * {@link com.crossover.salesorder.backend.services.ProductService#checkQuantityBalance(Long,Integer)}.
     */
    @Test
    public void testCheckQuantityBalance_Success() {
        when(productRepository.findOne(Mockito.anyLong())).thenReturn(createProduct());
        Boolean results = productService.checkQuantityBalance(1L, 4);
        Assert.assertEquals(results, true);
    }

    /**
     * Test method for
     * {@link com.crossover.salesorder.backend.services.ProductService#checkQuantityBalance(Long,Integer)}.
     */
    @Test
    public void testCheckQuantityBalance_Fail() {
        when(productRepository.findOne(Mockito.anyLong())).thenReturn(createProduct());
        Boolean results = productService.checkQuantityBalance(1L, 8);
        Assert.assertEquals(results, false);
    }

    /**
     * Test method for
     * {@link com.crossover.salesorder.backend.services.ProductService#checkOrderLineQuantities(List<OrderLine>)}.
     */
    @Test
    public void testCheckOrderLineQuantities_Sucess() {
        when(productRepository.findOne(Mockito.anyLong())).thenReturn(createProduct());
        Map<Long, Boolean> results = productService.checkOrderLineQuantities(getSalesOrderList());
        Assert.assertTrue(results.containsValue(false));
    }

    /**
     * Test method for
     * {@link com.crossover.salesorder.backend.services.ProductService#checkOrderLineQuantities(List<OrderLine>)}.
     */
    @Test
    public void testCheckMultipleOrderLineQuantities_Sucess() {
        when(productRepository.findOne(1L)).thenReturn(createProduct());
        when(productRepository.findOne(2L)).thenReturn(createProduct2());
        Map<Long, Boolean> results = productService.checkOrderLineQuantities(getSalesOrderList1());
        Assert.assertTrue(results.containsValue(false));
    }

    /**
     * Initiate new product.
     *
     * @return Product
     */
    private Product createProduct() {

        product = new Product();
        product.setCode(123456);
        product.setDesc("desc");
        product.setId(1L);
        product.setPrice(100.5);
        product.setQuantity(5);

        return product;
    }

    /**
     * Initiate new product.
     *
     * @return Product
     */
    private Product createProduct2() {

        product = new Product();
        product.setCode(123452);
        product.setDesc("desc");
        product.setId(2L);
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
        product = new Product();
        product.setCode(123456);
        product.setDesc("desc");
        product.setId(1L);
        product.setPrice(100.5);
        product.setQuantity(5);
        products.add(product);
        return products;
    }

    /**
     * Initiate new product list.
     *
     * @return Product
     */
    private List<OrderLine> getSalesOrderList() {
        List<OrderLine> orderLines = new ArrayList<OrderLine>();

        OrderLine orderLine = new OrderLine();
        orderLine.setQuantity(5);
        orderLine.setOrderLineId(new OrderLineId(0L, 1L));

        OrderLine orderLine2 = new OrderLine();
        orderLine2.setQuantity(8);
        orderLine2.setOrderLineId(new OrderLineId(0L, 2L));

        orderLines.add(orderLine);
        orderLines.add(orderLine2);

        return orderLines;
    }

    /**
     * Initiate new product list.
     *
     * @return Product
     */
    private List<OrderLine> getSalesOrderList1() {
        List<OrderLine> orderLines = new ArrayList<OrderLine>();

        OrderLine orderLine = new OrderLine();
        orderLine.setQuantity(5);
        orderLine.setOrderLineId(new OrderLineId(0L, 1L));

        OrderLine orderLine2 = new OrderLine();
        orderLine2.setQuantity(8);
        orderLine2.setOrderLineId(new OrderLineId(0L, 1L));

        orderLines.add(orderLine);
        orderLines.add(orderLine2);

        return orderLines;
    }

}
