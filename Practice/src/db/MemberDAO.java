package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Member;

public class MemberDAO {
	private Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	private void connectDB () {
		try {
		// JDBCドライバのロード
		// 「com.mysql.jdbc.Driver」クラス名
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost/db";
		String user = "user";
		String pwd = "pwd";
		// DriverManagerクラスのメソッドで接続する
		conn = DriverManager.getConnection(url, user, pwd);
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException:" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("SQLException:" + e.getMessage());
		}
	}
	
	private void closeConnection () {
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
	
	public List<Member> getAllMember () {
		List<Member> memberList = new ArrayList<>();
		try {			
			this.connectDB();					
			String sql = "SELECT * FROM member_lovelive";
			// SQLを実行
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();	
			// 取得できれば
			while (rs.next()) {
				Member member = new Member();
				member.setMember_no(rs.getInt("member_no"));
				member.setMember_name(rs.getString("member_name"));
				member.setMember_image_fileurl(rs.getString("member_image_fileurl"));
				memberList.add(member);
			}
			
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
		} finally {
			this.closeConnection();
		}	
		return memberList;
	}
	
	public void showMemberInfo(Member member) {
		try {			
			this.connectDB();			
			String sql = "SELECT * FROM member_lovelive where member_no = ?";
			// SQLを実行
			ps = conn.prepareStatement(sql);
			ps.setInt(1, member.getMember_no());
			rs = ps.executeQuery();
			
			// 取得できれば
			if (rs.next()) {
				member.setMember_no(rs.getInt("member_no"));
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
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
		} finally {
			this.closeConnection();
		}	
	}
}
