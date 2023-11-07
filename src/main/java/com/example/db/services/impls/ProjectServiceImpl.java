package com.example.db.services.impls;

import com.example.db.models.Project;
import com.example.db.repo.ProjectRepo;
import com.example.db.services.interfaces.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    private ProjectRepo projectRepo;

    @Autowired
    public ProjectServiceImpl(ProjectRepo projectRepo){
        this.projectRepo = projectRepo;
    }

    @Override
    public void delete(Project elem) {
        projectRepo.delete(elem);
    }

    @Override
    public void save(Project elem) {
        projectRepo.save(elem);
    }

    @Override
    public Optional<Project> findById(long id) {
        return projectRepo.findById(id);
    }

    @Override
    public List<Project> findAll() {
        return projectRepo.findAll();
    }
}
