package com.crossover.salesorder.backend.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crossover.salesorder.backend.model.Customer;
import com.crossover.salesorder.backend.model.OrderLine;
import com.crossover.salesorder.backend.model.OrderLineId;
import com.crossover.salesorder.backend.model.Product;
import com.crossover.salesorder.backend.model.SalesOrder;
import com.crossover.salesorder.backend.model.exceptions.CreditException;
import com.crossover.salesorder.backend.model.exceptions.QuanityException;
import com.crossover.salesorder.backend.repo.CustomerRepository;
import com.crossover.salesorder.backend.repo.OrderLineRepository;
import com.crossover.salesorder.backend.repo.ProductRepository;
import com.crossover.salesorder.backend.repo.SalesOrderRepository;

/**
 * This is concrete implementation of {@link ISalesOrderService}
 *
 * @author Simon Ghobreil.
 */
@Service
public class SalesOrderService implements ISalesOrderService {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IProductService productService;

    @Autowired
    private SalesOrderRepository salesOrderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderLineRepository orderLineRepository;

    /*
     * (non-Javadoc)
     * @see
     * com.crossover.salesorder.backend.services.ISalesOrderService#
     * addNewSalesOrder(com.
     * crossover.salesorder.backend.model.SalesOrder)
     */
    @Override
    @Transactional
    public void addNewSalesOrder(SalesOrder salesOrder) throws CreditException, QuanityException {

        // 1- Check for customer balance
        if (!customerService.checkCustomerCreditBalance(salesOrder.getTotalPrice(), salesOrder.getCustomer().getId()))
            throw new CreditException("-1");

        // 2- Check for products quantity
        Map<Long, Boolean> results = productService.checkOrderLineQuantities(salesOrder.getOrderLines());
        if (results.containsValue(false)) throw new QuanityException(results);

        // 3- Save or edit order
        SalesOrder existsOrder = salesOrderRepository.findByOrderId(salesOrder.getOrderId());
        if (existsOrder != null) {
            salesOrder.setId(existsOrder.getId());
            editSalesOrder(salesOrder);
        } else {
            saveSalesOrder(salesOrder);
        }

    }

    /**
     * This method handle edit of sales order.
     *
     * @param salesOrder
     *        SalesOrder
     */
    private void editSalesOrder(SalesOrder salesOrder) {
        Customer customer = customerRepository.findOne(salesOrder.getCustomer().getId());
        salesOrder.setCustomer(customer);

        SalesOrder existsOrder = salesOrderRepository.findByOrderId(salesOrder.getOrderId());
        List<OrderLine> existsOrderLines = existsOrder.getOrderLines();
        List<OrderLine> orderLines = salesOrder.getOrderLines();

        for (OrderLine orderLine : orderLines) {
            Product prod = productRepository.findOne(orderLine.getOrderLineId().getProdId());
            orderLine.setProduct(prod);
            orderLine.setOrderLineId(new OrderLineId(salesOrder.getId(), orderLine.getOrderLineId().getProdId()));
            orderLine.setSalesOrder(salesOrder);
        }

        List<OrderLine> newOrderLine = extractDifference(existsOrderLines, orderLines);

        double newCharge = handleBalanceAndQuantity(newOrderLine);

        orderLineRepository.save(newOrderLine);
        salesOrderRepository.save(salesOrder);

        // 4- Modify customer & product
        customer.setCurrentCredit(customer.getCurrentCredit() + newCharge);
        customerRepository.save(customer);
    }

    /**
     * This method calculate new charge for customer and decrease quantity of
     * current product.
     *
     * @param newOrderLine
     * @return new charge for customer as double value.
     */
    private double handleBalanceAndQuantity(List<OrderLine> newOrderLine) {
        double newCharge = 0.0;
        for (OrderLine orderLine : newOrderLine) {
            newCharge += orderLine.getQuantity() * orderLine.getProduct().getPrice();

            Product product = orderLine.getProduct();

            product.setQuantity(product.getQuantity() - orderLine.getQuantity());
            productRepository.save(product);
        }
        return newCharge;
    }

    /**
     * This method get difference between existing order lines and new orders
     * lines.
     *
     * @param existsOrderLines
     *        List<OrderLine>
     * @param orderLines
     *        List<OrderLine>
     * @return new list which have only new order lines.
     */
    private List<OrderLine> extractDifference(List<OrderLine> existsOrderLines, List<OrderLine> orderLines) {

        List<OrderLine> newOrderLine = new ArrayList<>();
        for (int i = 0; i < orderLines.size(); i++) {

            for (int j = 0; j < existsOrderLines.size(); j++) {
                if (!orderLines.get(i).getOrderLineId().equals(existsOrderLines.get(j).getOrderLineId())) {
                    newOrderLine.add(orderLines.get(i));
                }
            }
        }

        return newOrderLine;
    }

    /**
     * This method handle save new sales order.
     *
     * @param salesOrder
     */
    private void saveSalesOrder(SalesOrder salesOrder) {
        Customer customer = customerRepository.findOne(salesOrder.getCustomer().getId());
        salesOrder.setCustomer(customer);

        List<OrderLine> orderLines = salesOrder.getOrderLines();

        assignOrderLines(salesOrder, orderLines);
        salesOrderRepository.save(salesOrder);
        orderLineRepository.save(orderLines);

        // 4- Modify customer & product
        customer.setCurrentCredit(customer.getCurrentCredit() + salesOrder.getTotalPrice());
        customerRepository.save(customer);
    }

    /**
     * This method initialize sales order lines before save.
     *
     * @param salesOrder
     *        SalesOrder
     * @param orderLines
     *        List<OrderLine>
     */
    private void assignOrderLines(SalesOrder salesOrder, List<OrderLine> orderLines) {
        for (OrderLine orderLine : orderLines) {
            Product prod = productRepository.findOne(orderLine.getOrderLineId().getProdId());
            orderLine.setProduct(prod);
            orderLine.setOrderLineId(new OrderLineId(salesOrder.getId(), orderLine.getOrderLineId().getProdId()));
            orderLine.setSalesOrder(salesOrder);
            prod.setQuantity(prod.getQuantity() - orderLine.getQuantity());
            productRepository.save(prod);
        }
    }

    /*
     * (non-Javadoc)
     * @see
     * com.crossover.salesorder.backend.services.ISalesOrderService#
     * getSalesOrderById(com.
     * crossover.salesorder.backend.model.SalesOrder)
     */
    @Override
    public SalesOrder getSalesOrderById(Long id) {
        return salesOrderRepository.findOne(id);
    }

    /*
     * (non-Javadoc)
     * @see
     * com.crossover.salesorder.backend.services.ISalesOrderService#
     * getAllSalesOrders()
     */
    @Override
    public List<SalesOrder> getAllSalesOrders() {
        return (List<SalesOrder>) salesOrderRepository.findAll();
    }

    /*
     * (non-Javadoc)
     * @see
     * com.crossover.salesorder.backend.services.ISalesOrderService#
     * getSalesOrderByOrderId(String)
     */
    @Override
    public SalesOrder getSalesOrderByOrderId(String orderId) {
        return salesOrderRepository.findByOrderId(orderId);
    }

    /*
     * (non-Javadoc)
     * @see
     * com.crossover.salesorder.backend.services.ISalesOrderService#
     * deleteSalesOrderByOrderId(String)
     */
    @Override
    @Transactional
    public void deleteSalesOrderByOrderId(String salesOrderId) {
        SalesOrder salesOrder = salesOrderRepository.findByOrderId(salesOrderId);
        orderLineRepository.delete(salesOrder.getOrderLines());
        salesOrderRepository.delete(salesOrder);
    }

}
