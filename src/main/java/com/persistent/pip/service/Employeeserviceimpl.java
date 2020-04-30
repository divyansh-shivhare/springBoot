package com.persistent.pip.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.persistent.pip.dao.Employeedaorepository;
import com.persistent.pip.model.Employee;
//import sun.management.snmp.jvmmib.EnumJvmMemPoolCollectThreshdSupport;

@Service
public class Employeeserviceimpl implements Employeeservice {

    @Autowired
    Employeedaorepository dao;

    @Override
    public List<Employee> getEmployees() {
        return dao.findAll();
    }
    @Override
    public Optional<Employee> getEmployeeById(int empid) {
        return dao.findById(empid);
    }
    @Override
    public Employee addNewEmployee(Employee emp) {
        return dao.save(emp);
    }
    @Override
    public Employee updateEmployee(Employee emp) {
        return dao.save(emp);
    }
    @Override
    public void deleteEmployeeById(int empid) {
        dao.deleteById(empid);
    }
    @Override
    public void deleteAllEmployees() {
        dao.deleteAll();
    }
    public Optional<Employee>  finyByEmpIdAndEmpEmail(String empEmail) {
       return dao.customFindBy( empEmail);
    }
}