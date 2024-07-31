package com.tharun.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

//We use this class to transfer data between client and server
//BEAN Class
public class EmployeeDto {

	private Long empId;
	private String firstName;
	private String lastName;
	private String email;
}
