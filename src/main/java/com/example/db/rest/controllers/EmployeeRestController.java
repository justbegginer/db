package com.example.db.rest.controllers;

import com.example.db.models.Employee;
import com.example.db.services.impls.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest/employee")
public class EmployeeRestController {
    private final EmployeeServiceImpl employeeService;

    @Autowired
    public EmployeeRestController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") long id) {
        Optional<Employee> employee = employeeService.findById(id);
        if (employee.isEmpty()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(employee.get(), HttpStatus.OK);
        }
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }

    @PostMapping
    public ResponseEntity<Void> addNewEmployee(@RequestBody Employee employee) {
        employeeService.save(employee);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteEmployee(@RequestBody Employee employee) {
        employeeService.delete(employee);
        return ResponseEntity.ok().build();
    }

    @PatchMapping
    public ResponseEntity<Void> updateEmployee(@RequestBody Employee employee) {
        if (employeeService.findEmployeeByFullName
                (employee.getFirstName(), employee.getPatherName(), employee.getLastName()).isPresent()) {
            return ResponseEntity.badRequest().build();// TODO detalize error-response message
        }
        employeeService.save(employee);
        return ResponseEntity.ok().build();
    }

}