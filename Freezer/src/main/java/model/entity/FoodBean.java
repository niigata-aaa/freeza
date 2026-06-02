package model.entity;

import java.io.Serializable;
import java.sql.Date;

public class FoodBean implements Serializable{
	private int FoodInt;
	private int FoodId;
	private String FoodName;
	private byte[] FoodImage;
	private String base64Image;
	private Date FoodLostDay;
	private int FoodQuantity;
	private String markColor;

	private int DaysLeft;
	
	public FoodBean() {
		
	}
	
	public int getFoodInt() {
		return FoodInt;
	}
	public void setFoodInt(int foodInt) {
		FoodInt = foodInt;
	}
	
	public int getFoodId() {
		return FoodId;
	}
	public void setFoodId(int foodId) {
		FoodId = foodId;
	}
	public String getFoodName() {
		return FoodName;
	}
	public void setFoodName(String foodName) {
		FoodName = foodName;
	}
	
	public byte[] getFoodImage() {
		return FoodImage;
	}

	public void setFoodImage(byte[] foodImage) {
		FoodImage = foodImage;
	}

	public Date getFoodLostDay() {
		return FoodLostDay;
	}
	public void setFoodLostDay(Date foodLostDay) {
		FoodLostDay = foodLostDay;
	}
	public int getFoodQuantity() {
		return FoodQuantity;
	}
	public void setFoodQuantity(int foodQuantity) {
		FoodQuantity = foodQuantity;
	}
	public String getMarkColor() {
		return markColor;
	}
	public void setMarkColor(String markColor) {
		this.markColor = markColor;
	}
	public String getBase64Image() {
	    return base64Image;
	}

	public void setBase64Image(String base64Image) {
	    this.base64Image = base64Image;
	}

	public int getDaysLeft() {
		return DaysLeft;
	}

	public void setDaysLeft(int DaysLeft) {
		this.DaysLeft = DaysLeft;
	}

}


