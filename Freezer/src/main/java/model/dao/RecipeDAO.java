package dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.dao.RecipeBean;

public class RecipeDAO {
	public List<RecipeBean> selectAll()
			throws SQLException, ClassNotFoundException {

		List<RecipeBean> recipeList = new ArrayList<RecipeBean>();

		// データベースへの接続の取得、Statementの取得、SQLステートメントの実行
		try (Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();
				ResultSet res = stmt.executeQuery("SELECT * FROM ???")) {

			// 結果の操作
			while (res.next()) {
				int recipeid = res.getInt("recipe_id");
				String recipename = res.getString("recipe_name");
				Blob recipeimg = res.getBlob("recipe_img");
				String recipeimgredients = res.getString("recipe_ingredients");
				String recipehowto = res.getString("recipe_howto");
				int recipeservings = res.getInt("recipe_servings");
				Date posting = res.getDate("posting_datetime");
				Date update = res.getDate("update_^datetime");

				RecipeBean recipe = new RecipeBean();
				recipe.setRecipeId(recipeid);
				recipe.setRecipeName(recipename);
				recipe.setRecipeImage(recipeimg);
				recipe.setRecipeIngredients(recipeimgredients);
				recipe.setRecipeHowto(recipehowto);
				recipe.setRecipeServings(recipeservings);
				recipe.setPostingDatetime(posting);
				recipe.setUpdateDatetime(update);

				recipeList.add(recipe);
			}
		}
		return recipeList;
	}

}
