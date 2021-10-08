package com.dev.frontend.services;

import java.util.ArrayList;

import io.swagger.client.ApiException;
import io.swagger.client.api.SalesordersendpointApi;
import io.swagger.client.model.SalesOrder;

public class SalesOrderService {

    public static Object saveSalesOrder(Object object) {
        SalesordersendpointApi salesordersendpointApi = EndPointsFactory.getSalesordersendpointApi();
        try {
            SalesOrder salesOrder = (SalesOrder) object;
            return salesordersendpointApi.addNewOrderUsingPOST(salesOrder);
        } catch (ApiException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static SalesOrder readSalesOrderById(String code) {
        SalesordersendpointApi salesordersendpointApi = EndPointsFactory.getSalesordersendpointApi();
        try {
            return salesordersendpointApi.getSalesOrderByOrderIdUsingGET(code);
        } catch (ApiException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean deleteSalesOrder(String code) {
        SalesordersendpointApi salesordersendpointApi = EndPointsFactory.getSalesordersendpointApi();
        try {
            salesordersendpointApi.deleteProductByOrderIdUsingDELETE(code);
            return true;
        } catch (ApiException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static ArrayList<Object> listSalesOrderCurrentRecords() {
        SalesordersendpointApi salesordersendpointApi = EndPointsFactory.getSalesordersendpointApi();
        try {
            return new ArrayList<Object>(salesordersendpointApi.getAllSalesOrdersUsingGET());
        } catch (ApiException e) {
            e.printStackTrace();
            return null;
        }
    }

}
