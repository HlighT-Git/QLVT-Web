package assignment.warehousemanagement.service;

import assignment.warehousemanagement.entity.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAllProducts();
    public Product getProductById(Integer id);
    public void saveProduct(Product product);
}
