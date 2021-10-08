package com.crossover.salesorder.backend.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crossover.salesorder.backend.model.OrderLine;
import com.crossover.salesorder.backend.model.Product;
import com.crossover.salesorder.backend.repo.ProductRepository;

/**
 * This is concrete implementation of {@link IProductService}
 *
 * @author Simon Ghobreil.
 */
@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    /*
     * (non-Javadoc)
     * @see
     * com.crossover.salesorder.backend.services.IProductService#addNewProduct(
     * com.crossover.salesorder.backend.model.Product)
     */
    @Override
    public void addNewProduct(Product product) {
        productRepository.save(product);
    }

    /*
     * (non-Javadoc)
     * @see com.crossover.salesorder.backend.services.IProductService#
     * editProduct(int)
     */
    @Override
    public Product editProduct(Product product) {
        return productRepository.save(product);
    }

    /*
     * (non-Javadoc)
     * @see com.crossover.salesorder.backend.services.IProductService#
     * getProductByCode(int)
     */
    @Override
    public Product getProductByCode(int code) {
        return productRepository.findByCode(code);
    }

    /*
     * (non-Javadoc)
     * @see com.crossover.salesorder.backend.services.IProductService#
     * deleteProductByCode(int)
     */
    @Override
    public void deleteProductByCode(int code) {
        Product product = productRepository.findByCode(code);
        productRepository.delete(product);
    }

    /*
     * (non-Javadoc)
     * @see
     * com.crossover.salesorder.backend.services.IProductService#getAllProducts(
     * )
     */
    @Override
    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    /*
     * (non-Javadoc)
     * @see
     * com.crossover.salesorder.backend.services.IProductService#getPriceByCode(
     * )
     */
    @Override
    public Double getPriceById(Long code) {
        return productRepository.getPriceById(code);
    }

    /*
     * (non-Javadoc)
     * @see com.crossover.salesorder.backend.services.IProductService#
     * checkOrderLineQuantities(List<OrderLine>)
     */
    @Override
    public Map<Long, Boolean> checkOrderLineQuantities(List<OrderLine> orderLines) {

        Map<Long, Boolean> results = new HashMap<Long, Boolean>();

        Map<Long, Integer> combinedLine = combineOrderLines(orderLines);

        combinedLine.forEach((key, value) -> {
            Product product = productRepository.findOne(key);

            if (value <= product.getQuantity())
                results.put(product.getId(), true);
            else
                results.put(product.getId(), false);
        });

        return results;
    }

    /**
     * This method will combine all order lines that has same product.
     *
     * @param orderLines
     *        List<OrderLine>
     * @return map key is product id and value is requested quantities.
     */
    private Map<Long, Integer> combineOrderLines(List<OrderLine> orderLines) {
        Map<Long, Integer> combainedLine = new HashMap<Long, Integer>();

        for (OrderLine orderLine : orderLines) {
            if (combainedLine.containsKey(orderLine.getOrderLineId().getProdId())) {
                Integer qtn = combainedLine.get(orderLine.getOrderLineId().getProdId());
                combainedLine.put(orderLine.getOrderLineId().getProdId(), orderLine.getQuantity() + qtn);
            } else {
                combainedLine.put(orderLine.getOrderLineId().getProdId(), orderLine.getQuantity());
            }
        }
        return combainedLine;
    }

    /*
     * (non-Javadoc)
     * @see com.crossover.salesorder.backend.services.IProductService#
     * checkQuantityBalance(Long)
     */
    @Override
    public Boolean checkQuantityBalance(Long id, Integer qtn) {
        Product product = productRepository.findOne(id);

        if (qtn <= product.getQuantity())
            return true;
        else
            return false;
    }

}
