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
    public List<RecipeBean> selectIngredients()
            throws ClassNotFoundException, SQLException {

    	 List<RecipeBean> list = new ArrayList<>();

         String sql = "SELECT recipe_name, recipe_img FROM t_recipe re "
         		+ "INNER JOIN t_food fo ON re.recipe_ingredients = fo.food_name like '%recipe_ingredient%'"
         		+ " WHERE food_lost_day >= CURDATE() AND food_lost_day < DATE_ADD(CURDATE(), INTERVAL 3 DAY)";

         try (Connection con = ConnectionManager.getConnection();
              PreparedStatement ps = con.prepareStatement(sql)) {
             // とりあえず1つ目だけ使う（今の構造に合わせる）
//             ps.setString(1, foodList.get(0));
        	 
        	 
             ResultSet rs = ps.executeQuery();

             while (rs.next()) {

                 RecipeBean bean = new RecipeBean();

//                 bean.setRecipeId(rs.getInt("recipe_id"));
                 bean.setRecipeName(rs.getString("recipe_name"));
                 bean.setRecipeImg(rs.getString("recipe_img"));

                 list.add(bean);
             }
         }

         return list;
    }

 

    // レシピ詳細取得
    public RecipeBean selectRecipeid(int recipeid)
            throws ClassNotFoundException, SQLException {

        RecipeBean recipe = null;

        String sql =
            "SELECT * FROM recipe WHERE recipe_id = ?";

        try(Connection con = ConnectionManager.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, recipeid);

            ResultSet res = pstmt.executeQuery();

            if(res.next()) {

                recipe = new RecipeBean();

                recipe.setRecipeId(res.getInt("recipeid"));
                recipe.setRecipeName(res.getString("recipename"));
                
        }

        return recipe;
    }
    }
}