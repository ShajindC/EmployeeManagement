package com.sql.association.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sql.association.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{

}
