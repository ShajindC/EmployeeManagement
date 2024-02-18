package com.sql.association.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sql.association.model.Training;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {

}
