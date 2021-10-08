package com.crossover.salesorder.backend.endpoints;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crossover.salesorder.backend.model.SalesOrder;
import com.crossover.salesorder.backend.model.exceptions.CreditException;
import com.crossover.salesorder.backend.model.exceptions.QuanityException;
import com.crossover.salesorder.backend.services.ISalesOrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Sales Order end point.
 *
 * @author simon-pc
 */
@RepositoryRestController
@RequestMapping("/api/salesorder")
@Api(value = "SalesOrdersEndPoint", produces = "application/json")
@Configuration
public class SalesOrderEndPoint {

    @Autowired
    private ISalesOrderService salesOrderService;

    @ApiOperation(value = "Add new order")
    @RequestMapping(method = RequestMethod.POST, path = "/addNewOrder", produces = "application/json")
    public @ResponseBody ResponseEntity<Object> addNewOrder(@RequestBody SalesOrder salesOrder) throws Exception {
        try {
            salesOrderService.addNewSalesOrder(salesOrder);
            return new ResponseEntity<Object>(salesOrderService.getSalesOrderById(salesOrder.getId()), HttpStatus.OK);
        } catch (CreditException creditException) {
            return new ResponseEntity<Object>(false, HttpStatus.OK);
        } catch (QuanityException quanityException) {
            StringBuffer stringBuffer = new StringBuffer();
            for (Map.Entry<Long, Boolean> entry : quanityException.getResults().entrySet()) {

                if (!entry.getValue()) {
                    stringBuffer.append(entry.getKey());
                    stringBuffer.append(",");
                }
            }
            return new ResponseEntity<Object>(stringBuffer.toString(), HttpStatus.OK);
        }
    }

    @ApiOperation(value = "Delete sales order")
    @RequestMapping(method = RequestMethod.DELETE, path = "/deleteSalesOrder", produces = "application/json")
    public @ResponseBody ResponseEntity<List<SalesOrder>> deleteProductByOrderId(
            @RequestParam(value = "salesOrderId") String salesOrderId) {
        try {
            salesOrderService.deleteSalesOrderByOrderId(salesOrderId);
            return new ResponseEntity<>(salesOrderService.getAllSalesOrders(), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<List<SalesOrder>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Get sales order by id")
    @RequestMapping(method = RequestMethod.GET, path = "/getSalesOrderById", produces = "application/json")
    public @ResponseBody ResponseEntity<SalesOrder> getSalesOrderById(@RequestParam(value = "id") String id) {

        try {
            return new ResponseEntity<SalesOrder>(salesOrderService.getSalesOrderById(Long.parseLong(id)),
                    HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<SalesOrder>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Get sales order by order id")
    @RequestMapping(method = RequestMethod.GET, path = "/getSalesOrderByOrderId", produces = "application/json")
    public @ResponseBody ResponseEntity<SalesOrder> getSalesOrderByOrderId(
            @RequestParam(value = "orderId") String orderId) {

        try {
            return new ResponseEntity<SalesOrder>(salesOrderService.getSalesOrderByOrderId(orderId), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<SalesOrder>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Get all sales orders")
    @RequestMapping(method = RequestMethod.GET, path = "/getAllSalesOrders", produces = "application/json")
    public @ResponseBody ResponseEntity<List<SalesOrder>> getAllSalesOrders() {

        try {
            return new ResponseEntity<List<SalesOrder>>(salesOrderService.getAllSalesOrders(), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<List<SalesOrder>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
