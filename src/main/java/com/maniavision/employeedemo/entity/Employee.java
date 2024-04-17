package com.maniavision.employeedemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.sql.Date;

@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Employee")
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;

    @Column(name = "hired_date", nullable = false)
    private Date hiredDate;

    @Column(name = "termination_date", nullable = true)
    private Date terminationDate;
}
