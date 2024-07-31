package com.tharun.Exceptions;

public class NoEmployeeExistException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public NoEmployeeExistException(String message)
	{
		super(message);
	}

}
