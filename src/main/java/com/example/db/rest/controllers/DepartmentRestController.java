package com.example.db.rest.controllers;

import com.example.db.models.Department;
import com.example.db.services.impls.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest/department")
public class DepartmentRestController {

    private final DepartmentServiceImpl departmentService;

    @Autowired
    public DepartmentRestController(DepartmentServiceImpl departmentService){
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartment(@PathVariable("id") int id){
        Optional<Department> optionalDepartment = departmentService.findById(id);
        if (optionalDepartment.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(optionalDepartment.get(), HttpStatus.OK);
        }
    }

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.findAll();
    }

    @PostMapping
    public ResponseEntity<Void> addNewProject(@RequestBody Department department) {
        departmentService.save(department);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") int id) {
        departmentService.delete(departmentService.findById(id).get());
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateEmployee(@PathVariable("id")int id, @RequestBody Department department) {
        department.setId(id);
        System.out.println(department.getId());
        departmentService.save(department);
        return ResponseEntity.ok().build();
    }

}
