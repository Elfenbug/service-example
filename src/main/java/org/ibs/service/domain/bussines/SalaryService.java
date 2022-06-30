package org.ibs.service.domain.bussines;

import org.ibs.service.domain.entity.Department;
import org.ibs.service.domain.entity.Employee;
import org.ibs.service.dto.EmployeeDto;
import org.ibs.service.dto.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Optional;

@Service
public class SalaryService {

    @Autowired
    private DepartmentRepository repository;

    @Autowired
    private EmployeeMapper mapper;

    public Optional<EmployeeDto> maxSalaryEmployeeInDepartment(Long departmentId) {
        Optional<Department> departmentOpt = repository.findById(departmentId);
        if (!departmentOpt.isPresent() || departmentOpt.get().getEmployees().isEmpty()) {
            return Optional.empty();
        }

        Employee employee = departmentOpt.get().getEmployees().stream()
                .max(Comparator.comparing(Employee::getMonthSalary)).get();

        return  Optional.of(mapper.toDto(employee));
    }
}
