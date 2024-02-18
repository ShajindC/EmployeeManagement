package com.sql.association.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Training {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long trainingId;
	private String courseName;
	@JsonIgnore
	@ManyToMany(mappedBy = "trainings")
	private List<Employee> employeeRegistered;
}
