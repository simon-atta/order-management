package com.crossover.salesorder.backend.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.crossover.salesorder.backend.model.Product;

/**
 * Product repository.
 *
 * @author Simon Ghobreil.
 */
public interface ProductRepository extends CrudRepository<Product, Long> {

    /**
     * Find product by product code.
     *
     * @param code
     *        int
     * @return Product
     */
    Product findByCode(int code);

    /**
     * Get product price by product id.
     *
     * @param id
     *        Long
     * @return product price as double value.
     */
    @Query("select price from Product product where product.id = ?1")
    Double getPriceById(Long id);

}
