package com.example.db.services.impls;

import com.example.db.models.DepartmentEmployee;
import com.example.db.repo.DepartmentEmployeeRepo;
import com.example.db.services.interfaces.DepartmentEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentEmployeeServiceImpl implements DepartmentEmployeeService {

    private DepartmentEmployeeRepo departmentEmployeeRepo;

    @Autowired
    public DepartmentEmployeeServiceImpl(DepartmentEmployeeRepo departmentEmployeeRepo){
        this.departmentEmployeeRepo = departmentEmployeeRepo;
    }

    @Override
    public void delete(DepartmentEmployee elem) {
        departmentEmployeeRepo.delete(elem);
    }

    @Override
    public void save(DepartmentEmployee elem) {
        departmentEmployeeRepo.save(elem);
    }

    @Override
    public Optional<DepartmentEmployee> findById(int id) {
        return departmentEmployeeRepo.findById(id);
    }

    @Override
    public List<DepartmentEmployee> findAll() {
        return departmentEmployeeRepo.findAll();
    }

    @Override
    public Optional<DepartmentEmployee> findByEmployeeId(int id) {
        return departmentEmployeeRepo.findDepartmentEmployeeByEmployeeId(id);
    }
}
