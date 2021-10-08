package io.swagger.client.api;

import com.sun.jersey.api.client.GenericType;

import io.swagger.client.ApiException;
import io.swagger.client.ApiClient;
import io.swagger.client.Configuration;
import io.swagger.client.model.*;
import io.swagger.client.Pair;

import io.swagger.client.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductsendpointApi {
	private ApiClient apiClient;

	public ProductsendpointApi() {
		this(Configuration.getDefaultApiClient());
	}

	public ProductsendpointApi(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	public ApiClient getApiClient() {
		return apiClient;
	}

	public void setApiClient(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	/**
	 * Add new product
	 * 
	 * @param product product (required)
	 * @return List<Product>
	 * @throws ApiException if fails to make API call
	 */
	public List<Product> addNewProductUsingPOST(Product product) throws ApiException {
		Object localVarPostBody = product;

		// verify the required parameter 'product' is set
		if (product == null) {
			throw new ApiException(400, "Missing the required parameter 'product' when calling addNewProductUsingPOST");
		}

		// create path and map variables
		String localVarPath = "/api/products/addNewProduct".replaceAll("\\{format\\}", "json");

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();

		final String[] localVarAccepts = { "application/json" };
		final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

		final String[] localVarContentTypes = { "application/json" };
		final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

		String[] localVarAuthNames = new String[] { "BasicAuth" };

		GenericType<List<Product>> localVarReturnType = new GenericType<List<Product>>() {
		};
		return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams,
				localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
	}

	/**
	 * Check product quantity balance
	 * 
	 * @param code code (required)
	 * @param qtn  qtn (required)
	 * @return Boolean
	 * @throws ApiException if fails to make API call
	 */
	public Boolean checkProductQuantityUsingGET(String code, String qtn) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'code' is set
		if (code == null) {
			throw new ApiException(400,
					"Missing the required parameter 'code' when calling checkProductQuantityUsingGET");
		}

		// verify the required parameter 'qtn' is set
		if (qtn == null) {
			throw new ApiException(400,
					"Missing the required parameter 'qtn' when calling checkProductQuantityUsingGET");
		}

		// create path and map variables
		String localVarPath = "/api/products/checkProductQuantity".replaceAll("\\{format\\}", "json");

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();

		localVarQueryParams.addAll(apiClient.parameterToPairs("", "code", code));
		localVarQueryParams.addAll(apiClient.parameterToPairs("", "qtn", qtn));

		final String[] localVarAccepts = { "application/json" };
		final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

		final String[] localVarContentTypes = { "application/json" };
		final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

		String[] localVarAuthNames = new String[] { "BasicAuth" };

		GenericType<Boolean> localVarReturnType = new GenericType<Boolean>() {
		};
		return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
				localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
	}

	/**
	 * Delete product by code
	 * 
	 * @param code code (required)
	 * @return List<Product>
	 * @throws ApiException if fails to make API call
	 */
	public List<Product> deleteProductByCodeUsingDELETE(String code) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'code' is set
		if (code == null) {
			throw new ApiException(400,
					"Missing the required parameter 'code' when calling deleteProductByCodeUsingDELETE");
		}

		// create path and map variables
		String localVarPath = "/api/products/deleteProductByCode".replaceAll("\\{format\\}", "json");

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();

		localVarQueryParams.addAll(apiClient.parameterToPairs("", "code", code));

		final String[] localVarAccepts = { "application/json" };
		final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

		final String[] localVarContentTypes = { "application/json" };
		final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

		String[] localVarAuthNames = new String[] { "BasicAuth" };

		GenericType<List<Product>> localVarReturnType = new GenericType<List<Product>>() {
		};
		return apiClient.invokeAPI(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams,
				localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
	}

	/**
	 * Edit new product
	 * 
	 * @param product product (required)
	 * @return Product
	 * @throws ApiException if fails to make API call
	 */
	public Product editProductUsingPUT(Product product) throws ApiException {
		Object localVarPostBody = product;

		// verify the required parameter 'product' is set
		if (product == null) {
			throw new ApiException(400, "Missing the required parameter 'product' when calling editProductUsingPUT");
		}

		// create path and map variables
		String localVarPath = "/api/products/editProduct".replaceAll("\\{format\\}", "json");

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();

		final String[] localVarAccepts = { "application/json" };
		final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

		final String[] localVarContentTypes = { "application/json" };
		final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

		String[] localVarAuthNames = new String[] { "BasicAuth" };

		GenericType<Product> localVarReturnType = new GenericType<Product>() {
		};
		return apiClient.invokeAPI(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams,
				localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
	}

	/**
	 * Get all products
	 * 
	 * @return List<Product>
	 * @throws ApiException if fails to make API call
	 */
	public List<Product> getAllProductUsingGET() throws ApiException {
		Object localVarPostBody = null;

		// create path and map variables
		String localVarPath = "/api/products/getAllProducts".replaceAll("\\{format\\}", "json");

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();

		final String[] localVarAccepts = { "application/json" };
		final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

		final String[] localVarContentTypes = { "application/json" };
		final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

		String[] localVarAuthNames = new String[] { "BasicAuth" };

		GenericType<List<Product>> localVarReturnType = new GenericType<List<Product>>() {
		};
		return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
				localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
	}

	/**
	 * Get product price by code
	 * 
	 * @param code code (required)
	 * @return Double
	 * @throws ApiException if fails to make API call
	 */
	public Double getPriceByCodeUsingGET(String code) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'code' is set
		if (code == null) {
			throw new ApiException(400, "Missing the required parameter 'code' when calling getPriceByCodeUsingGET");
		}

		// create path and map variables
		String localVarPath = "/api/products/getPriceByCode".replaceAll("\\{format\\}", "json");

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();

		localVarQueryParams.addAll(apiClient.parameterToPairs("", "code", code));

		final String[] localVarAccepts = { "application/json" };
		final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

		final String[] localVarContentTypes = { "application/json" };
		final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

		String[] localVarAuthNames = new String[] { "BasicAuth" };

		GenericType<Double> localVarReturnType = new GenericType<Double>() {
		};
		return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
				localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
	}

	/**
	 * Get product by code
	 * 
	 * @param code code (required)
	 * @return Product
	 * @throws ApiException if fails to make API call
	 */
	public Product getProductByCodeUsingGET(String code) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'code' is set
		if (code == null) {
			throw new ApiException(400, "Missing the required parameter 'code' when calling getProductByCodeUsingGET");
		}

		// create path and map variables
		String localVarPath = "/api/products/getProductByCode".replaceAll("\\{format\\}", "json");

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();

		localVarQueryParams.addAll(apiClient.parameterToPairs("", "code", code));

		final String[] localVarAccepts = { "application/json" };
		final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

		final String[] localVarContentTypes = { "application/json" };
		final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

		String[] localVarAuthNames = new String[] { "BasicAuth" };

		GenericType<Product> localVarReturnType = new GenericType<Product>() {
		};
		return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
				localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
	}
}
