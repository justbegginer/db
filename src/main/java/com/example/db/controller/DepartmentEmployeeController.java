package com.example.db.controller;

import com.example.db.models.DepartmentEmployee;
import com.example.db.services.impls.DepartmentEmployeeServiceImpl;
import com.example.db.services.impls.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

@Controller
@RequestMapping("/departmentEmployee")
public class DepartmentEmployeeController {

    private final DepartmentEmployeeServiceImpl departmentEmployeeService;

    private final EmployeeServiceImpl employeeService;

    @Autowired
    public DepartmentEmployeeController(DepartmentEmployeeServiceImpl departmentEmployeeService,
                                        EmployeeServiceImpl employeeService) {
        this.departmentEmployeeService = departmentEmployeeService;
        this.employeeService = employeeService;
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
            return "redirect:/department/" + departmentEmployee.get().getDepartmentId();
        } else {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND,String.format("The employee named %s is not assigned to any department", employeeService.findById(employeeId).get().getLastName().toUpperCase()));
        }
    }

}
