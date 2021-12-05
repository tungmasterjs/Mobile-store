package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Admin {
	private String username,password,role;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	public String getRole() {
//		return role;
//	}
//
//	public void setRole(String role) {
//		this.role = role;
//	}
	public Admin login(String user, String pass) {
		Admin admin = new Admin();
		try {
			Class.forName(ConnectDB.jdbc_driver);
			Connection cn = DriverManager.getConnection(ConnectDB.url,ConnectDB.user,ConnectDB.pass);
			String sql = "select Username,Password from admin where Username=? and Password=?";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
//				admin.setNameUser(rs.getString("Name_User"));
				admin.setUsername(rs.getString("Username"));
				admin.setPassword(rs.getString("Password"));
			}
			rs.close();
			ps.close();
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return admin;
	}
}
