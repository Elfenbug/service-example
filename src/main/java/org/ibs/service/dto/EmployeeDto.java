package org.ibs.service.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeDto {

    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private Integer monthSalary;
}
