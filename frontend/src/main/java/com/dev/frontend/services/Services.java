package com.dev.frontend.services;

import java.util.ArrayList;
import java.util.List;

import com.dev.frontend.panels.ComboBoxItem;

import io.swagger.client.ApiException;
import io.swagger.client.api.ProductsendpointApi;

public class Services {
    public static final int TYPE_PRODUCT = 1;
    public static final int TYPE_CUSTOMER = 2;
    public static final int TYPE_SALESORDER = 3;

    public static Object save(Object object, int objectType) {
        if (objectType == TYPE_PRODUCT) {
            return ProductService.saveProduct(object);
        }

        if (objectType == TYPE_CUSTOMER) {
            return CustomerService.saveCustomer(object);
        }

        if (objectType == TYPE_SALESORDER) {
            return SalesOrderService.saveSalesOrder(object);
        }

        return null;
    }

    public static Object readRecordByCode(String code, int objectType) {
        if (objectType == TYPE_PRODUCT) {
            return ProductService.readProductByCode(code);
        }

        if (objectType == TYPE_CUSTOMER) {
            return CustomerService.readCustomerByCode(code);
        }

        if (objectType == TYPE_SALESORDER) {
            return SalesOrderService.readSalesOrderById(code);
        }

        return null;
    }

    public static boolean deleteRecordByCode(String code, int objectType) {
        if (objectType == TYPE_PRODUCT) {
            return ProductService.deleteProduct(code);
        }

        if (objectType == TYPE_CUSTOMER) {
            return CustomerService.deleteCustomer(code);
        }

        if (objectType == TYPE_SALESORDER) {
            return SalesOrderService.deleteSalesOrder(code);
        }

        return true;
    }

    public static List<Object> listCurrentRecords(int objectType) {

        if (objectType == TYPE_PRODUCT) {
            return ProductService.listProductCurrentRecords(objectType);
        }

        if (objectType == TYPE_CUSTOMER) {
            return CustomerService.listCustomerCurrentRecords();
        }

        if (objectType == TYPE_SALESORDER) {
            return SalesOrderService.listSalesOrderCurrentRecords();
        }

        return new ArrayList<Object>();
    }



    public static List<ComboBoxItem> listCurrentRecordRefernces(int objectType) {
        if (objectType == TYPE_PRODUCT) {
            return ProductService.listProductCurrentRecordReferences();
        }

        if (objectType == TYPE_CUSTOMER) {
            return CustomerService.listCustomerCurrentRecordReferences();
        }
        return new ArrayList<ComboBoxItem>();
    }



    public static double getProductPrice(String productCode) {
        ProductsendpointApi productsendpointApi = EndPointsFactory.getProductsendpointApi();
        try {
            return productsendpointApi.getPriceByCodeUsingGET(productCode);
        } catch (ApiException e) {
            e.printStackTrace();
            return 0.0;
        }
    }

    public static boolean checkQuanity(String productCode, String qtn) {
        ProductsendpointApi productsendpointApi = EndPointsFactory.getProductsendpointApi();
        try {
            return productsendpointApi.checkProductQuantityUsingGET(productCode, qtn);
        } catch (ApiException e) {
            e.printStackTrace();
            return false;
        }
    }




}
