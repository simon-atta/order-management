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

import com.crossover.salesorder.backend.model.Product;
import com.crossover.salesorder.backend.services.IProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Product end point.
 *
 * @author Simon Ghobreil.
 */
@RepositoryRestController
@RequestMapping("/api/products")
@Api(value = "ProductsEndPoint", produces = "application/json")
@Configuration
public class ProductEndPoint {

    @Autowired
    private IProductService productService;

    @ApiOperation(value = "Add new product")
    @RequestMapping(method = RequestMethod.POST, path = "/addNewProduct", produces = "application/json")
    public @ResponseBody ResponseEntity<List<Product>> addNewProduct(@RequestBody Product product) {

        try {
            productService.addNewProduct(product);
            return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);

        } catch (DataIntegrityViolationException DataIntegrityViolationException) {
            return new ResponseEntity<List<Product>>(HttpStatus.CONFLICT);
        } catch (Exception exception) {
            return new ResponseEntity<List<Product>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Get all products")
    @RequestMapping(method = RequestMethod.GET, path = "/getAllProducts", produces = "application/json")
    public @ResponseBody ResponseEntity<List<Product>> getAllProduct() {
        try {
            return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<List<Product>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Get product by code")
    @RequestMapping(method = RequestMethod.GET, path = "/getProductByCode", produces = "application/json")
    public @ResponseBody ResponseEntity<Product> getProductByCode(@RequestParam(value = "code") String code) {
        try {
            return new ResponseEntity<>(productService.getProductByCode(Integer.parseInt(code)), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<Product>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Get product price by code")
    @RequestMapping(method = RequestMethod.GET, path = "/getPriceByCode", produces = "application/json")
    public @ResponseBody ResponseEntity<Double> getPriceByCode(@RequestParam(value = "code") String code) {
        try {
            return new ResponseEntity<>(productService.getPriceById(Long.parseLong(code)), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<Double>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Edit new product")
    @RequestMapping(method = RequestMethod.PUT, path = "/editProduct", produces = "application/json")
    public @ResponseBody ResponseEntity<Product> editProduct(@RequestBody Product product) {

        try {
            productService.editProduct(product);
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (DataIntegrityViolationException DataIntegrityViolationException) {
            return new ResponseEntity<Product>(HttpStatus.CONFLICT);
        } catch (Exception exception) {
            return new ResponseEntity<Product>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Delete product by code")
    @RequestMapping(method = RequestMethod.DELETE, path = "/deleteProductByCode", produces = "application/json")
    public @ResponseBody ResponseEntity<List<Product>> deleteProductByCode(@RequestParam(value = "code") String code) {
        try {
            productService.deleteProductByCode(Integer.parseInt(code));
            return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<List<Product>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Check product quantity balance")
    @RequestMapping(method = RequestMethod.GET, path = "/checkProductQuantity", produces = "application/json")
    public @ResponseBody ResponseEntity<Boolean> checkProductQuantity(@RequestParam(value = "code") String code,
            @RequestParam(value = "qtn") String qtn) {
        try {
            return new ResponseEntity<>(
                    productService.checkQuantityBalance(Long.parseLong(code), Integer.parseInt(qtn)), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<Boolean>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
