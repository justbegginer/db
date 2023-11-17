package com.example.db.controller;

import com.example.db.models.DepartmentEmployee;
import com.example.db.services.impls.DepartmentEmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/departmentEmployee")
public class DepartmentEmployeeController {

    private final DepartmentEmployeeServiceImpl departmentEmployeeService;

    @Autowired
    public DepartmentEmployeeController(DepartmentEmployeeServiceImpl departmentEmployeeService) {
        this.departmentEmployeeService = departmentEmployeeService;
    }

    @GetMapping("/{id}")
    public String linkEmployeeToDepartment(@PathVariable("id") int employeeId, Model model) {
        model.addAttribute("id", employeeId);
        return "departmentEmployee/add";
    }

    @GetMapping("/redirect/{id}")
    public String moveToDepartmentOfEmployee(@PathVariable("id") int employeeId) {
        Optional<DepartmentEmployee> departmentEmployee = departmentEmployeeService.findByEmployeeId(employeeId);
        if (departmentEmployee.isPresent()) {
            return "redirect:/department/" +departmentEmployee.get().getDepartmentId();
        }
        else {
            return "errors/departmentOfEmployeeNotFind";
        }
    }

}
