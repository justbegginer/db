package com.example.db.services.impls;

import com.example.db.models.Department;
import com.example.db.repo.DepartmentRepo;
import com.example.db.services.interfaces.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepo departmentRepo;


    @Autowired
    public DepartmentServiceImpl(DepartmentRepo departmentRepo){
        this.departmentRepo = departmentRepo;
    }

    @Override
    public void delete(Department department) {
        departmentRepo.delete(department);
    }

    @Override
    public void save(Department elem) {
        departmentRepo.save(elem);
    }

    @Override
    public Optional<Department> findById(long id) {
        return departmentRepo.findById(id);
    }

    @Override
    public List<Department> findAll() {
        return departmentRepo.findAll();
    }
}
