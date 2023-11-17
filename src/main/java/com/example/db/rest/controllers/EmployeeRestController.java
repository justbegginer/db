package com.example.db.rest.controllers;

import com.example.db.models.Employee;
import com.example.db.services.impls.DepartmentEmployeeServiceImpl;
import com.example.db.services.impls.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest/employee")
public class EmployeeRestController {
    private final EmployeeServiceImpl employeeService;

    private final DepartmentEmployeeServiceImpl departmentEmployeeService;

    @Autowired
    public EmployeeRestController(EmployeeServiceImpl employeeService, DepartmentEmployeeServiceImpl departmentEmployeeService) {
        this.employeeService = employeeService;
        this.departmentEmployeeService = departmentEmployeeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") int id) {
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

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") int id) {
        if (departmentEmployeeService.findByEmployeeId(id).isPresent()) {
            departmentEmployeeService.delete(departmentEmployeeService.findByEmployeeId(id).get());
        }
        employeeService.delete(employeeService.findById(id).get());
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
        employee.setId(id);
        if (employeeService.findEmployeeByFullName
                (employee.getFirstName(), employee.getPatherName(), employee.getLastName()).isPresent()) {
            return ResponseEntity.badRequest().build();// TODO detalize error-response message
        }
        employeeService.save(employee);
        return ResponseEntity.ok().build();
    }

}
