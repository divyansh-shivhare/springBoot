package com.persistent.pip.service;

import com.persistent.pip.model.Employee;

import java.util.List;
import java.util.Optional;

public interface Employeeservice {

	public List<Employee> getEmployees();
	public Optional<Employee> getEmployeeById(int empid);
	public Employee addNewEmployee(Employee emp);
	public Employee updateEmployee(Employee emp);
	public void deleteEmployeeById(int empid);
	public void deleteAllEmployees();
	//public Optional<Employee> findByEmailandid(Employee emp);
	public Optional<Employee>  finyByEmpIdAndEmpEmail( String empEmail);
}