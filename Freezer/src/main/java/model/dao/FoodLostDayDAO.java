package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import model.entity.FoodBean;




public class FoodLostDayDAO {
	public List<FoodBean> selectFoodLostDay() throws SQLException, ClassNotFoundException {
		
		List<FoodBean> list = new ArrayList<>();

		String sql =
				"SELECT food_lost_day, food_id, food_name, food_img, " +
				"DATEDIFF(food_lost_day, CURDATE()) AS days_left " +
				"FROM t_food " +
				"WHERE DATEDIFF(food_lost_day, CURDATE()) BETWEEN 0 AND 3 " +
				"ORDER BY days_left ASC";

		try (Connection con = ConnectionManager.getConnection();
			 PreparedStatement ps = con.prepareStatement(sql);
			 ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {

				FoodBean bean = new FoodBean();

				//bean.setFoodId(rs.getInt("food_id"));
				bean.setFoodName(rs.getString("food_name"));
				byte[] img = rs.getBytes("food_img");
        	    bean.setFoodImage(img);

        	    if (img != null && img.length > 0) {
        	    	String base64Str = Base64.getEncoder().encodeToString(img);
        	    	bean.setBase64Image(base64Str);

        	    }
				bean.setFoodLostDay(rs.getDate("food_lost_day")); 

				int daysLeft = rs.getInt("days_left");
				bean.setDaysLeft(daysLeft);

				// アラート
				if (daysLeft == 0) {
					bean.setMarkColor("red");
				} else if (daysLeft == 1) {
					bean.setMarkColor("orange");
				} else if (daysLeft == 2) {
					bean.setMarkColor("green");
				} else {
					bean.setMarkColor("blue");
				}

				list.add(bean);
			}
		}

		return list;
	}
	
	public void moveExpiredFoods() throws Exception {
		String insertSql =
			"INSERT INTO t_lostfood (food_lost_name, food_lost_img) " +
			"SELECT food_name, food_img FROM t_food WHERE food_lost_day < CURDATE()";

		String deleteSql =
			"DELETE FROM t_food WHERE food_lost_day < CURDATE()";

		try (Connection con = ConnectionManager.getConnection();
			 PreparedStatement ps1 = con.prepareStatement(insertSql);
			 PreparedStatement ps2 = con.prepareStatement(deleteSql)) {

			ps1.executeUpdate();
			ps2.executeUpdate();
		}
	}
}