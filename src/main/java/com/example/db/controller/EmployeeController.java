package com.example.db.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @GetMapping("/{id}")
    public String getEmployee(@PathVariable("id") int id, Model model){
        model.addAttribute("id", id);
        return "employee/get";
    }

    @GetMapping("/add")
    public String addNewEmployee(){
        return "employee/add";
    }

    @GetMapping
    public String getAllEmployees(){
        return "employee/all";
    }

    @GetMapping("/edit/{id}")
    public String updateEmployee(@PathVariable("id") int id, Model model){
        model.addAttribute("id", id);
        return "employee/edit";
    }


}
