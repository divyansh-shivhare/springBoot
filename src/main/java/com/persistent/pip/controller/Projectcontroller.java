package com.persistent.pip.controller;

import com.persistent.pip.model.Employee;
import com.persistent.pip.model.Project;
import com.persistent.pip.service.Projectservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Projectcontroller {

    @Autowired
    Projectservice projectservice;

    @RequestMapping(value= "/project/all", method= RequestMethod.GET)
    public List<Project> getProjects() {
        System.out.println(this.getClass().getSimpleName() + " - Get all Project details service is invoked.");
        return projectservice.getProjects();
    }

    @RequestMapping(value= "/project/{id}", method= RequestMethod.GET)
    public Project getProjectById(@PathVariable int id) throws Exception {
        System.out.println(this.getClass().getSimpleName() + " - Get employee details by id is invoked.");

        Optional<Project> project =  projectservice.getProjectById(id);
        if(!project.isPresent())
            throw new Exception("Could not find employee with id- " + id);

        return project.get();
    }

    @RequestMapping(value= "/project/add", method= RequestMethod.POST)
    public Project addNewProject(@RequestBody Project newproject) throws Exception {
        System.out.println(this.getClass().getSimpleName() + " - Create new Project method is invoked.");
        int id =newproject.getProjecctId();
        // String email = newemp.getEmpEmail();
        Optional<Project> project =  projectservice.getProjectById(id);


        if (project.isPresent()){
            throw new Exception("Project already existed with id- " + id);}


        return projectservice.addNewProject(newproject);
    }

    @RequestMapping(value= "/project/update/{id}", method= RequestMethod.PUT)
    public Project updateProject(@RequestBody Project upproject, @PathVariable int id) throws Exception {
        System.out.println(this.getClass().getSimpleName() + " - Update project details by id is invoked.");

        Optional<Project> project =  projectservice.getProjectById(id);
        if (!project.isPresent())
            throw new Exception("Could not find project with id- " + id);

        /* IMPORTANT - To prevent the overiding of the existing value of the variables in the database,
         * if that variable is not coming in the @RequestBody annotation object. */
        if(upproject.getProjectName() == null || upproject.getProjectName().isEmpty())
            upproject.setProjectName(project.get().getProjectName());
      /*  if(upproject.getEmpEmail() == null || upproject.getEmpEmail().isEmpty())
            upproject.setEmpEmail(emp.get().getEmpEmail());
        if(upproject.getRole() == null)
            upproject.setRole(emp.get().getRole());*/

        // Required for the "where" clause in the sql query template.
        upproject.setProjecctId(id);
        return projectservice.updateProject(upproject);
    }

    @RequestMapping(value= "/project/delete/{id}", method= RequestMethod.DELETE)
    public void deleteProjectById(@PathVariable int id) throws Exception {
        System.out.println(this.getClass().getSimpleName() + " - Delete project by id is invoked.");

        Optional<Project> project =  projectservice.getProjectById(id);
        if(!project.isPresent())
            throw new Exception("Could not find project with id- " + id);

        projectservice.deleteProjectById(id);
    }

    @RequestMapping(value= "/project/deleteall", method= RequestMethod.DELETE)
    public void deleteAll() {
        System.out.println(this.getClass().getSimpleName() + " - Delete all project is invoked.");
        projectservice.deleteAllProjects();
    }
}
