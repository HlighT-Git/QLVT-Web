package assignment.warehousemanagement.service;

import assignment.warehousemanagement.entity.ProductInSlip;

import java.util.Set;

public interface ProductInSlipService {
    public void saveAllProductInSlips(Set<ProductInSlip> productInSlip);
}
