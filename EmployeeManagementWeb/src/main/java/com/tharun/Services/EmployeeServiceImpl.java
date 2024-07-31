package com.tharun.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tharun.DTO.EmployeeDto;
import com.tharun.Entities.EmployeeEntity;
import com.tharun.Exceptions.EmployeeNotFoundException;
import com.tharun.Exceptions.NoEmployeeExistException;
import com.tharun.Mappers.EmployeeMapper;
import com.tharun.Repositories.EmployeeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository empRepo;


	@Override
	public EmployeeDto createEmployee(EmployeeDto empDto) {
		//converting DTO into Entity
		//Below method is a static method - directly accessed using class.
		EmployeeEntity empEntityToSave = EmployeeMapper.mapToEmployeeEntity(empDto);
		EmployeeEntity savedEntity = empRepo.save(empEntityToSave);
		//Converting entity into DTO(Bean)
		EmployeeDto savedEmpDto = EmployeeMapper.mapToEmployeeDto(savedEntity);
		return savedEmpDto;
	}

	@Override
	public EmployeeDto getEmployeeById(Long empId) throws EmployeeNotFoundException{
		
		return EmployeeMapper.mapToEmployeeDto
				(
						empRepo.findById(empId).orElseThrow
						(
								() -> new EmployeeNotFoundException("Employee is not found with id "+empId)
						)
				);
	}

	@Override
	public List<EmployeeDto> getAllEmployee() throws NoEmployeeExistException {
		List<EmployeeEntity> empEntityList = empRepo.findAll();
		//Convert entity to EmployeeDto - Using Stream
		List<EmployeeDto> empList = empEntityList.stream()
		//.map(EmployeeMapper::mapToEmployeeDto)
		.map(ele -> EmployeeMapper.mapToEmployeeDto(ele))
		.collect(Collectors.toList());
		return empList;
	}

	@Override
	public EmployeeDto updateEmployee(Long empId, EmployeeDto updatedEmp) throws EmployeeNotFoundException {
		
		EmployeeEntity empEntity = empRepo.findById(empId).orElseThrow(
				//Handled by global exception Handler
				//uses @ExceptionHandler(EmployeeNotFoundException.class)
				() -> new EmployeeNotFoundException("Employee is not found with id "+empId));
		
		empEntity.setFirstName(updatedEmp.getFirstName());
		empEntity.setLastName(updatedEmp.getLastName());
		empEntity.setEmail(updatedEmp.getEmail());
		
		EmployeeEntity savedEntity = empRepo.save(empEntity);
		return EmployeeMapper.mapToEmployeeDto(savedEntity);
	}

	@Override
	public String deleteEmployee(Long empId) throws NoEmployeeExistException {
		EmployeeEntity empEntity = empRepo.findById(empId).orElseThrow(
				() -> new NoEmployeeExistException("emp id doesnt exist with id "+empId));
		empRepo.delete(empEntity);
		return "deleted id with "+empId;
	}

}
