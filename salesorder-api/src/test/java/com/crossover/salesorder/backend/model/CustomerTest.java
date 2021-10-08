package com.crossover.salesorder.backend.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test case for customer model class.
 *
 * @author Simon Ghobreil.
 */
public class CustomerTest {


    @Test
    public void testCodeSetterAndGetter() {
        Customer customer = new Customer();
        customer.setCode(01);
        Assert.assertEquals(customer.getCode(), 01);
    }

    @Test
    public void testNameSetterAndGetter() {
        Customer customer = new Customer();
        customer.setName("simon");
        Assert.assertEquals(customer.getName(), "simon");
    }

    @Test
    public void testPhoneSetterAndGetter() {
        Customer customer = new Customer();
        customer.setPhoneOne("+20101706655");
        Assert.assertEquals(customer.getPhoneOne(), "+20101706655");
    }

    @Test
    public void testCreditSetterAndGetter() {
        Customer customer = new Customer();
        customer.setCurrentCredit(35.5);
        Assert.assertEquals(customer.getCurrentCredit(), 35.5, 35.5);
    }

}
