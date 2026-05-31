package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.RecipeBean;

public class RecommendRecipeDAO {
	// 食材からレシピ一覧
    public List<RecipeBean> selectIngredients(List<String> foodList)
            throws ClassNotFoundException, SQLException {

        List<RecipeBean> recipeList = new ArrayList<>();

        String sql =
            "SELECT * FROM recipe WHERE ingredient = ?";

        try(Connection con = ConnectionManager.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, foodList.get(0));

            ResultSet res = pstmt.executeQuery();

            while(res.next()) {

                RecipeBean recipe = new RecipeBean();

                recipe.setRecipeId(res.getInt("recipeid"));
                recipe.setRecipeName(res.getString("recipename"));
                recipe.setRecipeImg(res.getString("recipeimage"));

                recipeList.add(recipe);
            }
        }

        return recipeList;
    }
}
 

//    // レシピ詳細取得
//    public RecipeBean selectRecipeid(int recipeid)
//            throws ClassNotFoundException, SQLException {
//
//        RecipeBean recipe = null;
//
//        String sql =
//            "SELECT * FROM recipe WHERE recipe_id = ?";
//
//        try(Connection con = ConnectionManager.getConnection();
//            PreparedStatement pstmt = con.prepareStatement(sql)) {
//
//            pstmt.setInt(1, recipeid);
//
//            ResultSet res = pstmt.executeQuery();
//
//            if(res.next()) {
//
//                recipe = new RecipeBean();
//
//                recipe.setRecipeId(res.getInt("recipeid"));
//                recipe.setRecipeName(res.getString("recipename"));
//                recipe.setRecipeImg(res.getString("recipeimage"));
//            }
//        }
//
//        return recipe;
//    }
//}

