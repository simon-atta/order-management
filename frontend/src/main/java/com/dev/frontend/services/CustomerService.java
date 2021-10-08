package com.dev.frontend.services;

import java.util.ArrayList;
import java.util.List;

import com.dev.frontend.panels.ComboBoxItem;

import io.swagger.client.ApiException;
import io.swagger.client.api.CustomerendpointApi;
import io.swagger.client.model.Customer;

public class CustomerService {

    public static Object saveCustomer(Object object) {
        CustomerendpointApi customerendpointApi = EndPointsFactory.getCustomerendpointApi();
        try {
            Customer customer = (Customer) object;
            return customerendpointApi.editCustomerUsingPUT(customer);
        } catch (ApiException e) {
            e.printStackTrace();

            if(e.getCode() == 409) {
                return new String("Customer code already exists please try new one");
            }

            return null;

        }
    }

    public static Customer readCustomerByCode(String code) {
        CustomerendpointApi customerendpointApi = EndPointsFactory.getCustomerendpointApi();
        try {
            return customerendpointApi.getCustomerByCodeUsingGET(code);
        } catch (ApiException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Object> listCustomerCurrentRecords() {
        CustomerendpointApi customerendpointApi = EndPointsFactory.getCustomerendpointApi();
        try {
            return new ArrayList<Object>(customerendpointApi.getAllCustomersUsingGET());
        } catch (ApiException e) {
            e.printStackTrace();
            return null;
        }
    }



    public static List<ComboBoxItem> listCustomerCurrentRecordReferences() {
        CustomerendpointApi customerendpointApi = EndPointsFactory.getCustomerendpointApi();
        try {
            List<Customer> customers = customerendpointApi.getAllCustomersUsingGET();

            List<ComboBoxItem> comboBoxItems = new ArrayList<ComboBoxItem>();
            for (Customer customer : customers) {
                comboBoxItems.add(new ComboBoxItem(customer.getId().toString(), customer.getName()));
            }

            return comboBoxItems;
        } catch (ApiException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean deleteCustomer(String code) {
        CustomerendpointApi customerendpointApi = EndPointsFactory.getCustomerendpointApi();
        try {
            customerendpointApi.deleteCustomerByCodeUsingDELETE(code);
            return true;
        } catch (ApiException e) {
            e.printStackTrace();
            return false;
        }
    }


}
