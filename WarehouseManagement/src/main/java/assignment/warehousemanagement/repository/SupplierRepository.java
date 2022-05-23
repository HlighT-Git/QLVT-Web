package assignment.warehousemanagement.repository;

import assignment.warehousemanagement.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
}
