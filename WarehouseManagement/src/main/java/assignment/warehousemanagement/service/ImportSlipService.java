package assignment.warehousemanagement.service;

import assignment.warehousemanagement.entity.ImportSlip;

public interface ImportSlipService {
    public ImportSlip saveImportSlip(ImportSlip importSlip);
    public ImportSlip getImportSlipById(Integer id);
}
