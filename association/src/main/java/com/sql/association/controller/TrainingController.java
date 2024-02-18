package com.sql.association.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sql.association.model.Employee;
import com.sql.association.model.Training;
import com.sql.association.service.TrainingService;

@RestController
@RequestMapping("/api")
public class TrainingController {
	
	@Autowired
	TrainingService trainingService;
	
	@PostMapping("/add_taining")
	public ResponseEntity<List<Training>> addTrainingData(@RequestBody List<Training> trainingData){
		return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(trainingService.addTraining(trainingData));
	}
	
	@GetMapping("/get_training_employees/{trainingId}")
	public List<Employee> getEmployeeForTraining(@PathVariable Long trainingId){
		return trainingService.getEmployeeForTraining(trainingId);
	}

}
