package com.tharun.Mappers;

import com.tharun.DTO.EmployeeDto;
import com.tharun.Entities.EmployeeEntity;

public class EmployeeMapper {

	// EmployeeEntity to EmployeeDto
	public static EmployeeDto mapToEmployeeDto(EmployeeEntity empEntity)
	{
		if (empEntity == null) 
            return null;
		else
		{
		return new EmployeeDto(
				empEntity.getEmpId(),
				empEntity.getFirstName(),
				empEntity.getLastName(),
				empEntity.getEmail());}
	}
	
	//EmployeeDto to EmployeeEntity
	public static EmployeeEntity mapToEmployeeEntity(EmployeeDto empDto)
	{
		return new EmployeeEntity(
				empDto.getEmpId(),
				empDto.getFirstName(),
				empDto.getLastName(),
				empDto.getEmail());	
	}
}
