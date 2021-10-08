# ProductsendpointApi

All URIs are relative to *https://localhost:8082/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addNewProductUsingPOST**](ProductsendpointApi.md#addNewProductUsingPOST) | **POST** /api/products/addNewProduct | Add new product
[**deleteProductByCodeUsingDELETE**](ProductsendpointApi.md#deleteProductByCodeUsingDELETE) | **DELETE** /api/products/deleteProductByCode | Delete product by code
[**editProductUsingPUT**](ProductsendpointApi.md#editProductUsingPUT) | **PUT** /api/products/editProduct | Edit new product
[**getAllProductUsingGET**](ProductsendpointApi.md#getAllProductUsingGET) | **GET** /api/products/getAllProducts | Get all products
[**getProductByCodeUsingGET**](ProductsendpointApi.md#getProductByCodeUsingGET) | **GET** /api/products/getProductByCode | Get product by code


<a name="addNewProductUsingPOST"></a>
# **addNewProductUsingPOST**
> List&lt;Product&gt; addNewProductUsingPOST(product)

Add new product

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ProductsendpointApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: BasicAuth
HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
BasicAuth.setUsername("YOUR USERNAME");
BasicAuth.setPassword("YOUR PASSWORD");

ProductsendpointApi apiInstance = new ProductsendpointApi();
Product product = new Product(); // Product | product
try {
    List<Product> result = apiInstance.addNewProductUsingPOST(product);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductsendpointApi#addNewProductUsingPOST");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **product** | [**Product**](Product.md)| product |

### Return type

[**List&lt;Product&gt;**](Product.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteProductByCodeUsingDELETE"></a>
# **deleteProductByCodeUsingDELETE**
> List&lt;Product&gt; deleteProductByCodeUsingDELETE(code)

Delete product by code

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ProductsendpointApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: BasicAuth
HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
BasicAuth.setUsername("YOUR USERNAME");
BasicAuth.setPassword("YOUR PASSWORD");

ProductsendpointApi apiInstance = new ProductsendpointApi();
String code = "code_example"; // String | code
try {
    List<Product> result = apiInstance.deleteProductByCodeUsingDELETE(code);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductsendpointApi#deleteProductByCodeUsingDELETE");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **code** | **String**| code |

### Return type

[**List&lt;Product&gt;**](Product.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="editProductUsingPUT"></a>
# **editProductUsingPUT**
> Product editProductUsingPUT(product)

Edit new product

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ProductsendpointApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: BasicAuth
HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
BasicAuth.setUsername("YOUR USERNAME");
BasicAuth.setPassword("YOUR PASSWORD");

ProductsendpointApi apiInstance = new ProductsendpointApi();
Product product = new Product(); // Product | product
try {
    Product result = apiInstance.editProductUsingPUT(product);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductsendpointApi#editProductUsingPUT");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **product** | [**Product**](Product.md)| product |

### Return type

[**Product**](Product.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getAllProductUsingGET"></a>
# **getAllProductUsingGET**
> List&lt;Product&gt; getAllProductUsingGET()

Get all products

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ProductsendpointApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: BasicAuth
HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
BasicAuth.setUsername("YOUR USERNAME");
BasicAuth.setPassword("YOUR PASSWORD");

ProductsendpointApi apiInstance = new ProductsendpointApi();
try {
    List<Product> result = apiInstance.getAllProductUsingGET();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductsendpointApi#getAllProductUsingGET");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;Product&gt;**](Product.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getProductByCodeUsingGET"></a>
# **getProductByCodeUsingGET**
> Product getProductByCodeUsingGET(code)

Get product by code

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ProductsendpointApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: BasicAuth
HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
BasicAuth.setUsername("YOUR USERNAME");
BasicAuth.setPassword("YOUR PASSWORD");

ProductsendpointApi apiInstance = new ProductsendpointApi();
String code = "code_example"; // String | code
try {
    Product result = apiInstance.getProductByCodeUsingGET(code);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductsendpointApi#getProductByCodeUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **code** | **String**| code |

### Return type

[**Product**](Product.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

