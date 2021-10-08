package io.swagger.client.api;

import com.sun.jersey.api.client.GenericType;

import io.swagger.client.ApiException;
import io.swagger.client.ApiClient;
import io.swagger.client.Configuration;
import io.swagger.client.model.*;
import io.swagger.client.Pair;

import io.swagger.client.model.SalesOrder;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SalesordersendpointApi {
  private ApiClient apiClient;

  public SalesordersendpointApi() {
    this(Configuration.getDefaultApiClient());
  }

  public SalesordersendpointApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Add new order
   * 
   * @param salesOrder salesOrder (required)
   * @return Object
   * @throws ApiException if fails to make API call
   */
  public Object addNewOrderUsingPOST(SalesOrder salesOrder) throws ApiException {
    Object localVarPostBody = salesOrder;
    
    // verify the required parameter 'salesOrder' is set
    if (salesOrder == null) {
      throw new ApiException(400, "Missing the required parameter 'salesOrder' when calling addNewOrderUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/api/salesorder/addNewOrder".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "BasicAuth" };

    GenericType<Object> localVarReturnType = new GenericType<Object>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Delete sales order
   * 
   * @param salesOrderId salesOrderId (required)
   * @return List<SalesOrder>
   * @throws ApiException if fails to make API call
   */
  public List<SalesOrder> deleteProductByOrderIdUsingDELETE(String salesOrderId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'salesOrderId' is set
    if (salesOrderId == null) {
      throw new ApiException(400, "Missing the required parameter 'salesOrderId' when calling deleteProductByOrderIdUsingDELETE");
    }
    
    // create path and map variables
    String localVarPath = "/api/salesorder/deleteSalesOrder".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "salesOrderId", salesOrderId));

    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "BasicAuth" };

    GenericType<List<SalesOrder>> localVarReturnType = new GenericType<List<SalesOrder>>() {};
    return apiClient.invokeAPI(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Get all sales orders
   * 
   * @return List<SalesOrder>
   * @throws ApiException if fails to make API call
   */
  public List<SalesOrder> getAllSalesOrdersUsingGET() throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/api/salesorder/getAllSalesOrders".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "BasicAuth" };

    GenericType<List<SalesOrder>> localVarReturnType = new GenericType<List<SalesOrder>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Get sales order by id
   * 
   * @param id id (required)
   * @return SalesOrder
   * @throws ApiException if fails to make API call
   */
  public SalesOrder getSalesOrderByIdUsingGET(String id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getSalesOrderByIdUsingGET");
    }
    
    // create path and map variables
    String localVarPath = "/api/salesorder/getSalesOrderById".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "id", id));

    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "BasicAuth" };

    GenericType<SalesOrder> localVarReturnType = new GenericType<SalesOrder>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Get sales order by order id
   * 
   * @param orderId orderId (required)
   * @return SalesOrder
   * @throws ApiException if fails to make API call
   */
  public SalesOrder getSalesOrderByOrderIdUsingGET(String orderId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'orderId' is set
    if (orderId == null) {
      throw new ApiException(400, "Missing the required parameter 'orderId' when calling getSalesOrderByOrderIdUsingGET");
    }
    
    // create path and map variables
    String localVarPath = "/api/salesorder/getSalesOrderByOrderId".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "orderId", orderId));

    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "BasicAuth" };

    GenericType<SalesOrder> localVarReturnType = new GenericType<SalesOrder>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
