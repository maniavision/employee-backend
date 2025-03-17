package com.maniavision.employeedemo.controller;

import com.maniavision.employeedemo.entity.Employee;
import com.maniavision.employeedemo.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    ResponseEntity<List<Employee>> getEmployees() {
        return ResponseEntity.ok(this.employeeService.getEmployees());
    }

    @PostMapping(path = "")
    public void saveEmployee(@RequestBody Employee employee) {
        this.employeeService.saveEmployee(employee);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
        return ResponseEntity.ok(this.employeeService.getEmployeeById(id));
    }

    @PutMapping(path = "/{id}")
    public void updateEmployee(@RequestBody Employee updatedEmployee) {
        this.employeeService.updateEmployee(updatedEmployee);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteEmployeeById(@PathVariable long id) {
        this.employeeService.deleteEmployeeById(id);
    }
}
