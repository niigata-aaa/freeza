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
		
		List<FoodBean> list = new ArrayList<>();

        String sql =
            "SELECT food_id, food_name, food_img " +
            "FROM t_food " +
            "WHERE food_lost_day >= CURDATE() " +
            "AND food_lost_day < DATE_ADD(CURDATE(), INTERVAL 3 DAY)";

        try (Connection con = ConnectionManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                FoodBean bean = new FoodBean();

//                bean.setFoodId(rs.getInt("food_id"));
                bean.setFoodName(rs.getString("food_name"));
                bean.setFoodImage(rs.getString("food_img"));

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