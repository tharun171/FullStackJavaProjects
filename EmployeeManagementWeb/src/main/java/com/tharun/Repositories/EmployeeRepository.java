package com.tharun.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tharun.Entities.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long>{

	
}
