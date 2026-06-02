package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import model.entity.FoodBean;

public class FoodDao {

    // 食材一覧表示
    public List<FoodBean> selectAllFood() throws SQLException, ClassNotFoundException {

        List<FoodBean> foodList = new ArrayList<>();

        String sql = "SELECT * FROM t_food";

        try (Connection con = ConnectionManager.getConnection();
             Statement stmt = con.createStatement();
             ResultSet res = stmt.executeQuery(sql)) {

        	while (res.next()) {

        	    FoodBean food = new FoodBean();

        	    food.setFoodId(res.getInt("food_id"));
        	    food.setFoodName(res.getString("food_name"));
        	    food.setFoodLostDay(res.getDate("food_lost_day"));
        	    food.setFoodQuantity(res.getInt("food_quantity"));

        	    byte[] img = res.getBytes("food_img");
        	    food.setFoodImage(img);

        	    if (img != null && img.length > 0) {
        	    	String base64Str = Base64.getEncoder().encodeToString(img);
        	    	food.setBase64Image(base64Str);

        	    }

        	    foodList.add(food);
        	}
        }

        return foodList;
    }


    // 食材追加（画像保存）
    public int insert(FoodBean food) throws ClassNotFoundException, SQLException {

        String sql =
            "INSERT INTO t_food(food_img, food_name, food_lost_day, food_quantity) " +
            "VALUES (?, ?, ?, ?)";

        int result = 0;

        try (Connection con = ConnectionManager.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            // ★画像はbyte[]
            pstmt.setBytes(1, food.getFoodImage());
            pstmt.setString(2, food.getFoodName());

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


    // 削除
    public int delete(int foodId) throws ClassNotFoundException, SQLException {

        String sql = "DELETE FROM t_food WHERE food_id = ?";

        try (Connection con = ConnectionManager.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, foodId);

            return pstmt.executeUpdate();
        }
    }


    // 数量減少
    public int reduceQuantity(int foodId, int usedQuantity)
            throws SQLException, ClassNotFoundException {

        String sql =
            "UPDATE t_food SET food_quantity = food_quantity - ? WHERE food_id = ?";

        try (Connection con = ConnectionManager.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, usedQuantity);
            pstmt.setInt(2, foodId);

            return pstmt.executeUpdate();
        }
    }


    // 検索
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
                rsFood.setFoodLostDay(rs.getDate("food_lost_day"));
                rsFood.setFoodQuantity(rs.getInt("food_quantity"));

                // ★画像
                byte[] imgData = rs.getBytes("food_img");
                rsFood.setFoodImage(imgData);

                if (imgData != null && imgData.length > 0) {
                    String base64Str = Base64.getEncoder().encodeToString(imgData);
                    rsFood.setBase64Image(base64Str);
                }

                foodList.add(rsFood);
            }
        }

        return foodList;
    }
}

