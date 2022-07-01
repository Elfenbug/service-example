package org.ibs.service.domain.bussines;

import org.ibs.service.domain.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BossService {

    @Autowired
    private BossRepository repository;

    public List<Employee> underlingList(Long id) {
        return repository.findAllByBossId(id);
    }

    public Optional<Employee> getChief(Long underlingId) {
        Optional<Employee> employeeOpt = repository.findById(underlingId);
        employeeOpt = repository.findById(employeeOpt.get().getBossId());
        return employeeOpt;
    }


}
