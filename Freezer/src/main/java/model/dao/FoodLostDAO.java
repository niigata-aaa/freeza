package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import model.entity.FoodLostBean;

public class FoodLostDAO {
	
		public List<FoodLostBean> selectAll() throws Exception {

			List<FoodLostBean> list = new ArrayList<>();

			String sql = "SELECT food_lost_name, food_lost_img FROM t_lostfood";

			try (Connection con = ConnectionManager.getConnection();
					PreparedStatement ps = con.prepareStatement(sql);
					ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {

					FoodLostBean bean = new FoodLostBean();

					bean.setFoodLostName(rs.getString("food_lost_name"));
					 byte[] img = rs.getBytes("food_lost_img");
		        	    bean.setFoodLostImage(img);

		        	    if (img != null && img.length > 0) {
		        	    	String base64Str = Base64.getEncoder().encodeToString(img);
		        	    	bean.setBase64Image(base64Str);

		        	    }

					list.add(bean);
				}
			}

			return list;
		}
	}