package com.tharun;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
//To Enable SpringAop
@EnableAspectJAutoProxy
public class EmployeeManagementWebApplication {

	private static final Logger log = LoggerFactory.getLogger(EmployeeManagementWebApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementWebApplication.class, args);
	
	
		log.info("--> EmployeeManagement Web App Started...");
	
	
	}

}
