package com.tharun.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employees")
public class EmployeeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "empIdSeqGenerator")
	@SequenceGenerator(name = "empIdSeqGenerator",initialValue = 12559621,allocationSize = 1)
	private Long empId;
	@Column(name="first_name")
	//eitherWays camelCase gives _ by default
	//but we gave it explicitly
	private String firstName;
	private String lastName;
	@Column(name="email_id",nullable = false)
	//should not take null values
	private String email;

}
