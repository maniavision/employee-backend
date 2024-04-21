package com.maniavision.employeedemo.service;

import com.maniavision.employeedemo.entity.Employee;
import com.maniavision.employeedemo.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees() {
        return this.employeeRepository.findAll();
    }

    public Employee getEmployeeById(long id) {
        log.info("Getting employee with id: " + id);
        return this.employeeRepository.getEmployeeById(id);
    }

    public void saveEmployee(Employee newEmployee) {
        log.info("Saving employee: " + newEmployee);
        this.employeeRepository.save(newEmployee);
    }

    public void updateEmployee(Employee updatedEmployee) {
        log.info("Update an employee.");
        this.employeeRepository.save(updatedEmployee);
    }

    public void deleteEmployeeById(long id) {
        log.info("Deleting employee with id: " + id);
        this.employeeRepository.deleteById(id);
    }
}
