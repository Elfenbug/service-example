package org.ibs.service.rest.v2;

import io.swagger.v3.oas.annotations.Operation;
import org.ibs.service.domain.bussines.SalaryService;
import org.ibs.service.dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/v2/salary/")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    @GetMapping("max/department/{departmentId}")
    @Operation(operationId = "maxSalaryEmployeeInDep", summary = "get max salary employee")
    EmployeeDto maxSalaryEmployeeInDep(@PathVariable Long departmentId) {
        return salaryService.maxSalaryEmployeeInDepartment(departmentId)
                .orElseThrow(()-> new ResponseStatusException((HttpStatus.NOT_FOUND),
                        "Department or employees not found"));
    }
}
