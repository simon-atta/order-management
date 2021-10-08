package com.crossover.salesorder.backend.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test case for order line id model class.
 *
 * @author Simon Ghobreil.
 */
public class OrderLineIdTest {

    @Test
    public void testSetterAndGetter() {
        OrderLineId orderLineId = new OrderLineId();
        orderLineId.setProdId(1l);
        orderLineId.setSalesOrderId(1l);
        Assert.assertEquals(orderLineId.getProdId(), new Long(1));
        Assert.assertEquals(orderLineId.getSalesOrderId(), new Long(1));
    }


}
