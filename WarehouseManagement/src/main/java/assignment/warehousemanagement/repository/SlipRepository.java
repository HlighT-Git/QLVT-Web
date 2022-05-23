package assignment.warehousemanagement.repository;

import assignment.warehousemanagement.entity.Slip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SlipRepository extends JpaRepository<Slip, Integer> {
}
