package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Member;

public class MemberDAO {
	public void execute(Member member) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// JDBCドライバのロード
			// 「com.mysql.jdbc.Driver」クラス名
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/url";
			String user = "user";
			String pwd = "pwd";
			// DriverManagerクラスのメソッドで接続する
			conn = DriverManager.getConnection(url, user, pwd);
			
			String sql = "SELECT * FROM member_lovelive where member_no = ?";
			// SQLを実行
			ps = conn.prepareStatement(sql);
			ps.setInt(1, member.getMember_no());
			rs = ps.executeQuery();
			
			// 取得できれば
			if (rs.next()) {
				member.setMember_name(rs.getString("member_name"));
				member.setMember_name_hurigana(rs.getString("member_name_hurigana"));
				member.setMember_name_eng(rs.getString("member_name_eng"));
				member.setMember_groupName(rs.getString("member_groupname"));
				member.setMember_grade(rs.getInt("member_grade"));
				member.setMember_birthday(rs.getTimestamp("member_birthday"));
				member.setMember_bloodType(rs.getString("member_bloodType"));
				member.setMember_height(rs.getInt("member_height"));
				member.setMember_hobby(rs.getString("member_hobby"));
				member.setMember_skill(rs.getString("member_skill"));
				member.setMember_image_fileurl(rs.getString("member_image_fileurl"));
			}
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException:" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("SQLException:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
		} finally {
			try {
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
				if (ps != null && !ps.isClosed()) {
					ps.close();
				}
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}
}
