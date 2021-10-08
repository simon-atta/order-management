package com.crossover.salesorder.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Customer model class.
 *
 * @author Simon Ghobreil.
 */
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cust_id")
    private Long id;

    @Column(name = "cust_code", unique = true, nullable = true)
    private int code;

    @Column(name = "cust_name")
    private String name;

    @Column(name = "cust_phone_one")
    private String phoneOne;

    @Column(name = "cust_phone_two")
    private String phoneTwo;

    @Column(name = "cust_adress")
    private String adress;

    @Column(name = "cust_credit_current")
    private Double currentCredit = 0.0;

    @Column(name = "cust_credit_limit")
    private Double creditLimit;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     *        the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code
     *        the code to set
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *        the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the phoneOne
     */
    public String getPhoneOne() {
        return phoneOne;
    }

    /**
     * @param phoneOne
     *        the phoneOne to set
     */
    public void setPhoneOne(String phoneOne) {
        this.phoneOne = phoneOne;
    }

    /**
     * @return the phoneTwo
     */
    public String getPhoneTwo() {
        return phoneTwo;
    }

    /**
     * @param phoneTwo
     *        the phoneTwo to set
     */
    public void setPhoneTwo(String phoneTwo) {
        this.phoneTwo = phoneTwo;
    }

    /**
     * @return the adress
     */
    public String getAdress() {
        return adress;
    }

    /**
     * @param adress
     *        the adress to set
     */
    public void setAdress(String adress) {
        this.adress = adress;
    }

    /**
     * @return the currentCredit
     */
    public Double getCurrentCredit() {
        return currentCredit;
    }

    /**
     * @param currentCredit
     *        the currentCredit to set
     */
    public void setCurrentCredit(Double currentCredit) {
        this.currentCredit = currentCredit;
    }

    /**
     * @return the creditLimit
     */
    public Double getCreditLimit() {
        return creditLimit;
    }

    /**
     * @param creditLimit
     *        the creditLimit to set
     */
    public void setCreditLimit(Double creditLimit) {
        this.creditLimit = creditLimit;
    }

}
