package com.example.db.repo;

import com.example.db.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepo extends JpaRepository<Project, Integer> {

    List<Project> findAllByDepartmentId(int id);
}
