package com.crossover.salesorder.backend.services;

import java.util.List;
import java.util.Map;

import com.crossover.salesorder.backend.model.OrderLine;
import com.crossover.salesorder.backend.model.Product;

/**
 * This is contract of product service.
 *
 * @author Simon Ghobreil.
 */
public interface IProductService {

    /**
     * Add new product.
     *
     * @param product
     *        Product
     */
    void addNewProduct(Product product) throws Exception;

    /**
     * Edit product.
     *
     * @param product
     *        Product
     * @return product after edit.
     */
    Product editProduct(Product product) throws Exception;

    /**
     * Get product by code.
     *
     * @param code
     *        int
     * @return product which match code.
     */
    Product getProductByCode(int code) throws Exception;

    /**
     * Delete product by code.
     *
     * @param code
     *        int
     */
    void deleteProductByCode(int code) throws Exception;

    /**
     * Get all products.
     *
     * @return list of products.
     */
    List<Product> getAllProducts() throws Exception;

    /**
     * Get price of product by code.
     *
     * @param code
     *        int.
     * @return price of product as double.
     */
    Double getPriceById(Long code) throws Exception;

    /**
     * Check for product quantities.
     *
     * @return Map<Long, Boolean> with every product id and boolean value if it
     *         has enough quantity to provide. if true mean there is quantities
     *         to provide if it false then there is no enough balance.
     */
    Map<Long, Boolean> checkOrderLineQuantities(List<OrderLine> orderLines);

    /**
     * Check for product quantity balance
     *
     * @return boolean if all quantities are correct or not.
     */
    Boolean checkQuantityBalance(Long code, Integer qtn) throws Exception;

}
