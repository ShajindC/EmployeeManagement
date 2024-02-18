package com.sql.association.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sql.association.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
