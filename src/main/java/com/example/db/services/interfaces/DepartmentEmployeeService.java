package com.example.db.services.interfaces;

import com.example.db.models.DepartmentEmployee;

import java.util.Optional;

public interface DepartmentEmployeeService extends CrudService<DepartmentEmployee> {
    Optional<DepartmentEmployee> findByEmployeeId(int id);
}
