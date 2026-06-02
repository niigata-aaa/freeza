package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import model.entity.RecipeBean;

public class RecipePersonalDAO {
    
    // 1. 新規レシピ投稿（画像のバイナリ保存対応）
    public void insertRecipe(RecipeBean recipe) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO t_localrecipe (recipe_name, recipe_img, recipe_ingredients, recipe_howto, recipe_servings, posting_date_time, update_date_time) VALUES (?, ?, ?, ?, ?, NOW(), NOW())";
        
        try (Connection con = ConnectionManager.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            
            pstmt.setString(1, recipe.getRecipeName());
            pstmt.setBytes(2, recipe.getRecipeImg()); // byte[]データをBLOBへ保存
            pstmt.setString(3, recipe.getRecipeIngredients());
            pstmt.setString(4, recipe.getRecipeHowto());
            pstmt.setInt(5, recipe.getRecipeServings());
            pstmt.executeUpdate();
        }
    }
    
    // 2. すべてのレシピを取得（取得時に一括でBase64に自動変換）
    public List<RecipeBean> selectAll() throws SQLException, ClassNotFoundException {
        List<RecipeBean> recipeList = new ArrayList<>();
        String sql = "SELECT * FROM t_localrecipe";
        
        try (Connection con = ConnectionManager.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet res = pstmt.executeQuery()) {
            
            while (res.next()) {
                RecipeBean recipe = new RecipeBean();
                recipe.setRecipeId(res.getInt("recipe_id"));
                recipe.setRecipeName(res.getString("recipe_name"));
                recipe.setRecipeIngredients(res.getString("recipe_ingredients"));
                recipe.setRecipeServings(res.getInt("recipe_servings"));
                recipe.setUpdateDatetime(res.getDate("update_date_time"));
                
                // 画像バイナリを取得してBase64文字列に変換
                byte[] imgData = res.getBytes("recipe_img");
                recipe.setRecipeImg(imgData);
                if (imgData != null && imgData.length > 0) {
                    String base64Str = Base64.getEncoder().encodeToString(imgData);
                    recipe.setBase64Image(base64Str);
                }
                
                recipeList.add(recipe);
            }
        }
        return recipeList;
    }

    // 3. 詳細画面用の1件取得（ここでもBase64自動変換を適用）
    public RecipeBean select(int recipeId) throws SQLException, ClassNotFoundException {
        RecipeBean recipe = new RecipeBean();
        String sql = "SELECT * FROM t_localrecipe WHERE recipe_id = ?";
        
        try (Connection con = ConnectionManager.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, recipeId);
            
            try (ResultSet res = pstmt.executeQuery()) {
                while (res.next()) {
                    recipe.setRecipeId(res.getInt("recipe_id"));
                    recipe.setRecipeName(res.getString("recipe_name"));
                    recipe.setRecipeIngredients(res.getString("recipe_ingredients"));
                    recipe.setRecipeHowto(res.getString("recipe_howto"));
                    recipe.setRecipeServings(res.getInt("recipe_servings"));
                    recipe.setPostingDatetime(res.getDate("posting_date_time"));
                    recipe.setUpdateDatetime(res.getDate("update_date_time"));
                    
                    // 画像バイナリを取得してBase64文字列に変換
                    byte[] imgData = res.getBytes("recipe_img");
                    recipe.setRecipeImg(imgData);
                    if (imgData != null && imgData.length > 0) {
                        String base64Str = Base64.getEncoder().encodeToString(imgData);
                        recipe.setBase64Image(base64Str);
                    }
                }
            }
        }
        return recipe;
    }

    // 4. レシピ情報の更新
    public int recipeupdate(RecipeBean daoupdate) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE t_localrecipe SET recipe_name=?, recipe_ingredients=?, recipe_howto=?, recipe_servings=?, update_date_time=NOW() WHERE recipe_id=?";
        try (Connection con = ConnectionManager.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, daoupdate.getRecipeName());
            pstmt.setString(2, daoupdate.getRecipeIngredients());
            pstmt.setString(3, daoupdate.getRecipeHowto());
            pstmt.setInt(4, daoupdate.getRecipeServings());
            pstmt.setInt(5, daoupdate.getRecipeId());

            return pstmt.executeUpdate();
        }
    }
}