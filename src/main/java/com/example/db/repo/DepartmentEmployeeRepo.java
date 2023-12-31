package com.example.db.repo;

import com.example.db.models.DepartmentEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentEmployeeRepo extends JpaRepository<DepartmentEmployee, Integer> {

    Optional<DepartmentEmployee> findDepartmentEmployeeByEmployeeId(int id);

    List<DepartmentEmployee> findAllByDepartmentId(int id);
}
