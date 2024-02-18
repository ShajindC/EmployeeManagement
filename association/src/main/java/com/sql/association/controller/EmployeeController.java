package com.sql.association.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sql.association.model.Employee;
import com.sql.association.model.EmployeeIdentification;
import com.sql.association.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	@PostMapping("/add_employee")
	public String addEmployee(@RequestBody Employee emp) {
		return empService.addEmployee(emp);
	}
	
	@PostMapping("/add_bulk_employees")
	public String addBulkEmployee(@RequestBody List<Employee> emp) {
		return empService.addBulkEmployee(emp);
	}
	
	@GetMapping("/view_employees")
	public List<Employee> viewEmployees(){
		return empService.viewEmployees();
	}
	
	@GetMapping("/view_employee/{id}")
	public Employee viewEmployeeById(@PathVariable Long id) {
		return empService.viewEmployeeById(id).get();
	}
	
	@DeleteMapping("/delete_employee")
	public String deleteemployeeById(@RequestParam Long id) {
		return empService.deleteEmployee(id);	
	}
	
	@PutMapping("/update_employee/{id}")
	public Employee updateEmployee(@PathVariable Long id,@RequestBody Map<String,Object> e) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		return empService.updateEmpDetails(id,e);
	}
	
	@GetMapping("/employee/identification/{id}")
	public EmployeeIdentification getIdentificationOfEmployees(@PathVariable Long id) {
		return empService.getIdentification(id);
	}
}
