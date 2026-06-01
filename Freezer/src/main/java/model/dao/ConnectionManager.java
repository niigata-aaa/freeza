package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	//データベースURL
		private static final String URL = "jdbc:mysql://localhost:3306/freezerdb";
		
		private static final String USER ="freezerU";
		
		private static final String PASSWORD = "freezerP";
		
		/*
		 * *
		 * データベースへの接続を取得して返します。
		 * 
		 * @return コネクション
		 * @throws SQLException
		 * @throws ClassNotFoundException
		 */
		
		public static Connection getConnection() throws SQLException, ClassNotFoundException{
			//JDBCドライバの読み込み
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(URL,USER,PASSWORD);
		}
		
	}
