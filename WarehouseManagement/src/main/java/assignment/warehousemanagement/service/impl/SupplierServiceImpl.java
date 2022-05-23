package assignment.warehousemanagement.service.impl;

import assignment.warehousemanagement.entity.Supplier;
import assignment.warehousemanagement.repository.SupplierRepository;
import assignment.warehousemanagement.service.SupplierService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supRepo;

    @Override
    public List<Supplier> getAllSuppliers() {
        return supRepo.findAll();
    }

    @Override
    public Supplier getSupplierById(Integer id) {
        return supRepo.getById(id);
    }
}
