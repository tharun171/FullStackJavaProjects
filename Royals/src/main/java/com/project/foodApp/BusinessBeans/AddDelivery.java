package com.project.foodApp.BusinessBeans;

public class AddDelivery {

	private String doorNo;
	
	private String street;
	
	private String city;
	
	private String pincode;

	/**
	 * @return the doorNo
	 */
	public String getDoorNo() {
		return doorNo;
	}

	/**
	 * @param doorNo the doorNo to set
	 */
	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	

	/**
	 * @return the pincode
	 */
	public String getPincode() {
		return pincode;
	}

	/**
	 * @param pincode the pincode to set
	 */
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "AddDelivery [doorNo=" + doorNo + ", street=" + street + ", city=" + city + ", pincode=" + pincode + "]";
	}

	
	
}
