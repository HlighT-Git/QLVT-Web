package assignment.warehousemanagement.service.impl;

import assignment.warehousemanagement.entity.Product;
import assignment.warehousemanagement.repository.ProductRepository;
import assignment.warehousemanagement.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository prdRepo;

    @Override
    public List<Product> getAllProducts() {
        return prdRepo.findAll();
    }

    @Override
    public Product getProductById(Integer id) {
        return prdRepo.getById(id);
    }

    @Override
    public void saveProduct(Product product) {
        prdRepo.save(product);
    }
}
