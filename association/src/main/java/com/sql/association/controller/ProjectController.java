package com.sql.association.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sql.association.model.Project;
import com.sql.association.service.ProjectService;

@RestController
@RequestMapping("/api")
public class ProjectController {
	
	@Autowired
	ProjectService projectService;

	@GetMapping("view_projects")
	public List<Project> getAllProjects(){
		return projectService.getAllProjects();
	}
	
	@DeleteMapping("/delete_project")
	public String deleteProject(@RequestParam Long id) {
		return projectService.deleteProject(id);
	}
}
