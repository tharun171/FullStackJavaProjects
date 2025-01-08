package com.project.foodApp.Entities;


import java.util.Date;

import com.project.foodApp.Repositories.UserEntityId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@NamedQueries(value= {
		@NamedQuery(name="findPhoneNumberInDB",
				query="select c from UserEntity c where c.phoneNumber=:userPhonenumber")
})
@Entity
@Table(name="usersData")
//this @IdClass has been given because it has 2 primary keys
@IdClass(UserEntityId.class)
public class UserEntity {
	
	@Id
	@SequenceGenerator(name="mySeqGen",sequenceName ="mySeq",initialValue = 149865,allocationSize = 1)
	@GeneratedValue(generator = "mySeqGen",strategy=GenerationType.SEQUENCE)
	private int userId;
	
	@Column(name="Name",nullable = false)
	private String name;
	
	@Column(name="Email",nullable=false)
	private String email;
	
	@Id
	@Column(name="phoneNumber",nullable=false,unique = true)
	private Long phoneNumber;
	
	@Temporal(TemporalType.DATE)
	private Date joinedDate;
	
	
	public UserEntity()
	{
		System.out.println("inside user entity");
	}


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
		return "UserEntity [userId=" + userId + ", name=" + name + ", email=" + email + ", phonenumber=" + phoneNumber
				+ ", joinedDate=" + joinedDate + "]";
	}

}
