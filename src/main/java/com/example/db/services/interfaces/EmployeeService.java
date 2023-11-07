package com.example.db.services.interfaces;

import com.example.db.models.Employee;

import java.util.Optional;

public interface EmployeeService extends CrudService<Employee>{
    public Optional<Employee> findEmployeeByFullName(String firstName, String fatherName, String lastName);
}
