package model.entity;

import java.io.Serializable;

public class FoodLostBean implements Serializable {
	private int FoodLostId;
	private String FoodLostName;
	private byte[] FoodLostImage;
	private String base64Image;
	
	public FoodLostBean() {
		
	}

	public int getFoodLostId() {
		return FoodLostId;
	}

	public void setFoodLostId(int foodLostId) {
		FoodLostId = foodLostId;
	}

	public String getFoodLostName() {
		return FoodLostName;
	}

	public void setFoodLostName(String foodLostName) {
		FoodLostName = foodLostName;
	}

	
	public byte[] getFoodLostImage() {
		return FoodLostImage;
	}

	public void setFoodLostImage(byte[] foodLostImage) {
		FoodLostImage = foodLostImage;
	}

	public String getBase64Image() {
	    return base64Image;
	}

	public void setBase64Image(String base64Image) {
	    this.base64Image = base64Image;
	}
	
}
	
	