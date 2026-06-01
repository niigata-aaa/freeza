package model.dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.FoodLostBean;

public class FoodLostDAO {
	public List<FoodLostBean> selectAll() throws SQLException, ClassNotFoundException {
		
		List<FoodLostBean> foodlostList = new ArrayList<FoodLostBean>();
		String sql = "SELECT * FROM t_foodlost";
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet res = pstmt.executeQuery()) {
					
			while (res.next()) {
				int FoodLostId = res.getInt("FoodLostId");
				String FoodLostName = res.getString("FoodLostName");
				Blob FoodLostImage = res.getBlob("FoodLostImage");
				
				FoodLostBean foodlost = new FoodLostBean();
				foodlost.setFoodLostId(FoodLostId);
				foodlost.setFoodLostName(FoodLostName);
				foodlost.setFoodLostImage(FoodLostImage);
				
				foodlostList.add(foodlost);
			}
		}
		return foodlostList;
	}

}