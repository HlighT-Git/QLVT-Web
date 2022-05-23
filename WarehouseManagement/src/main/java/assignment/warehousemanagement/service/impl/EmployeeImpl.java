package assignment.warehousemanagement.service.impl;

import assignment.warehousemanagement.entity.Employee;
import assignment.warehousemanagement.repository.EmployeeRepository;
import assignment.warehousemanagement.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeRepository.getById(id);
    }
}
