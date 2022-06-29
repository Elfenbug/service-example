package org.ibs.service;

import org.ibs.service.domain.EmployeeRepository;
import org.ibs.service.domain.entity.Course;
import org.ibs.service.domain.entity.Department;

import org.ibs.service.domain.entity.Employee;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(value=false)
public class DbTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    EmployeeRepository employeeRepository;

    @BeforeEach
    public void setup() {
        Department department = new Department(null, "IT");
        Course course = new Course(null,"REST service");

        em.persist(department);
        em.persist(course);
    }

    @Test
    public void test() {

    }

    @Test
    public void test2() {
        Employee emp = employeeRepository.findByFirstName("a").get();
        Assert.assertEquals("a", emp.getCourse().get(0).getName());
    }
}
