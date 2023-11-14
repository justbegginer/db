package com.example.db.controller;

import com.example.db.services.impls.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/department")
public class DepartmentController {
    @GetMapping("/{id}")
    public String getDepartment(@PathVariable("id") int id, Model model){
        model.addAttribute("id", id);
        return "department/get";
    }

    @GetMapping("/add")
    public String addNewDepartment(){
        return "department/add";
    }

    @GetMapping
    public String getAllDepartments(){
        return "department/all";
    }

    @GetMapping("/edit/{id}")
    public String updateDepartment(@PathVariable("id") int id, Model model){
        model.addAttribute("id", id);
        return "department/edit";
    }
}
