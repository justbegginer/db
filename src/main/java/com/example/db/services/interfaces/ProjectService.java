package com.example.db.services.interfaces;

import com.example.db.models.Project;

import java.util.List;

public interface ProjectService extends CrudService<Project> {
    List<Project> findAllByDepartmentId(int id);
}
