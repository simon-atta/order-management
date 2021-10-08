package com.dev.frontend.services;

import io.swagger.client.ApiClient;
import io.swagger.client.api.CustomerendpointApi;
import io.swagger.client.api.ProductsendpointApi;
import io.swagger.client.api.SalesordersendpointApi;

/**
 * This is abstract profile service which contains common code for all profile
 * services.
 *
 * @author Simon Ghobreil.
 */
public class EndPointsFactory {


    public static ProductsendpointApi getProductsendpointApi() {
        ApiClient apiClient = new ApiClient();
        apiClient.setUsername("user");
        apiClient.setPassword("password");
        apiClient.setBasePath("http://localhost:8082");

        return new ProductsendpointApi(apiClient);
    }

    public static CustomerendpointApi getCustomerendpointApi() {
        ApiClient apiClient = new ApiClient();
        apiClient.setUsername("user");
        apiClient.setPassword("password");
        apiClient.setBasePath("http://localhost:8082");

        return new CustomerendpointApi(apiClient);
    }

    public static SalesordersendpointApi getSalesordersendpointApi() {
        ApiClient apiClient = new ApiClient();
        apiClient.setUsername("user");
        apiClient.setPassword("password");
        apiClient.setBasePath("http://localhost:8082");

        return new SalesordersendpointApi(apiClient);
    }


}
