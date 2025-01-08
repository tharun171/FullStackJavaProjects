package com.project.foodApp.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserEntityCart {
	
	@Id
	private int userId;
	
	private int itemsInCart;
	
	private String itemsSelected;
	
	private String address;
	
	private String alladdress;

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
	 * @return the itemsInCart
	 */
	public int getItemsInCart() {
		return itemsInCart;
	}

	/**
	 * @param itemsInCart the itemsInCart to set
	 */
	public void setItemsInCart(int itemsInCart) {
		this.itemsInCart = itemsInCart;
	}

	/**
	 * @return the itemsSelected
	 */
	public String getItemsSelected() {
		return itemsSelected;
	}

	/**
	 * @param itemsSelected the itemsSelected to set
	 */
	public void setItemsSelected(String itemsSelected) {
		this.itemsSelected = itemsSelected;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the alladdress
	 */
	public String getAlladdress() {
		return alladdress;
	}

	/**
	 * @param alladdress the alladdress to set
	 */
	public void setAlladdress(String alladdress) {
		this.alladdress = alladdress;
	}

	@Override
	public String toString() {
		return "UserEntityCart [userId=" + userId + ", itemsInCart=" + itemsInCart + ", itemsSelected=" + itemsSelected
				+ ", address=" + address + ", alladdress=" + alladdress + "]";
	}

	

	
	

}
