package io.swagger.client.api;

import com.sun.jersey.api.client.GenericType;

import io.swagger.client.ApiException;
import io.swagger.client.ApiClient;
import io.swagger.client.Configuration;
import io.swagger.client.Pair;

import io.swagger.client.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerendpointApi {
	private ApiClient apiClient;

	public CustomerendpointApi() {
		this(Configuration.getDefaultApiClient());
	}

	public CustomerendpointApi(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	public ApiClient getApiClient() {
		return apiClient;
	}

	public void setApiClient(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	/**
	 * Add new customer
	 * 
	 * @param customer customer (required)
	 * @return List<Customer>
	 * @throws ApiException if fails to make API call
	 */
	public List<Customer> addNewCustomerUsingPOST(Customer customer) throws ApiException {
		Object localVarPostBody = customer;

		// verify the required parameter 'customer' is set
		if (customer == null) {
			throw new ApiException(400,
					"Missing the required parameter 'customer' when calling addNewCustomerUsingPOST");
		}

		// create path and map variables
		String localVarPath = "/api/customers/addNewCustomer".replaceAll("\\{format\\}", "json");

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();

		final String[] localVarAccepts = { "application/json" };
		final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

		final String[] localVarContentTypes = { "application/json" };
		final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

		String[] localVarAuthNames = new String[] { "BasicAuth" };

		GenericType<List<Customer>> localVarReturnType = new GenericType<List<Customer>>() {
		};
		return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams,
				localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
	}

	/**
	 * Delete customer by code
	 * 
	 * @param code code (required)
	 * @return List<Customer>
	 * @throws ApiException if fails to make API call
	 */
	public List<Customer> deleteCustomerByCodeUsingDELETE(String code) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'code' is set
		if (code == null) {
			throw new ApiException(400,
					"Missing the required parameter 'code' when calling deleteCustomerByCodeUsingDELETE");
		}

		// create path and map variables
		String localVarPath = "/api/customers/deleteCustomerByCode".replaceAll("\\{format\\}", "json");

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

		GenericType<List<Customer>> localVarReturnType = new GenericType<List<Customer>>() {
		};
		return apiClient.invokeAPI(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams,
				localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
	}

	/**
	 * Edit new customer
	 * 
	 * @param customer customer (required)
	 * @return Customer
	 * @throws ApiException if fails to make API call
	 */
	public Customer editCustomerUsingPUT(Customer customer) throws ApiException {
		Object localVarPostBody = customer;

		// verify the required parameter 'customer' is set
		if (customer == null) {
			throw new ApiException(400, "Missing the required parameter 'customer' when calling editCustomerUsingPUT");
		}

		// create path and map variables
		String localVarPath = "/api/customers/editCustomer".replaceAll("\\{format\\}", "json");

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();

		final String[] localVarAccepts = { "application/json" };
		final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

		final String[] localVarContentTypes = { "application/json" };
		final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

		String[] localVarAuthNames = new String[] { "BasicAuth" };

		GenericType<Customer> localVarReturnType = new GenericType<Customer>() {
		};
		return apiClient.invokeAPI(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams,
				localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
	}

	/**
	 * Get all customers
	 * 
	 * @return List<Customer>
	 * @throws ApiException if fails to make API call
	 */
	public List<Customer> getAllCustomersUsingGET() throws ApiException {
		Object localVarPostBody = null;

		// create path and map variables
		String localVarPath = "/api/customers/getAllCustomers".replaceAll("\\{format\\}", "json");

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();

		final String[] localVarAccepts = { "application/json" };
		final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

		final String[] localVarContentTypes = { "application/json" };
		final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

		String[] localVarAuthNames = new String[] { "BasicAuth" };

		GenericType<List<Customer>> localVarReturnType = new GenericType<List<Customer>>() {
		};
		return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
				localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
	}

	/**
	 * Get customer by code
	 * 
	 * @param code code (required)
	 * @return Customer
	 * @throws ApiException if fails to make API call
	 */
	public Customer getCustomerByCodeUsingGET(String code) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'code' is set
		if (code == null) {
			throw new ApiException(400, "Missing the required parameter 'code' when calling getCustomerByCodeUsingGET");
		}

		// create path and map variables
		String localVarPath = "/api/customers/getCustomerByCode".replaceAll("\\{format\\}", "json");

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

		GenericType<Customer> localVarReturnType = new GenericType<Customer>() {
		};
		return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
				localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
	}
}
