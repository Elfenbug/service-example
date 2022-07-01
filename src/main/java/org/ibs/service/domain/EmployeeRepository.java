package org.ibs.service.domain;

import org.ibs.service.domain.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    List<Employee> findAllByFirstName(String firstName);

    @Query("select a from Employee a, Employee b where b.id = a.bossId and a.monthSalary > b.monthSalary")
    List<Employee> findAllEmployeeOverPrice();

}
