package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entity.RecipeBean;

public class RecipePersonalDAO {
	
	/*
	 * 
	 * すべての個人レシピのリストを返します。
	 * @return 個人レシピ一覧のリスト
	 * @throws SQLException
	 */
	
public List<RecipeBean>selectAll() throws SQLException, ClassNotFoundException{
		
		List<RecipeBean> RecipeParsonalList = new ArrayList<RecipeBean>();
		//データベース接続
		try(Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();
				//LocalRecipeTableのテーブルをすべて参照する
				ResultSet res = stmt.executeQuery("SELECT * FROM t_localrecipe")){
			while(res.next()) {

			    RecipeBean recipebean = new RecipeBean();

			    recipebean.setRecipeId(res.getInt("recipe_id"));

			    recipebean.setRecipeName(res.getString("recipe_name"));

			    recipebean.setRecipeIngredients(res.getString("recipe_ingredients"));

			    recipebean.setRecipeHowto(res.getString("recipe_howto"));

			    recipebean.setRecipeServings(res.getInt("recipe_servings"));

			    recipebean.setPostingDatetime(res.getDate("posting_date_time"));

			    recipebean.setUpdateDatetime(res.getDate("update_date_time"));

			    RecipeParsonalList.add(recipebean);
			}
			return RecipeParsonalList;
		}
		
		
		//データベースの接続の取得、Statementの取得、SQLステートメントの実行
		
		
	}
/*
 * 指定されたレシピの内容を更新するメソッドです。
 * @param
 * @return
 * @throws SQLxception
 * @throws classNotFoundExcption
 */
public int recipeupdate(RecipeBean daoupdate) throws SQLException, ClassNotFoundException {

    int processingNumber = 0;

    String sql =
    		"UPDATE t_localrecipe SET recipe_name=?, recipe_ingredients=?, recipe_howto=?, recipe_servings=?, update_date_time=NOW() WHERE recipe_id=?";
    try (Connection con = ConnectionManager.getConnection();
         PreparedStatement pstmt = con.prepareStatement(sql)) {

        pstmt.setString(1, daoupdate.getRecipeName());
        pstmt.setString(2, daoupdate.getRecipeIngredients());
        pstmt.setString(3, daoupdate.getRecipeHowto());
        pstmt.setInt(4, daoupdate.getRecipeServings());
        pstmt.setInt(5, daoupdate.getRecipeId());

        processingNumber = pstmt.executeUpdate();
    }

    return processingNumber;
}

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
	String sql = "DELETE FROM t_localrecipe WHERE = recipe_id IN(" + sb.toString() + ")";
	int result = 0;
	// データベースへの接続の取得、PreparedStatementの取得
	try (Connection con = ConnectionManager.getConnection();
			Statement stmt = con.createStatement();) {
		// SQLステートメントの実行
		result = stmt.executeUpdate(sql);
	}
	return result;
}
//詳細画面
/*public List<RecipeBean>selectdetail() throws SQLException, ClassNotFoundException{
	
	List<RecipeBean> UserParsonalList = new ArrayList<RecipeBean>();
	//データベース接続
	try(Connection con = ConnectionManager.getConnection();
			Statement stmt = con.createStatement();
			//LocalRecipeTableのテーブルをすべて参照する
			ResultSet res = stmt.executeQuery("SELECT * FROM LocalRecipeTable WHERE = recipeid")){
		while(res.next()) {
			int RecipeId = res.getInt("recipeid");
			String RecipeName = res.getString("recipename");
			//String RecipeImg = res.getString("RecipeImg");
			String RecipeIngredients = res.getString("recipeIngredients");
			String RecipeHowto = res.getString("recipeHowto");
			int RecipeServings = res.getInt("recipeServings");
			Date PostingDatetime = res.getDate("postingDatetime");
			Date UpdateDatetime = res.getDate("updateDatetime");
			
			
			RecipeBean recipebean = new RecipeBean();
			recipebean.setRecipeId(RecipeId);
			recipebean.setRecipeName(RecipeName);
			//recipebean.setRecipeImg(RecipeImg);
			recipebean.setRecipeIngredients(RecipeIngredients);
			recipebean.setRecipeHowto(RecipeHowto);
			recipebean.setRecipeServings(RecipeServings);
			recipebean.setPostingDatetime(PostingDatetime);
			recipebean.setUpdateDatetime(UpdateDatetime);
			
			UserParsonalList.add(recipebean);	
		}
		return UserParsonalList;
	}
	*/
	
	
	//データベースの接続の取得、Statementの取得、SQLステートメントの実行
	
	/*public RecipeBean select(int recipe_id)throws SQLExcption, ClassNotFoundException{
		
		RecipeBean employee = new RecipeBean();
		
		String sql ="SELECT * FROM t_localrecipe WHERE recipe_id";
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			
			pstmt.setInt(1,recipe_id);
			
			ResultSet res = pstmt.executeQuery();
			
			while(res.next()) {
				employee.setrecipe_id(res.getInt("recipe_id"));
				employee.setrecipe_name(res.getString("recipe_name"));
			}
		}
		return employee;
	}*/
	
	
public RecipeBean select(int recipeId)throws SQLException, ClassNotFoundException{
	RecipeBean employee = new RecipeBean();
	
	String sql ="SELECT * FROM t_localrecipe WHERE recipe_id = ?";
	
	try(Connection con = ConnectionManager.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)){
		pstmt.setInt(1, recipeId);
		
		ResultSet res=pstmt.executeQuery();
		
		while(res.next()) {

		    employee.setRecipeId(
		        res.getInt("recipe_id"));

		    employee.setRecipeName(
		        res.getString("recipe_name"));

		    employee.setRecipeIngredients(
		        res.getString("recipe_ingredients"));

		    employee.setRecipeHowto(
		        res.getString("recipe_howto"));

		    employee.setRecipeServings(
		        res.getInt("recipe_servings"));

		    employee.setPostingDatetime(
		        res.getDate("posting_date_time"));

		    employee.setUpdateDatetime(
		        res.getDate("update_date_time"));
		}
		
	
	}
	return employee;
}
}
