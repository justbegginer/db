package com.example.db.rest.controllers;

import com.example.db.models.DepartmentEmployee;
import com.example.db.services.impls.DepartmentEmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/department_employee")
public class DepartmentEmployeeRestController {

    private final DepartmentEmployeeServiceImpl departmentEmployeeService;

    @Autowired
    public DepartmentEmployeeRestController(DepartmentEmployeeServiceImpl departmentEmployeeService){
        this.departmentEmployeeService = departmentEmployeeService;
    }

    @PostMapping
    public ResponseEntity<Void> addNewDepartmentEmployee(@RequestBody DepartmentEmployee departmentEmployee){
        if (departmentEmployeeService.findByEmployeeId(departmentEmployee.getEmployeeId()).isPresent()){
            departmentEmployee.setId(departmentEmployeeService.findByEmployeeId(departmentEmployee.getEmployeeId()).get().getId());
        }
        departmentEmployeeService.save(departmentEmployee);
        return ResponseEntity.ok().build();
    }




}
