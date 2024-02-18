package com.sql.association.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sql.association.model.Employee;
import com.sql.association.model.Training;
import com.sql.association.respository.TrainingRepository;

@Service
public class TrainingService {
	
	@Autowired
	TrainingRepository trainingRepository;

	public List<Training> addTraining(List<Training> data) {
		List<Training> data1 = trainingRepository.saveAll(data);
		return data1;
	}

	public List<Employee> getEmployeeForTraining(Long trainingId) {
		Optional<Training> training = trainingRepository.findById(trainingId);
		if(training.get()!=null) {
			return training.get().getEmployeeRegistered();
		}
		else {
			return List.of();
		}
	}

}
