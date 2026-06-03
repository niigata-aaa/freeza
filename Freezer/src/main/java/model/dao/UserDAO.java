package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.UserBean;

public class UserDAO {
	public boolean loginCheck(String UserId, String PassWord) throws ClassNotFoundException, SQLException {

		// ログイン認証
        String sql = "SELECT * FROM m_user WHERE user_id = ? AND user_password = ?";

        try(Connection con = ConnectionManager.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, UserId);
            pstmt.setString(2, PassWord);

            ResultSet res = pstmt.executeQuery();

            if(res.next()) {
                return true;
            }
        }

        return false;
    }

    // 会員登録
    public int insert(UserBean userB) throws ClassNotFoundException, SQLException {

        int count = 0; // 件数処理

        String sql ="INSERT INTO m_user(user_id, user_password) VALUES(?, ?)";

        try(Connection con = ConnectionManager.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)) {

    		String UserId = userB.getUserId();
    		String PassWord = userB.getPassWord();
        	
            pstmt.setString(1, UserId);
            pstmt.setString(2, PassWord);

            count = pstmt.executeUpdate();
        }

        return count;
    }
    
    //利用者か管理者か判定する
    public Boolean admin_flg_Check(String user_id) throws ClassNotFoundException, SQLException {
        String sql = "SELECT admin_flg FROM m_user WHERE user_id = ?";

        Boolean a = null; // 初期化
        
        try(Connection con = ConnectionManager.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)){

            pstmt.setString(1, user_id);

            ResultSet res = pstmt.executeQuery();

            if(res.next()) {
                if(res.getBoolean("admin_flg")) {
                    a = true;  // 管理者
                } else {
                    a = false; // 利用者
                }
            }
        } 
        return a;
    }
}