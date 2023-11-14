package com.example.db.repo;

import com.example.db.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

    Optional<Employee> findEmployeeByFirstNameAndPatherNameAndLastName(String firstName, String patherName, String lastName);
}
