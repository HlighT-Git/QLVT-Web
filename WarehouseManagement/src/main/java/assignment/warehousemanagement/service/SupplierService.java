package assignment.warehousemanagement.service;

import assignment.warehousemanagement.entity.Supplier;

import java.util.List;

public interface SupplierService {
    public List<Supplier> getAllSuppliers();
    public Supplier getSupplierById(Integer id);
}
