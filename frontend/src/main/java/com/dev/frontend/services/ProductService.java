package com.dev.frontend.services;

import java.util.ArrayList;
import java.util.List;

import com.dev.frontend.panels.ComboBoxItem;

import io.swagger.client.ApiException;
import io.swagger.client.api.ProductsendpointApi;
import io.swagger.client.model.Product;

public class ProductService {

    public static Object saveProduct(Object object) {
        ProductsendpointApi productsendpointApi = EndPointsFactory.getProductsendpointApi();
        try {
            Product prod = (Product) object;
            return productsendpointApi.editProductUsingPUT(prod);
        } catch (ApiException e) {
            e.printStackTrace();

            if(e.getCode() == 409) {
                return new String("Product code already exists please try new one");
            }
            return null;
        }
    }

    public static Product readProductByCode(String code) {
        ProductsendpointApi productsendpointApi = EndPointsFactory.getProductsendpointApi();
        try {
            return productsendpointApi.getProductByCodeUsingGET(code);
        } catch (ApiException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean deleteProduct(String code) {
        ProductsendpointApi productsendpointApi = EndPointsFactory.getProductsendpointApi();
        try {
            productsendpointApi.deleteProductByCodeUsingDELETE(code);
            return true;
        } catch (ApiException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static ArrayList<Object> listProductCurrentRecords(int objectType) {

        ProductsendpointApi productsendpointApi = EndPointsFactory.getProductsendpointApi();
        try {
            return new ArrayList<Object>(productsendpointApi.getAllProductUsingGET());
        } catch (ApiException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<ComboBoxItem> listProductCurrentRecordReferences() {
        ProductsendpointApi productsendpointApi = EndPointsFactory.getProductsendpointApi();
        try {
            List<Product> products = productsendpointApi.getAllProductUsingGET();
            List<ComboBoxItem> comboBoxItems = new ArrayList<ComboBoxItem>();
            for (Product prod : products) {
                comboBoxItems.add(new ComboBoxItem(prod.getId().toString(), prod.getDesc()));
            }

            return comboBoxItems;

        } catch (ApiException e) {
            e.printStackTrace();
            return null;
        }
    }

}
