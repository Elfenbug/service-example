package org.ibs.service.rest.v2;

import lombok.extern.slf4j.Slf4j;
import org.ibs.service.domain.bussines.BossService;
import org.ibs.service.domain.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController("boss controller v2")
@RequestMapping("/v2/boss")
@Slf4j
public class BossController {

    @Autowired
    private BossService service;

    @GetMapping
    Iterable<Employee> getAll(@RequestParam(required = false) Long id) {
        return service.underlingList(id);
    }

    @GetMapping("/chief")
    Optional<Employee> getChief(@RequestParam(required = false) Long id) {
        return service.getChief(id);
    }

    @GetMapping("/salary")
    Optional<Employee> getSalaryOverChief(@RequestParam(required = false) Long id) {
        return service.getChief(id);
    }


}
