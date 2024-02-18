package com.sql.association.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeIdentification {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long identificationId;
	private String IdentificationType;
	private Long identificationNo;
	
	@OneToOne(mappedBy = "identification")
	private Employee employee;
}
