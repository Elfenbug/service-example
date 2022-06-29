package org.ibs.service.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    @Column(name = "month_salary")
    private Integer monthSalary;

    @ManyToMany
    @JoinTable(name="employee_course",
    joinColumns = @JoinColumn(name="employee_id"),
    inverseJoinColumns = @JoinColumn(name="course_id"))
    private List<Course> course;

}