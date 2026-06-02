package model.entity;

import java.io.Serializable;
import java.sql.Date;

public class RecipeBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private int recipeId;
    private String recipeName;
    private byte[] recipeImg;       // DB直通のバイナリデータ
    private String base64Image;     // JSP表示用のBase64文字列
    private String recipeIngredients;
    private String recipeHowto;
    private int recipeServings;
    private Date postingDatetime;
    private Date updateDatetime;

    public RecipeBean() {}

    // ゲッター・セッター
    public int getRecipeId() { return recipeId; }
    public void setRecipeId(int recipeId) { this.recipeId = recipeId; }
    public String getRecipeName() { return recipeName; }
    public void setRecipeName(String recipeName) { this.recipeName = recipeName; }
    public byte[] getRecipeImg() { return recipeImg; }
    public void setRecipeImg(byte[] recipeImg) { this.recipeImg = recipeImg; }
    public String getBase64Image() { return base64Image; }
    public void setBase64Image(String base64Image) { this.base64Image = base64Image; }
    public String getRecipeIngredients() { return recipeIngredients; }
    public void setRecipeIngredients(String recipeIngredients) { this.recipeIngredients = recipeIngredients; }
    public String getRecipeHowto() { return recipeHowto; }
    public void setRecipeHowto(String recipeHowto) { this.recipeHowto = recipeHowto; }
    public int getRecipeServings() { return recipeServings; }
    public void setRecipeServings(int recipeServings) { this.recipeServings = recipeServings; }
    public Date getPostingDatetime() { return postingDatetime; }
    public void setPostingDatetime(Date postingDatetime) { this.postingDatetime = postingDatetime; }
    public Date getUpdateDatetime() { return updateDatetime; }
    public void setUpdateDatetime(Date updateDatetime) { this.updateDatetime = updateDatetime; }
}