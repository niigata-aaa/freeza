package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.FoodBean;




public class FoodLostDayDAO {
	public List<FoodBean> selectFoodLostDay() throws SQLException, ClassNotFoundException {
		
		List<FoodBean> foodlostdayList = new ArrayList<FoodBean>();
		String sql = "SELECT food_id, food_image FROM t_food" +
						"WHERE food_lost_day >= CURDATE()" + //CURDATは今日の日付
							"AND food_lost_day < CURDATE_ADD(CURDATE(),INTERVAL 3 DAY";
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet res = pstmt.executeQuery()) {
					
			while (res.next()) {
				int FoodId = res.getInt("FoodId");
				String FoodName = res.getString("FoodName");
				String FoodImage = res.getString("FoodImage");
				
				FoodBean foodlostday = new FoodBean();
				foodlostday.setFoodId(FoodId);
				foodlostday.setFoodName(FoodName);
				foodlostday.setFoodImage(FoodImage);
				
				foodlostdayList.add(foodlostday);
			}
		}
		return foodlostdayList;
	}

}