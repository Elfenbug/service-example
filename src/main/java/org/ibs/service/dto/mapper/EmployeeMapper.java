package org.ibs.service.dto.mapper;

import org.ibs.service.domain.entity.Employee;
import org.ibs.service.dto.EmployeeDto;
import org.mapstruct.Mapper;

@Mapper
public interface EmployeeMapper {
    EmployeeDto toDto(Employee employee);
}
