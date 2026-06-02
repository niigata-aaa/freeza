package model.entity;

import java.io.Serializable;

public class FoodLostBean implements Serializable {
	private int FoodLostId;
	private String FoodLostName;
	private String FoodLostImage;
	
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

	public String getFoodLostImage() {
		return FoodLostImage;
	}

	public void setFoodLostImage(String foodLostImage) {
		FoodLostImage = foodLostImage;
	}

	
	
	
}
	
	