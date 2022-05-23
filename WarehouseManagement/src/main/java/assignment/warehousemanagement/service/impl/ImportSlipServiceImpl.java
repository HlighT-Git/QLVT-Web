package assignment.warehousemanagement.service.impl;

import assignment.warehousemanagement.entity.ImportSlip;
import assignment.warehousemanagement.repository.ImportSlipRepository;
import assignment.warehousemanagement.service.ImportSlipService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ImportSlipServiceImpl implements ImportSlipService {
    private final ImportSlipRepository impSlipRepo;

    @Override
    public ImportSlip saveImportSlip(ImportSlip importSlip) {
        return impSlipRepo.saveAndFlush(importSlip);
    }

    @Override
    public ImportSlip getImportSlipById(Integer id) {
        return impSlipRepo.getById(id);
    }
}
