package com.crossover.salesorder.backend.model;

import static org.springframework.util.Assert.isTrue;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test case for product model class.
 *
 * @author Simon Ghobreil.
 */
public class ProductTest {

    @Test
    public void testNameSetterAndGetter() {
        Product prod = new Product();
        prod.setDesc("prod");
        Assert.assertEquals(prod.getDesc(), "prod");
    }

    @Test
    public void testQuantitySetterAndGetter() {
        Product prod = new Product();
        prod.setQuantity(100);
        Assert.assertEquals(prod.getQuantity(), 100);
        isTrue(prod.getQuantity() > -1, "The value must be greater than zero");
    }

    @Test
    public void testPriceSetterAndGetter() {
        Product prod = new Product();
        prod.setPrice(100.5);
        Assert.assertEquals(prod.getPrice(), 100.5, 100.5);
    }

    @Test
    public void testProductidSetterAndGetter() {
        Product prod = new Product();
        prod.setId(1L);
        Assert.assertEquals(prod.getId(), new Long(1));
    }

}
