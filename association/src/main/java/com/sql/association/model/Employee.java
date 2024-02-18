package com.sql.association.model;

import java.util.List;

import com.sql.associationn.enums.Department;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long empId;
	
	private String name;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "identification_id", referencedColumnName = "identificationId")
	private EmployeeIdentification identification;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "project_id", referencedColumnName = "projectId")
	private Project project;
	
	@Enumerated(EnumType.STRING)
	private Department department;
	
	private String designation;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;
	
	private Long mobileNo;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Employee_Trainings", joinColumns = { @JoinColumn(name = "empId") }, inverseJoinColumns = {
			@JoinColumn(name = "trainingId") })
	private List<Training> trainings;
	
	private Long salary;

}
