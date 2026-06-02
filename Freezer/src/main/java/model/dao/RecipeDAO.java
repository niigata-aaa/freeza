package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entity.RecipeBean;

public class RecipeDAO {
	
	
	
	//①一覧表示
	public List<RecipeBean> selectAll()
			throws SQLException, ClassNotFoundException {

		List<RecipeBean> recipeList = new ArrayList<RecipeBean>();

		// データベースへの接続の取得、Statementの取得、SQLステートメントの実行
		try (Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();
				ResultSet res = stmt.executeQuery("SELECT * FROM t_recipe")) {

			// 結果の操作
			while (res.next()) {
				int RecipeId = res.getInt("recipe_id");
				String RecipeName = res.getString("recipe_name");
//				Blob RecipeImg = res.getBlob("recipe_img");
				String RecipeIngredients = res.getString("recipe_ingredients");
				String RecipeHowto = res.getString("recipe_howto");
				int RecipeServings = res.getInt("recipe_servings");
				Date PostingDatetime = res.getDate("posting_dateTime");
				Date UpdateDatetime = res.getDate("update_datetime");

				RecipeBean recipe = new RecipeBean();
				recipe.setRecipeId(RecipeId);
				recipe.setRecipeName(RecipeName);
//				recipe.setRecipeImg(RecipeImg);
				recipe.setRecipeIngredients(RecipeIngredients);
				recipe.setRecipeHowto(RecipeHowto);
				recipe.setRecipeServings(RecipeServings);
				recipe.setPostingDatetime(PostingDatetime);
				recipe.setUpdateDatetime(UpdateDatetime);

				recipeList.add(recipe);
			}
		}
		return recipeList;
	}
	
	
	//②詳細表示
	public RecipeBean select(String RecipeId2)throws SQLException, ClassNotFoundException{

		RecipeBean recipe = new RecipeBean();

		String sql = "SELECT * FROM t_recipe WHERE recipe_id = ?";

		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){

			pstmt.setString(1, RecipeId2);

			ResultSet res = pstmt.executeQuery();

			while(res.next()) {
				int RecipeId = res.getInt("recipe_id");
				String RecipeName = res.getString("recipe_name");
//				Blob RecipeImg = res.getBlob("recipe_img");
				String RecipeIngredients = res.getString("recipe_ingredients");
				String RecipeHowto = res.getString("recipe_howto");
				int RecipeServings = res.getInt("recipe_servings");
				Date PostingDatetime = res.getDate("posting_dateTime");
				Date UpdateDatetime = res.getDate("update_datetime");

				recipe.setRecipeId(RecipeId);
				recipe.setRecipeName(RecipeName);
//				recipe.setRecipeImg(RecipeImg);
				recipe.setRecipeIngredients(RecipeIngredients);
				recipe.setRecipeHowto(RecipeHowto);
				recipe.setRecipeServings(RecipeServings);
				recipe.setPostingDatetime(PostingDatetime);
				recipe.setUpdateDatetime(UpdateDatetime);

			}
		}
		return recipe;
	}
	
	
    //③レシピ登録
	public int insert(RecipeBean recipe) throws ClassNotFoundException, SQLException {

		String sql = "INSERT INTO t_recipe(recipe_name,recipe_ingredients,recipe_howto,recipe_servings,posting_dateTime,update_datetime) VALUES(?, ?, ?, ?, ?, ?)";

		int result = 0;

		// データベースへの接続の取得、PreparedStatementの取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
System.out.println(recipe.getPostingDatetime());			//			RecipeBean recipe = new RecipeBean();

			// プレースホルダへの値の設定
//			pstmt.setInt(1, recipe.getRecipeId());
			pstmt.setString(1, recipe.getRecipeName());
//			pstmt.setBlob(3, recipe.getRecipeImg());
			pstmt.setString(2, recipe.getRecipeIngredients());
			pstmt.setString(3, recipe.getRecipeHowto());
			pstmt.setInt(4, recipe.getRecipeServings());
			pstmt.setDate(5, recipe.getPostingDatetime());
			if (recipe.getPostingDatetime() != null) {
	            pstmt.setDate(5, recipe.getPostingDatetime());
	        } else {
	            // 現在時刻
	            long now = System.currentTimeMillis();
	            pstmt.setDate(5, new java.sql.Date(now));
	        }
			System.out.println(recipe.getUpdateDatetime());
			pstmt.setDate(6, recipe.getUpdateDatetime());
			if (recipe.getUpdateDatetime() != null) {
	            pstmt.setDate(5, recipe.getUpdateDatetime());
	        } else {
	            // 現在時刻
	            long now = System.currentTimeMillis();
	            pstmt.setDate(5, new java.sql.Date(now));
	        }

			result = pstmt.executeUpdate();
		}

		return result;
	}


//	public int insert(RecipeBean recipe) throws ClassNotFoundException, SQLException {
//
//		String sql = "INSERT INTO t_recipe(recipe_id, recipe_name,recipe_img, recipe_ingredients, recipe_howto,recipe_servings,posting_datetime, update_datetime) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
//
//		int result = 0;
//
//		// データベースへの接続の取得、PreparedStatementの取得
//		try (Connection con = ConnectionManager.getConnection();
//				PreparedStatement pstmt = con.prepareStatement(sql)) {
//
//			//			RecipeBean recipe = new RecipeBean();
//
//			// プレースホルダへの値の設定
//			pstmt.setInt(1, recipe.getRecipeId());
//			pstmt.setString(2, recipe.getRecipeName());
//			pstmt.setBlob(3, recipe.getRecipeImg());
//			pstmt.setString(4, recipe.getRecipeIngredients());
//			pstmt.setString(5, recipe.getRecipeHowto());
//			pstmt.setInt(6, recipe.getRecipeServings());
//			pstmt.setDate(7, recipe.getPostingDatetime());
//			pstmt.setDate(8, recipe.getUpdateDatetime());
//
//			// SQLステートメントの実行
//			result = pstmt.executeUpdate();
//		}
//
//		return result;
//	}

     //削除メソッド
//	public int delete(String[] RecipeId) throws SQLException, ClassNotFoundException {
//		String sql = "DELETE  FROM t_recipe WHERE recipe_id = ?";
//
//		int result = 0;
//
//		// データベースへの接続の取得、PreparedStatementの取得
//		try (Connection con = ConnectionManager.getConnection();
//				PreparedStatement pstmt = con.prepareStatement(sql);) {
//
//			pstmt.setString(1, RecipeId);
//
//			// SQLステートメントの実行
//			result = pstmt.executeUpdate();
//		}
//
//		return result;
//	}
//		public int delete(int RecipeId) throws ClassNotFoundException, SQLException {
//			int count = 0;
//
//			String sql = "DELETE FROM t_recipe WHERE recipe_id = ?"; 
//
//			try (Connection con = ConnectionManager.getConnection(); 
//					PreparedStatement pstmt = con.prepareStatement(sql)) {
//
//				pstmt.setInt(1, RecipeId);
//
//				count = pstmt.executeUpdate();
//			}
//			return count;
//		}

	
	//④レシピ削除
	public int recipedelete(String[] RecipeId) throws SQLException, ClassNotFoundException {
		if (RecipeId == null) {
			return 0;
		}
		// 選択されたidからIN句の条件を作成
		StringBuffer sb = new StringBuffer();
		for (String id : RecipeId) {
			sb.append(id);
			sb.append(",");
		}
		if (sb.length() > 0) {
			sb.delete(sb.length() - 1, sb.length());
		}
		String sql = "DELETE FROM t_recipe WHERE = recipe_id IN(" + sb.toString() + ")";
		int result = 0;
		// データベースへの接続の取得、PreparedStatementの取得
		try (Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();) {
			// SQLステートメントの実行
			result = stmt.executeUpdate(sql);
		}
		return result;
	}
	
	public int delete(String RecipeId) throws SQLException, ClassNotFoundException {
		String sql = "DELETE  FROM t_recipe WHERE recipe_id = ?";
		int result = 0;
		// データベースへの接続の取得、PreparedStatementの取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			
			 pstmt.setString(1, RecipeId);
			
			// SQLステートメントの実行
			result = pstmt.executeUpdate();
		}
		return result;
	}






	//⑤レシピ検索

	public List<RecipeBean> searchRecipe(RecipeBean recipe)
			throws SQLException, ClassNotFoundException {

		List<RecipeBean> recipeList = new ArrayList<>();

		String sql = "SELECT * FROM t_recipe WHERE (recipe_name LIKE ? OR recipe_ingredients LIKE ?)";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, "%" + recipe.getRecipeName() + "%");
			pstmt.setString(2, "%" + recipe.getRecipeName() + "%");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				RecipeBean rsRecipe = new RecipeBean();

				int RecipeId = rs.getInt("recipe_id");
				String RecipeName = rs.getString("recipe_name");
//				Blob RecipeImg = rs.getBlob("recipe_img");
				String RecipeIngredients = rs.getString("recipe_ingredients");
				String RecipeHowto = rs.getString("recipe_howto");
				int RecipeServings = rs.getInt("recipe_servings");
				Date PostingDatetime = rs.getDate("posting_dateTime");
//				Date UpdateDatetime = rs.getDate("update_datetime");

				rsRecipe.setRecipeId(RecipeId);
				rsRecipe.setRecipeName(RecipeName);
//				rsRecipe.setRecipeImg(RecipeImg);
				rsRecipe.setRecipeIngredients(RecipeIngredients);
				rsRecipe.setRecipeHowto(RecipeHowto);
				rsRecipe.setRecipeServings(RecipeServings);
				rsRecipe.setPostingDatetime(PostingDatetime);
//				rsRecipe.setUpdateDatetime(UpdateDatetime);

				recipeList.add(rsRecipe);
			}
		}

		return recipeList;

	}

	//	public ArrayList<RecipeBean> select(RecipeBean recipes) throws ClassNotFoundException, SQLException {
	//
	//		ArrayList<RecipeBean> rsrecipeList  = new ArrayList<RecipeBean>();
	//
	//		String sql = "SELECT  * from t_recipetable WHERE recipe_id like ? and recipe_name like ? and recipe_img like ? and recipe_ingredients like ? and recipe_howto like ? and recipe_servings like ? and posting_datetime like ? and update_datetime like ?";
	//
	//		// データベースへの接続の取得、PreparedStatementの取得
	//		try (Connection con = ConnectionManager.getConnection();
	//				PreparedStatement pstmt = con.prepareStatement(sql)) {
	//
	//			// プレースホルダへの値の設定
	//			RecipeBean rsrecipe = new RecipeBean();
	//			pstmt.setString(2, "%" + rsrecipe.getRecipeName() + "%");
	//			pstmt.setString(4, "%" + rsrecipe.getRecipeIngredients() + "%");
	//
	//			// SQLステートメントの実行
	//			ResultSet rs = pstmt.executeQuery();
	//
	//			// 結果の操作
	//			while (rs.next()) {
	//				int RecipeId = rs.getInt("recipe_id");
	//				String RecipeName = rs.getString("recipe_name");
	//				Blob RecipeImg = rs.getBlob("recipe_img");
	//				String RecipeIngredients = rs.getString("recipe_ingredients");
	//				String RecipeHowto = rs.getString("recipe_howto");
	//				int RecipeServings = rs.getInt("recipe_servings");
	//				Date PostingDatetime = rs.getDate("posting_datetime");
	//				Date UpdateDatetime = rs.getDate("update_datetime");
	//
	//				RecipeBean recipes1 = new RecipeBean();
	//				recipes1.setRecipeId(RecipeId);
	//				recipes1.setRecipeName(RecipeName);
	//				recipes1.setRecipeImg(RecipeImg);
	//				recipes1.setRecipeIngredients(RecipeIngredients);
	//				recipes1.setRecipeHowto(RecipeHowto);
	//				recipes1.setRecipeServings(RecipeServings);
	//				recipes1.setPostingDatetime(PostingDatetime);
	//				recipes1.setUpdateDatetime(UpdateDatetime);
	//
	//				rsrecipeList.add(recipes1);
	//			}
	//		}
	//		return rsrecipeList;
	//	}
}




