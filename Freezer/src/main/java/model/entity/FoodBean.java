package model.entity;

import java.io.Serializable;
import java.util.Date;

public class FoodBean implements Serializable{
	
	/**
	 * 食材ID
	 */
	private int FoodId;
	
	/**
	 * 食材名
	 */
	private String FoodName;
	
	/**
	 * 画像
	 */
	private String foodImage;
	
	/**
	 * 食材の消費期限
	 */
	private Date FoodLostDay;
	
	/**
	 * 食材の量
	 */
	private int FoodQuantity;
	
	/**
	 * 消費期限マーカー
	 */
	private String MarkColor;
	
    /**
	 * FoodBeanを構築します。
	 */
	public FoodBean() {

	}
			
	
	/**
	 * フィールドFoodIdの値を返します。
	 * @return 食材ID
	 */
	public int getFoodId() {
		return FoodId;
	}
	
	/**
	 * フィールドFoodIdの値を設定します。
	 * @param FoodId 食材ID
	 */
	public void setFoodId(int FoodId) {
		this.FoodId = FoodId;
	}
	
	/**
	 * フィールドFoodNameの値を返します。
	 * @return 食材名
	 */
	public String getFoodName() {
		return FoodName;
	}
	
	/**
	 * フィールドFoodNameの値を設定します。
	 * @param FoodName 食材名
	 */
	public void setFoodName(String FoodName) {
		this.FoodName = FoodName;
	}
	
	/**
	 * フィールドFoodImageの値を返します。
	 * @return 画像
	 */
	public String getFoodImage() {
	    return foodImage;
	}
	
	/**
	 * フィールドFoodImageの値を設定します。
	 * @param FoodImage 画像
	 */
	public void setFoodImage(String foodImage) {
	   
	    this.foodImage = foodImage; 
	}
	/**
	 * フィールドFoodLostDayの値を返します。
	 * @return 食材の消費期限
	 */
	public Date getFoodLostDay() {
		return FoodLostDay;
	}
	
	/**
	 * フィールドFoodLostDayの値を設定します。
	 * @param FoodLostDay 食材の消費期限
	 */
	public void setFoodLostDay(Date FoodLostDay) {
		this.FoodLostDay = FoodLostDay;
	}
	
	/**
	 * フィールドFoodQuantityの値を返します。
	 * @return 食材の量
	 */
	public int getFoodQuantity() {
		return FoodQuantity;
	}
	
	/**
	 * フィールドFoodQuantityの値を設定します。
	 * @param FoodQuantity 食材の量
	 */
	public void setFoodQuantity(int FoodQuantity) {
		this.FoodQuantity = FoodQuantity;
	}
	
	/**
	 * フィールドMarkColorの値を返します。
	 * @return 消費期限マーカー
	 */
	public String getMarkColor() {
		return MarkColor;
	}
	
	/**
	 * フィールドFoodQuantityの値を設定します。
	 * @param FoodQuantity 消費期限マーカー
	 */
	public void setMarkColor(String MarkColor) {
		this.MarkColor = MarkColor;
	}

}