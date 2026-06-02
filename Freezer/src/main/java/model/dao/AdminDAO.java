package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {
    public boolean loginCheck(String adminId, String adminPassword) throws ClassNotFoundException, SQLException {
        boolean isSuccess = false;
        
        String sql = "SELECT * FROM m_admin WHERE admin_id = ? AND admin_password = ?";
        
        try (Connection con = ConnectionManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, adminId);
            ps.setString(2, adminPassword);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // データが存在すればログイン成功
                    isSuccess = true;
                }
            }
        }
        return isSuccess;
    }
}