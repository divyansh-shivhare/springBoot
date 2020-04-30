package com.persistent.pip.controller;

import java.util.List;
import java.util.Optional;

import com.persistent.pip.model.User;
import com.persistent.pip.service.UserService;
//import com.sun.deploy.ui.DeployEmbeddedFrameIf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.persistent.pip.model.Employee;
import com.persistent.pip.service.Employeeservice;

@RestController
public class Employeecontroller {

    @Autowired
    Employeeservice employeeService;

    @Autowired
    UserService userService;
    
    @RequestMapping("/welcome")
	public ModelAndView firstPage() {
		return new ModelAndView("welcome");
	}

    @RequestMapping(value= "/employee/all", method= RequestMethod.GET)
    /*public List<Employee> getEmployees() {
        System.out.println(this.getClass().getSimpleName() + " - Get all employees service is invoked.");
       return employeeService.getEmployees();*/
        
         public ModelAndView getEmployees() {
    		List<Employee> employees = employeeService.getEmployees();
    		ModelAndView model = new ModelAndView("getEmployees");
    		model.addObject("employees", employees);
    		return model;
    }

    @RequestMapping(value= "/employee/{id}", method= RequestMethod.GET)
    public Employee getEmployeeById(@PathVariable int id) throws Exception {
        System.out.println(this.getClass().getSimpleName() + " - Get employee details by id is invoked.");

        Optional<Employee> emp =  employeeService.getEmployeeById(id);
        if(!emp.isPresent())
            throw new Exception("Could not find employee with id- " + id);

        return emp.get();
    }

    @RequestMapping(value= "/employee/add", method= RequestMethod.POST)
	public ModelAndView processRequest(@ModelAttribute("emp") Employee newemp) throws Exception {

		          
		List<Employee> employees = employeeService.getEmployees();
		int id =newemp.getEmpId();
	       String email = newemp.getEmpEmail();
	        Optional<Employee> empById =  employeeService.getEmployeeById(id);




	        if (empById.isPresent()){
	    

	            throw new Exception("Employee already existed with id- " + id);}


	        Optional<Employee> empByEmail = employeeService.finyByEmpIdAndEmpEmail( email);
	        if(empByEmail.isPresent()){
	            throw new Exception("Employee already existed with same email- " + email);}

	        
	        Employee employee = employeeService.addNewEmployee(newemp);

		ModelAndView model = new ModelAndView("getEmployees");
		model.addObject("employees", employee);
		return model;
	
  /*  public Employee createEmployee(@RequestBody Employee newemp) throws Exception {
        System.out.println(this.getClass().getSimpleName() + " - Create new employee method is invoked.");
        int id =newemp.getEmpId();
       String email = newemp.getEmpEmail();
        Optional<Employee> empById =  employeeService.getEmployeeById(id);




        if (empById.isPresent()){
           // Employee obj = emp.get();
          //  if(obj.getEmpEmail()== email){
             //   throw new Exception("Employee already existed with email- " + email);}
            //Emp 1, A, a@gmail.com Emp

            throw new Exception("Employee already existed with id- " + id);}


        Optional<Employee> empByEmail = employeeService.finyByEmpIdAndEmpEmail( email);
        if(empByEmail.isPresent()){
            throw new Exception("Employee already existed with same email- " + email);}

        //Emp emp = service.addNewEmp(newEmp)
        //userService.save
        Employee employee = employeeService.addNewEmployee(newemp);
       // User user = new User( email);
       // User addedUser = userService.saveUser(user);

        return employee;*/
    }

    @RequestMapping(value= "/employee/update/{id}", method= RequestMethod.PUT)
    public Employee updateEmployee(@RequestBody Employee updemp, @PathVariable int id) throws Exception {
        System.out.println(this.getClass().getSimpleName() + " - Update employee details by id is invoked.");

        Optional<Employee> emp =  employeeService.getEmployeeById(id);
        if (!emp.isPresent())
            throw new Exception("Could not find employee with id- " + id);

        /* IMPORTANT - To prevent the overiding of the existing value of the variables in the database,
         * if that variable is not coming in the @RequestBody annotation object. */
        if(updemp.getEmpName() == null || updemp.getEmpName().isEmpty())
            updemp.setEmpName(emp.get().getEmpName());
        if(updemp.getEmpEmail() == null || updemp.getEmpEmail().isEmpty())
            updemp.setEmpEmail(emp.get().getEmpEmail());
        if(updemp.getRole() == null)
            updemp.setRole(emp.get().getRole());

        // Required for the "where" clause in the sql query template.
        updemp.setEmpId(id);
        return employeeService.updateEmployee(updemp);
    }

    @RequestMapping(value= "/employee/delete/{id}", method= RequestMethod.DELETE)
    public void deleteEmployeeById(@PathVariable int id) throws Exception {
        System.out.println(this.getClass().getSimpleName() + " - Delete employee by id is invoked.");

        Optional<Employee> emp =  employeeService.getEmployeeById(id);
        if(!emp.isPresent())
            throw new Exception("Could not find employee with id- " + id);

        employeeService.deleteEmployeeById(id);
    }

    @RequestMapping(value= "/employee/deleteall", method= RequestMethod.DELETE)
    public void deleteAll() {
        System.out.println(this.getClass().getSimpleName() + " - Delete all employees is invoked.");
        employeeService.deleteAllEmployees();
    }
}
