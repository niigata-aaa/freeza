package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.entity.FoodLostBean;

public class FoodLostDAO {
	public List<FoodLostBean> selectAll() throws Exception {

		List<FoodLostBean> list = new ArrayList<>();

		String sql = "SELECT food_lost_id, food_lost_name, food_lost_img FROM t_lostfood";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {

				FoodLostBean bean = new FoodLostBean();

//			    bean.setFoodLostId(rs.getInt("food_lost_id"));
			    bean.setFoodLostName(rs.getString("food_lost_name"));
			    bean.setFoodLostImage(rs.getString("food_lost_img"));

				list.add(bean);
			}
		}

		return list;
	
	}

}