package model.entity;
/*
 * WebApp_ex0501
 * model.entity.EmployeeBean.java
 */
import java.io.Serializable;
import java.sql.Date;

/**
 * 従業員を表します。
 * m_employeeのDTOであり、Beanオブジェクトです。
 * @author emBex Education
 */
public class RecipeBean implements Serializable {
	/**
	 * レシピコード
	 */
	private int RecipeId;

	/**
	 * レシピ名
	 */
	private String RecipeName;

	/**
	 * レシピ画像
	 */
	
	private String RecipeImg;

	/**
	 * 材料
	 */
	private String RecipeIngredients;

	/**
	 * レシピ手順
	 */
	private String RecipeHowto;
	/**
	 * 何人前
	 */
	private int RecipeServings;
	/**
	 * 掲載日時
	 */
	private Date PostingDatetime;
	/**
	 * 更新日時
	 */
	private Date UpdateDatetime;
	
	/**
	 * EmployeeBeanを構築します。
	 */
	public RecipeBean() {

	}
	/**
	 * フィールドrecipeIdの値を返します。
	 * @return レシピID
	 */
	public int getRecipeId() {
		return RecipeId;
		
	}
	/**
	 * フィールドrecipeIdの値を設定します。
	 * @param レシピID
	 */
	public void setRecipeId(int RecipeId) {
		this.RecipeId = RecipeId;
	}
	/**
	 * フィールドrecipeNameの値を返します。
	 * @return レシピ名
	 */
	public String getRecipeName(){
		return RecipeName;
	}

	/**
	 * フィールドrecipeNameの値を設定します。
	 * @param レシピ名
	 */
	public void setRecipeName(String RecipeName) {
		this.RecipeName = RecipeName;
	}

	/**
	 * フィールドrecipeImgの値を返します。
	 * @return 画像
	 */
	public String getRecipeImg() {
		return RecipeImg;
	}

	/**
	 * フィールドrecipeImgの値を設定します。
	 * @param 画像
	 */
	public void setRecipeImg(String RecipeImg) {
		this.RecipeImg = RecipeImg;
	}

	/**
	 * フィールドrecipeIngredientsの値を返します。
	 * @return 材料
	 */
	public String getRecipeIngredients() {
		return RecipeIngredients;
	}

	/**
	 * フィールドrecipeIngredientsの値を設定します。
	 * @param recipeIngredients 材料
	 */
	public void setRecipeIngredients(String RecipeIngredients) {
		this.RecipeIngredients = RecipeIngredients;
	}

	/**
	 * フィールドrecipeHowtoの値を返します。
	 * @return 手順
	 */
	public String getRecipeHowto() {
		return RecipeHowto;
	}

	/**
	 * フィールドrecipeHowtoの値を設定します。
	 * @param recipeHowto 手順
	 */
	public void setRecipeHowto(String RecipeHowto) {
		this.RecipeHowto = RecipeHowto;
	}


/**
 * フィールドrecipeHowtoの値を返します。
 * @return 何人前
 */
public int getRecipeServings() {
	return RecipeServings;
}

/**
 * フィールドrecipeHowtoの値を設定します。
 * @param recipeHowto 何人前
 */
public void setRecipeServings(int RecipeServings) {
	this.RecipeServings = RecipeServings;
}


/**
 * フィールドpostingDatetimeの値を返します。
 * @return 掲載日時
 */
public Date getPostingDatetime() {
	return PostingDatetime;
}

/**
 * フィールドpostingDatetimeの値を設定します。
 * @param postingDatetime 掲載日時
 */
public void setPostingDatetime(Date PostingDatetime) {
	this.PostingDatetime = PostingDatetime;
}

/**
 * フィールドrecipeHowtoの値を返します。
 * @return 何人前
 */
public Date getUpdateDatetime() {
	return UpdateDatetime;
}

/**
 * フィールドrecipeHowtoの値を設定します。
 * @param recipeHowto 何人前
 */
public void setUpdateDatetime(Date UpdateDatetime) {
	this.UpdateDatetime = UpdateDatetime;
}
}