package assignment.warehousemanagement.repository;

import assignment.warehousemanagement.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
