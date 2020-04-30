package com.persistent.pip.service;

import com.persistent.pip.dao.Projectdaorepository;
import com.persistent.pip.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Projectserviceimpl implements  Projectservice{

    @Autowired
    Projectdaorepository dao;

    @Override
    public List<Project> getProjects() {
        return dao.findAll();
    }
    @Override
    public Optional<Project> getProjectById(int empid) {
        return dao.findById(empid);
    }
    @Override
    public Project addNewProject(Project emp) {
        return dao.save(emp);
    }
    @Override
    public Project updateProject(Project emp) {
        return dao.save(emp);
    }
    @Override
    public void deleteProjectById(int empid) {
        dao.deleteById(empid);
    }
    @Override
    public void deleteAllProjects() {
        dao.deleteAll();
    }
}
