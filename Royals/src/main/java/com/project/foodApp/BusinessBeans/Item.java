package com.project.foodApp.BusinessBeans;

import java.io.Serializable;

public class Item implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int foodId;
	private String food;
	private String foodType;
	private String title;
	private Integer price;
	private double rating;
	private int noOfPeopleOrdered;
	private String image;
	private String alternateImageName;
	private String itemDetails;
	private String customisable;

	
	public Item(int foodId, String food, String foodType, String title, int price, double rating, int noOfPeopleOrdered,
			String image, String alternateImageName, String itemDetails, String customisable) {
		super();
		this.foodId = foodId;
		this.food = food;
		this.foodType = foodType;
		this.title = title;
		this.price = price;
		this.rating = rating;
		this.noOfPeopleOrdered = noOfPeopleOrdered;
		this.image = image;
		this.alternateImageName = alternateImageName;
		this.itemDetails = itemDetails;
		this.customisable = customisable;
	}
	/**
	 * @return the foodType
	 */
	public String getFoodType() {
		return foodType;
	}
	/**
	 * @param foodType the foodType to set
	 */
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the price
	 */
	public Integer getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(Integer price) {
		this.price = price;
	}
	/**
	 * @return the rating
	 */
	public double getRating() {
		return rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(double rating) {
		this.rating = rating;
	}
	/**
	 * @return the noOfPeopleOrdered
	 */
	public int getNoOfPeopleOrdered() {
		return noOfPeopleOrdered;
	}
	/**
	 * @param noOfPeopleOrdered the noOfPeopleOrdered to set
	 */
	public void setNoOfPeopleOrdered(int noOfPeopleOrdered) {
		this.noOfPeopleOrdered = noOfPeopleOrdered;
	}
	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}
	/**
	 * @return the alternateImageName
	 */
	public String getAlternateImageName() {
		return alternateImageName;
	}
	/**
	 * @param alternateImageName the alternateImageName to set
	 */
	public void setAlternateImageName(String alternateImageName) {
		this.alternateImageName = alternateImageName;
	}
	/**
	 * @return the customisable
	 */
	public String getCustomisable() {
		return customisable;
	}
	/**
	 * @param customisable the customisable to set
	 */
	public void setCustomisable(String customisable) {
		this.customisable = customisable;
	}
	/**
	 * @return the itemDetails
	 */
	public String getItemDetails() {
		return itemDetails;
	}
	/**
	 * @param itemDetails the itemDetails to set
	 */
	public void setItemDetails(String itemDetails) {
		this.itemDetails = itemDetails;
	}
	
	
	/**
	 * @return the food
	 */
	public String getFood() {
		return food;
	}
	/**
	 * @param food the food to set
	 */
	public void setFood(String food) {
		this.food = food;
	}
	
	
	/**
	 * @return the foodId
	 */
	public int getFoodId() {
		return foodId;
	}
	/**
	 * @param foodId the foodId to set
	 */
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	@Override
	public String toString() {
		return "\nItem [foodId=" + foodId + ", food=" + food + ", foodType=" + foodType + ", title=" + title + ", price="
				+ price + ", rating=" + rating + ", noOfPeopleOrdered=" + noOfPeopleOrdered + ", image=" + image
				+ ", alternateImageName=" + alternateImageName + ", itemDetails=" + itemDetails + ", customisable="
				+ customisable + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
