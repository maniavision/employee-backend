package com.maniavision.employeedemo.controller;

import com.maniavision.employeedemo.entity.Employee;
import com.maniavision.employeedemo.service.EmployeeService;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    ResponseEntity<List<Employee>> getEmplpoyees() {
        return ResponseEntity.ok(this.employeeService.getEmployees());
    }

    @PostMapping(path = "/employee")
    public void saveEmployee(@RequestBody Employee employee) {
        this.employeeService.saveEmployee(employee);
    }

    @GetMapping(path = "/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long employeeId) {
        return ResponseEntity.ok(this.employeeService.getEmployeeById(employeeId));
    }

    @PutMapping(path = "/employee")
    public void updateEmployee(@RequestBody Employee updatedEmployee) {
        this.employeeService.updateEmployee(updatedEmployee);
    }

    @DeleteMapping(path = "/{employeeId}")
    public void deleteEmployeeById(@PathVariable long employeeId) {
        this.employeeService.deleteEmployeeById(employeeId);
    }
}
