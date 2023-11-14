package com.example.db.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @GetMapping("/{id}")
    public String getProject(@PathVariable("id") int id, Model model) {
        model.addAttribute("id", id);
        return "project/get";
    }

    @GetMapping("/add")
    public String addNewProject() {
        return "project/add";
    }

    @GetMapping
    public  String getAllProjects(){
        return "project/all";
    }

    @GetMapping("/edit/{id}")
    public String updateEmployee(@PathVariable("id") int id, Model model){
        model.addAttribute("id", id);
        return "project/edit";
    }


}
