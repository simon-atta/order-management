package com.crossover.salesorder.backend.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test case for order line model class.
 *
 * @author Simon Ghobreil.
 */
public class OrderLineTest {

    @Test
    public void testQuantitySetterAndGetter() {
        OrderLine orderLine = new OrderLine();
        orderLine.setQuantity(10);
        Assert.assertEquals(orderLine.getQuantity(), 10);
    }

    @Test
    public void testOrderLineIdSetterAndGetter() {
        OrderLine orderLine = new OrderLine();
        OrderLineId orderLineId = new OrderLineId(1L, 1L);
        orderLine.setOrderLineId(orderLineId);
        Assert.assertNotNull(orderLine.getOrderLineId());
        Assert.assertEquals(orderLine.getOrderLineId().getProdId(), new Long(1));
        Assert.assertEquals(orderLine.getOrderLineId().getSalesOrderId(), new Long(1));
    }

    @Test
    public void testProductSetterAndGetter() {
        OrderLine orderLine = new OrderLine();
        Product product = new Product();
        product.setCode(159753);
        orderLine.setProduct(product);

        Assert.assertNotNull(orderLine.getProduct());
        Assert.assertEquals(orderLine.getProduct().getCode(), 159753);
    }

}
