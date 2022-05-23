package assignment.warehousemanagement.service;

import assignment.warehousemanagement.entity.Slip;

public interface SlipService {
    public void saveSlip(Slip slip);
    public Slip getSlipByID(Integer id);
}
