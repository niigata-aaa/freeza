package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.entity.FoodBean;

public class FoodDao {
	//食材一覧表示メソッド

		public List<FoodBean> selectAllFood() throws SQLException, ClassNotFoundException {

			List<FoodBean> foodList = new ArrayList<FoodBean>();

		    try (Connection con = ConnectionManager.getConnection();
		         Statement stmt = con.createStatement();
		         ResultSet res = stmt.executeQuery("SELECT * FROM t_food")) {

		        while (res.next()) {
		            int foodid = res.getInt("id");
		            String foodname = res.getString("name");
		            
		            //
		            java.io.InputStream foodimage = res.getBinaryStream("img");
		            
		            Date foodlostday = res.getDate("date");
		            int foodquantity = res.getInt("quantity");
		            String markcolor = res.getString("color");		

		            FoodBean food = new FoodBean();
		            food.setFoodId(foodid);
		            food.setFoodName(foodname);
		            
		            //
		            food.setFoodImage(foodimage);
		            
		            food.setFoodLostDay(foodlostday);
		            food.setFoodQuantity(foodquantity);
		            food.setMarkColor(markcolor);

		            foodList.add(food);
		        }
		    }

		    return foodList;
		}
		//食材追加メソッド
		public int insert(FoodBean food) throws ClassNotFoundException, SQLException {
			String sql = "INSERT INTO food_table(food_image, food_name, food_lost_day, food_quantity) "+ "VALUES (?, ?, ?, ?)";

			int result = 0;

			//データベース接続
			try (Connection con = ConnectionManager.getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql)) {

				//画像（Blob型：InputStream）
				if (food.getFoodImage() != null) {
					pstmt.setBinaryStream(1, food.getFoodImage()); 
				} else {
					pstmt.setNull(1, java.sql.Types.BLOB);
				}

				//食材名
				pstmt.setString(2, food.getFoodName());

				//消費期限（java.sql.Dateに変換）
				if (food.getFoodLostDay() != null) {
					pstmt.setDate(3, new java.sql.Date(food.getFoodLostDay().getTime()));
				} else {
					pstmt.setNull(3, java.sql.Types.DATE);
				}

				//数量
				pstmt.setInt(4, food.getFoodQuantity());

				//データベースに保存する
				result = pstmt.executeUpdate();
			}

			
			return result;
		}
	}
