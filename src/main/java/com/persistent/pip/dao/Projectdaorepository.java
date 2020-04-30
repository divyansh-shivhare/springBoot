package com.persistent.pip.dao;

import com.persistent.pip.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Projectdaorepository extends JpaRepository<Project, Integer> {
}
