package com.tharun.Services;

import java.util.List;

import com.tharun.DTO.EmployeeDto;
import com.tharun.Exceptions.EmployeeNotFoundException;
import com.tharun.Exceptions.NoEmployeeExistException;

public interface EmployeeService {

	//Create
	EmployeeDto createEmployee(EmployeeDto empDto);
	//Read 
	EmployeeDto getEmployeeById(Long empId) throws EmployeeNotFoundException;
	//Get All
	List<EmployeeDto> getAllEmployee() throws NoEmployeeExistException;
	//Update
	EmployeeDto updateEmployee(Long empId,EmployeeDto updatedEmp) throws EmployeeNotFoundException;
	//Delete
	String deleteEmployee(Long empId) throws NoEmployeeExistException;
	
	
}
