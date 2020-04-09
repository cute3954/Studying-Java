package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// SQL接続テスト用
public class Test {
	public static void main(String[] args) throws SQLException{
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/url";
			conn = DriverManager.getConnection(url, "user", "pwd");
			System.out.println("SQL Connection Successful");
		} catch (ClassNotFoundException e) {
			System.out.println("Failed Loading");
		} catch (SQLException e) {
			System.out.println("Error:" + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
