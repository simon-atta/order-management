package com.crossover.salesorder.backend.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crossover.salesorder.backend.model.Customer;
import com.crossover.salesorder.backend.services.ICustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Customer end points.
 *
 * @author Simon Ghobreil.
 */
@RepositoryRestController
@RequestMapping("/api/customers")
@Api(value = "CustomerEndPoint", produces = "application/json")
@Configuration
public class CustomerEndPoint {

    @Autowired
    private ICustomerService customerService;

    /**
     * Add new customer end point.
     * Handle all requests for add new customer. It's use HTTP method POST.
     *
     * @param customer
     *        Customer
     * @return list of all customers or internal server error in case of
     *         exception.
     */
    @ApiOperation(value = "Add new customer")
    @RequestMapping(method = RequestMethod.POST, path = "/addNewCustomer", produces = "application/json")
    public @ResponseBody ResponseEntity<List<Customer>> addNewCustomer(@RequestBody Customer customer) {

        try {
            customerService.addNewCustomer(customer);
            return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
        } catch (DataIntegrityViolationException DataIntegrityViolationException) {
            return new ResponseEntity<List<Customer>>(HttpStatus.CONFLICT);
        } catch (Exception exception) {
            return new ResponseEntity<List<Customer>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Edit existing customer end point.
     * Handle all requests for edit customer. It's use HTTP method PUT.
     *
     * @param customer
     *        Customer
     * @return customer object after editing or internal server error in case of
     *         exception.
     */
    @ApiOperation(value = "Edit new customer")
    @RequestMapping(method = RequestMethod.PUT, path = "/editCustomer", produces = "application/json")
    public @ResponseBody ResponseEntity<Customer> editCustomer(@RequestBody Customer customer) {

        try {
            customerService.editCustomer(customer);
            return new ResponseEntity<Customer>(customer, HttpStatus.OK);

        } catch (DataIntegrityViolationException DataIntegrityViolationException) {
            return new ResponseEntity<Customer>(HttpStatus.CONFLICT);
        } catch (Exception exception) {
            return new ResponseEntity<Customer>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Get all customers end point.
     * Handle all requests for get all customer. It's use HTTP method GET.
     *
     * @return list of all customers or internal server error in case of
     *         exception.
     */
    @ApiOperation(value = "Get all customers")
    @RequestMapping(method = RequestMethod.GET, path = "/getAllCustomers", produces = "application/json")
    public @ResponseBody ResponseEntity<List<Customer>> getAllCustomers() {
        try {
            return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<List<Customer>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Get customer by code end point.
     * Handle all requests for get customer by code. It's use HTTP method GET.
     *
     * @param code
     *        String
     * @return match customer object or internal server error in case of
     *         exception.
     */
    @ApiOperation(value = "Get customer by code")
    @RequestMapping(method = RequestMethod.GET, path = "/getCustomerByCode", produces = "application/json")
    public @ResponseBody ResponseEntity<Customer> getCustomerByCode(@RequestParam(value = "code") String code) {
        try {
            return new ResponseEntity<>(customerService.getCustomerByCode(Integer.parseInt(code)), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<Customer>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Delete customer by code end point.
     * Handle all requests for delete customer by code. It's use HTTP method
     * DELETE.
     *
     * @param code
     *        String
     * @return list of all customers or internal server error in case of
     *         exception.
     */
    @ApiOperation(value = "Delete customer by code")
    @RequestMapping(method = RequestMethod.DELETE, path = "/deleteCustomerByCode", produces = "application/json")
    public @ResponseBody ResponseEntity<List<Customer>> deleteCustomerByCode(
            @RequestParam(value = "code") String code) {
        try {
            customerService.deleteCustomerByCode(Integer.parseInt(code));
            return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<List<Customer>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
