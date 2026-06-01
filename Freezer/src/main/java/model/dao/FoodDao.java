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
	// 食材一覧表示メソッド
	public List<FoodBean> selectAllFood() throws SQLException, ClassNotFoundException {

	    List<FoodBean> foodList = new ArrayList<FoodBean>();
	    
	    try (Connection con = ConnectionManager.getConnection();
	            Statement stmt = con.createStatement();
	            ResultSet res = stmt.executeQuery("SELECT * FROM t_food")) {

	        while (res.next()) {
	            int foodid = res.getInt("food_id");
	            String foodname = res.getString("food_name");
	            String foodimage = res.getString("food_img"); 
	            Date foodlostday = res.getDate("food_lost_day");
	            int foodquantity = res.getInt("food_quantity"); 

	            FoodBean food = new FoodBean();
	            food.setFoodId(foodid);
	            food.setFoodName(foodname);
	            food.setFoodImage(foodimage);
	            food.setFoodLostDay(foodlostday);
	            food.setFoodQuantity(foodquantity);

	            foodList.add(food);
	        }
	    }
	    return foodList;
	}

		// 食材追加メソッド
		public int insert(FoodBean food) throws ClassNotFoundException, SQLException {

			String sql = "INSERT INTO t_food(food_img, food_name, food_lost_day, food_quantity) VALUES (?, ?, ?, ?)";

			int result = 0;

			try (Connection con = ConnectionManager.getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql)) {

				pstmt.setString(1, food.getFoodImage());
				pstmt.setString(2, food.getFoodName());

				// 消費期限
				if (food.getFoodLostDay() != null) {
					pstmt.setDate(3, new java.sql.Date(food.getFoodLostDay().getTime()));
				} else {
					pstmt.setNull(3, java.sql.Types.DATE);
				}

				pstmt.setInt(4, food.getFoodQuantity());

				result = pstmt.executeUpdate();
			}
			return result;
		}

		// 食材削除メソッド
		public int delete(int foodId) throws ClassNotFoundException, SQLException {
			int count = 0;

			String sql = "DELETE FROM t_food WHERE food_id = ?"; 

			try (Connection con = ConnectionManager.getConnection(); 
					PreparedStatement pstmt = con.prepareStatement(sql)) {

				pstmt.setInt(1, foodId);

				count = pstmt.executeUpdate();
			}
			return count;
		}
	    //食材個数減少メソッド
	    
	    public int reduceQuantity(int foodId, int usedQuantity)
	            throws SQLException, ClassNotFoundException {

	        String sql =
	            "UPDATE t_food  SET food_quantity = food_quantity - ? WHERE food_id = ?";

	        int result = 0;

	        try (Connection con = ConnectionManager.getConnection();
	             PreparedStatement pstmt = con.prepareStatement(sql)) {

	            pstmt.setInt(1, usedQuantity);
	            pstmt.setInt(2, foodId);

	            result = pstmt.executeUpdate();
	        }

	        return result;
	    }

	    //食材検索メソッド
	    
	    public List<FoodBean> searchFood(FoodBean food)
	            throws SQLException, ClassNotFoundException {

	        List<FoodBean> foodList = new ArrayList<>();

	        String sql = "SELECT * FROM t_food WHERE food_name LIKE ?";

	        try (Connection con = ConnectionManager.getConnection();
	             PreparedStatement pstmt = con.prepareStatement(sql)) {

	            pstmt.setString(1, "%" + food.getFoodName() + "%");

	            ResultSet rs = pstmt.executeQuery();

	            while (rs.next()) {

	                FoodBean rsFood = new FoodBean();

	                rsFood.setFoodId(rs.getInt("food_id"));
	                rsFood.setFoodName(rs.getString("food_name"));
	                rsFood.setFoodImage(rs.getString("food_img"));
	                rsFood.setFoodLostDay(rs.getDate("food_lost_day"));
	                rsFood.setFoodQuantity(rs.getInt("food_quantity"));

	                foodList.add(rsFood);
	            }
	        }

	        return foodList;
	    
	    }
	}

		