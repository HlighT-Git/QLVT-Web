package assignment.warehousemanagement.service.impl;

import assignment.warehousemanagement.entity.Slip;
import assignment.warehousemanagement.repository.SlipRepository;
import assignment.warehousemanagement.service.SlipService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SlipServiceImpl implements SlipService {
    private final SlipRepository slipRepo;

    @Override
    public void saveSlip(Slip slip) {
        slipRepo.saveAndFlush(slip);
    }

    @Override
    public Slip getSlipByID(Integer id) {
        return slipRepo.getById(id);
    }
}
