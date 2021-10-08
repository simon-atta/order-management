# swagger-java-client

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>io.swagger</groupId>
    <artifactId>swagger-java-client</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.swagger:swagger-java-client:1.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/swagger-java-client-1.0.0.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.ProductsendpointApi;

import java.io.File;
import java.util.*;

public class ProductsendpointApiExample {

    public static void main(String[] args) {
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
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://localhost:8082/*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*ProductsendpointApi* | [**addNewProductUsingPOST**](docs/ProductsendpointApi.md#addNewProductUsingPOST) | **POST** /api/products/addNewProduct | Add new product
*ProductsendpointApi* | [**deleteProductByCodeUsingDELETE**](docs/ProductsendpointApi.md#deleteProductByCodeUsingDELETE) | **DELETE** /api/products/deleteProductByCode | Delete product by code
*ProductsendpointApi* | [**editProductUsingPUT**](docs/ProductsendpointApi.md#editProductUsingPUT) | **PUT** /api/products/editProduct | Edit new product
*ProductsendpointApi* | [**getAllProductUsingGET**](docs/ProductsendpointApi.md#getAllProductUsingGET) | **GET** /api/products/getAllProducts | Get all products
*ProductsendpointApi* | [**getProductByCodeUsingGET**](docs/ProductsendpointApi.md#getProductByCodeUsingGET) | **GET** /api/products/getProductByCode | Get product by code


## Documentation for Models

 - [Product](docs/Product.md)


## Documentation for Authorization

Authentication schemes defined for the API:
### BasicAuth

- **Type**: HTTP basic authentication


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issue.

## Author



