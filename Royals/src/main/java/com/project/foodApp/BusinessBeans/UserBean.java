package com.project.foodApp.BusinessBeans;

import java.io.Serializable;
import java.util.Date;

public class UserBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int userId;
	
	private String name;
	
	private String email;
	
	private Long phoneNumber;
	
	private Date joinedDate;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	@Override
	public String toString() {
		return "UserBean [userId=" + userId + ", name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", joinedDate=" + joinedDate + "]";
	}
	
	
}
