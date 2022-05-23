package assignment.warehousemanagement.service.impl;

import assignment.warehousemanagement.entity.ProductInSlip;
import assignment.warehousemanagement.repository.ProductInSlipRepository;
import assignment.warehousemanagement.service.ProductInSlipService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
public class ProductInSlipServiceImpl implements ProductInSlipService {
    private final ProductInSlipRepository prdInSlipRepo;

    @Override
    public void saveAllProductInSlips(Set<ProductInSlip> productInSlip) {
        prdInSlipRepo.saveAll(productInSlip);
    }
}
