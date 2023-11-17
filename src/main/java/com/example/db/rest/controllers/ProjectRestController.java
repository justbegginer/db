package com.example.db.rest.controllers;

import com.example.db.models.Project;
import com.example.db.services.impls.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest/project")
public class ProjectRestController {

    private final ProjectServiceImpl projectService;

    @Autowired
    public ProjectRestController(ProjectServiceImpl projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProject(@PathVariable("id") int id) {
        Optional<Project> optionalProject = projectService.findById(id);
        if (optionalProject.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(optionalProject.get(), HttpStatus.OK);
        }
    }

    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.findAll();
    }

    @PostMapping
    public ResponseEntity<Void> addNewProject(@RequestBody Project project) {
        projectService.save(project);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") int id) {
        projectService.delete(projectService.findById(id).get());
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateEmployee(@PathVariable("id") int id, @RequestBody Project project) {
        projectService.save(project);
        return ResponseEntity.ok().build();
    }
}
