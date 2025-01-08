package com.project.foodApp.Repositories;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

//this class is created bcoz we have 2 primary keys and to use this 
//in the UserRepository class

//public is by default
public class UserEntityId  implements Serializable{

	private int userId;
	private Long phoneNumber;
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the phoneNumber
	 */
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	
}
