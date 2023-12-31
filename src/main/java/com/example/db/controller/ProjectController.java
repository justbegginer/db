package com.example.db.controller;

import com.example.db.models.Department;
import com.example.db.models.Project;
import com.example.db.services.impls.ProjectServiceImpl;
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
@RequestMapping("/project")
public class ProjectController {

    private final ProjectServiceImpl projectService;

    @Autowired
    public ProjectController(ProjectServiceImpl projectService){
        this.projectService = projectService;
    }

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
    public String getAllProjects() {
        return "project/all";
    }

    @GetMapping("/edit/{id}")
    public String updateEmployee(@PathVariable("id") int id, Model model) {
        model.addAttribute("id", id);
        return "project/edit";
    }

    @GetMapping("/redirect/{id}")
    public String moveToDepartmentOfProject(@PathVariable("id") int projectId){
        Integer departmentId = projectService.findById(projectId).get().getDepartmentId();
        if (departmentId != null){
            return "redirect:/department/"+departmentId;
        }
        else{
            // check http status code class and how it's work
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, String.format("The project named %s is not assigned to any department", projectService.findById(projectId).get().getName().toUpperCase()));
        }

    }


}
