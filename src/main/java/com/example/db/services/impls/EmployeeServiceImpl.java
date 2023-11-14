package com.example.db.services.impls;

import com.example.db.models.Employee;
import com.example.db.repo.EmployeeRepo;
import com.example.db.services.interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepo employeeRepo){
        this.employeeRepo = employeeRepo;
    }

    @Override
    public void delete(Employee elem) {
        employeeRepo.delete(elem);
    }

    @Override
    public void save(Employee elem) {
        employeeRepo.save(elem);
    }

    @Override
    public Optional<Employee> findById(int id) {
        return employeeRepo.findById(id);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    @Override
    public Optional<Employee> findEmployeeByFullName(String firstName, String fatherName, String lastName) {
        return employeeRepo.findEmployeeByFirstNameAndPatherNameAndLastName(firstName, fatherName, lastName);
    }
}
