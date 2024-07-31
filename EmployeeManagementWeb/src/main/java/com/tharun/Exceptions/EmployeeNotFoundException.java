package com.tharun.Exceptions;


public class EmployeeNotFoundException extends Exception{

	private static final long serialVersionUID = 6571841826970596848L;

	public EmployeeNotFoundException(String message)
	{
		super(message);
	}
}
