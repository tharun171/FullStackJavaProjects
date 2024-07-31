package com.tharun.SpringAop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
//To work need to add Dependency = spring-boot-starter-aop
public class LoggingAspect {

	private static final Logger log = 
			LoggerFactory.getLogger(LoggingAspect.class);
	
	//Print this line Before executing all methods in com.tharun and its sub-packages
	 @Before("execution(* com.tharun..*(..))")
	//Using JoinPoint to get values like method name
	public void forAllMethodsInComTharunPackage(JoinPoint jp)
	{
		//log.info("Log --> inside method: "+jp.getSignature().getName());
		 
		// Retrieve fully Qualified class name
		 String className = jp.getSignature().getDeclaringTypeName();
		// Retrieve the Package name
		 String packageName = className.substring(0,className.lastIndexOf('.'));
		// Retrieve Method name
		 String methodName = jp.getSignature().getName();
		 
		// Log the information
	    log.info("\nLog --> Package: {}, Class: {}, Method: {}", packageName, className, methodName);
	    
	}
}
