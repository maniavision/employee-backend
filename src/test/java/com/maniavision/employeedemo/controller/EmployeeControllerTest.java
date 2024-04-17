package com.maniavision.employeedemo.controller;

import com.maniavision.employeedemo.entity.Employee;
import com.maniavision.employeedemo.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class EmployeeControllerTest {

    @Mock
    EmployeeService mockEmployeeService;

    @InjectMocks
    EmployeeController controller;

    @Test
    void testGetEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1l, "John", "Doe", new Date(1990,11,06)
                , new Date(2019,06,06), null));

        when(mockEmployeeService.getEmployees()).thenReturn(employees);

        ResponseEntity<List<Employee>> response = controller.getEmplpoyees();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        assertEquals("John", response.getBody().get(0).getFirstName());
    }

    @Test
    void testSaveEmployee() {
        Employee employee = new Employee(1l, "John", "Doe", new Date(1990,11,06)
                , new Date(2019,06,06), null);

        controller.saveEmployee(employee);

        verify(mockEmployeeService, times(1)).saveEmployee(employee);
    }

    @Test
    void testGetEmployeeById() {
        Employee employee = new  Employee(1l, "John", "Doe", new Date(1990,11,06)
                , new Date(2019,06,06), null);

        when(mockEmployeeService.getEmployeeById(1)).thenReturn(employee);

        ResponseEntity<Employee> response = controller.getEmployeeById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("John", response.getBody().getFirstName());
    }

    @Test
    void testUpdateEmployee() {
        Employee employee = new Employee(1l, "John", "Doe", new Date(1990,11,06)
                , new Date(2019,06,06), null);

        controller.updateEmployee(employee);

        verify(mockEmployeeService, times(1)).updateEmployee(employee);
    }

    @Test
    void testDeleteEmployeeById() {
        controller.deleteEmployeeById(1);

        verify(mockEmployeeService, times(1)).deleteEmployeeById(1);
    }
}
