package org.ibs.service.domain.bussines;

import org.ibs.service.domain.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BossRepository extends CrudRepository<Employee, Long> {
    List<Employee> findAllByBossId(Long id);

}
