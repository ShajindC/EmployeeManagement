package com.sql.association.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sql.association.model.Project;
import com.sql.association.respository.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	ProjectRepository projectRepository;

	public List<Project> getAllProjects() {
		return projectRepository.findAll();
	}

	public String deleteProject(Long id) {
		projectRepository.deleteById(id);
		return "Deleted Project successfully";
	}

}
