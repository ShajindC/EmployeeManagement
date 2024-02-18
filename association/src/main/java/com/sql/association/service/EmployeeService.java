package com.sql.association.service;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sql.association.model.Employee;
import com.sql.association.model.EmployeeIdentification;
import com.sql.association.respository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository empRepository;

	public String addEmployee(Employee emp) {
		empRepository.save(emp);
		return "Data saved successfully";
	}

	public String addBulkEmployee(List<Employee> emp) {
		empRepository.saveAll(emp);
		return "Data saved successfully";
	}

	public List<Employee> viewEmployees() {
		return empRepository.findAll();
	}

	public Optional<Employee> viewEmployeeById(Long id) {
		return empRepository.findById(id);
	}

	public String deleteEmployee(Long id) {
		empRepository.deleteById(id);
		return "Deleted the record!";
	}

	/*
	 * This methods only accepts the fields that needs to be modified in a particular ID. 
	 * Note: Object is converted to Map and then fields get updated and then converts back Map to Object
	 * */
	public Employee updateEmpDetails(Long id, Map<String, Object> e)
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Employee record = this.viewEmployeeById(id).get();
		Map<String, Object> map = new HashMap<>();

		for (Field field : record.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			map.put(field.getName(), field.get(record));
		}
		for (Map.Entry<String, Object> entry : e.entrySet()) {
			map.put(entry.getKey(), entry.getValue());
		}
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			Field field = Employee.class.getDeclaredField(entry.getKey());
			field.setAccessible(true);
			field.set(record, entry.getValue());
		}

		return empRepository.save(record);
	}

	public EmployeeIdentification getIdentification(Long id) {
		Employee record = this.viewEmployeeById(id).get();
		return record.getIdentification();
	}

}
