package com.persistent.pip.dao;

import com.persistent.pip.model.Employee;
//import com.sun.tools.javac.comp.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Employeedaorepository extends JpaRepository<Employee, Integer> {


    @Query("SELECT t FROM Employee t where  t.empEmail = ?1")
    public Optional<Employee> customFindBy(String email);

}