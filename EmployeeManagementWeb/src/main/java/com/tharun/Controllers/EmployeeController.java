package com.tharun.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tharun.DTO.EmployeeDto;
import com.tharun.Exceptions.EmployeeNotFoundException;
import com.tharun.Exceptions.NoEmployeeExistException;
import com.tharun.Services.EmployeeService;

import lombok.AllArgsConstructor;

@RestController
//Parent root
@RequestMapping("/api/employees")
//for fields
@AllArgsConstructor
//Allowing cross-origin retrieval
//* = to allow all api's inside controller
@CrossOrigin("*")
public class EmployeeController {
	
	//private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private EmployeeService empService;
	
	//Create Employee
	@PostMapping()
	//EmployeeDto is a bean class, nothing much
	public ResponseEntity<EmployeeDto> createEmployee(
			//Asking employeeDto in JSON or other
			@RequestBody EmployeeDto empDto)
	{
		EmployeeDto savedEmployeeDetails = empService.createEmployee(empDto);
		return new ResponseEntity<EmployeeDto>(savedEmployeeDetails,HttpStatus.CREATED);
	}
	
	//Read EmpId
	@GetMapping("/{empId}")
	public ResponseEntity<EmployeeDto> getEmployeeById(
			@PathVariable("empId") Long id) throws EmployeeNotFoundException
	{
	        EmployeeDto empDto = empService.getEmployeeById(id);
	        return ResponseEntity.ok(empDto);
	}
	
	//Get All
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAllEmployee() throws NoEmployeeExistException
	{
		List<EmployeeDto> list = empService.getAllEmployee();
		System.out.println("get All Employee -- "+list);
		//return new ResponseEntity<List<EmployeeDto>>(list,HttpStatus.OK);
		return ResponseEntity.ok(list);
	}
	
	//Update Employee
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(
			@PathVariable("id") Long empId,
			@RequestBody EmployeeDto updateEmployeeDetails) throws EmployeeNotFoundException
	{
		EmployeeDto empDto =  empService.updateEmployee(
				empId,updateEmployeeDetails);
		return ResponseEntity.ok(empDto);
	}
	
	//Delete Employee
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(
			@PathVariable("id") Long empId) throws NoEmployeeExistException
	{
		return new ResponseEntity<String>(
				empService.deleteEmployee(empId),HttpStatus.OK);
	}
	

}
