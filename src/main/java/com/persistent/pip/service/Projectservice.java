package com.persistent.pip.service;

import com.persistent.pip.model.Project;

import java.util.List;
import java.util.Optional;

public interface Projectservice {

    public List<Project> getProjects();
    public Optional<Project> getProjectById(int projectid);
    public Project addNewProject(Project project);
    public Project updateProject(Project project);
    public void deleteProjectById(int projectid);
    public void deleteAllProjects();
}
