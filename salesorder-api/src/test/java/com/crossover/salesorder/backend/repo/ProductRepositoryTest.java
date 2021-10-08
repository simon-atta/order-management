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
import com.crossover.salesorder.backend.model.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SalesorderBeApplication.class)
@WebAppConfiguration
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    private List<Product> products;

    @Before
    public void setUp() throws Exception {
        productRepository.save(createNewProduct());
    }

    @Test
    public void testFindByCode() {
        Product product = productRepository.findByCode(89898);
        Assert.assertEquals(product.getCode(), 89898);
    }

    @Test
    public void testPriceByCode() {
        Double price = productRepository.getPriceById(products.get(0).getId());
        Assert.assertEquals(price, 100.5,100.5);
    }

    private List<Product> createNewProduct() {

        products = new ArrayList<>();
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
        Product product = productRepository.findByCode(89898);
        productRepository.delete(product.getId());
    }

}