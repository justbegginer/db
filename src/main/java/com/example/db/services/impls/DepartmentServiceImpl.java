package com.example.db.services.impls;

import com.example.db.models.Department;
import com.example.db.models.DepartmentEmployee;
import com.example.db.models.Project;
import com.example.db.repo.DepartmentRepo;
import com.example.db.services.interfaces.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepo departmentRepo;

    private final DepartmentEmployeeServiceImpl departmentEmployeeService;

    private final ProjectServiceImpl projectService;


    @Autowired
    public DepartmentServiceImpl(DepartmentRepo departmentRepo,
                                 DepartmentEmployeeServiceImpl departmentEmployeeService,
                                 ProjectServiceImpl projectService) {
        this.departmentRepo = departmentRepo;
        this.departmentEmployeeService = departmentEmployeeService;
        this.projectService = projectService;
    }

    @Override
    public void delete(Department department) {
        // delete relation between department and employee
        for (DepartmentEmployee departmentEmployee :
                departmentEmployeeService.findAllByDepartmentId(department.getId())) {
            departmentEmployeeService.delete(departmentEmployee);
        }
        // set null in projects field department id
        for (Project project : projectService.findAllByDepartmentId(department.getId())) {
            project.setDepartmentId(null);
            projectService.save(project);
        }
        departmentRepo.delete(department);
    }

    @Override
    public void save(Department elem) {
        departmentRepo.save(elem);
    }

    @Override
    public Optional<Department> findById(int id) {
        return departmentRepo.findById(id);
    }

    @Override
    public List<Department> findAll() {
        return departmentRepo.findAll();
    }
}
