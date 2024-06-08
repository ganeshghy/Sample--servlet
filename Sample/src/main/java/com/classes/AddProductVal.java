package com.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddProductVal {
	public String setValue(String pID,String pName, String pPrice) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		int i = 0;
		try {
			String query = "jdbc:mysql://localhost:3306/servlet";
			String user = "root";
			String pwd = "root";
			
			String sql = "insert into product values(?,?,?)";
			Class.forName("com.mysql.jdbc.Driver");  
			con = DriverManager.getConnection(query,user,pwd);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pID);
			pstmt.setString(2, pName);
			pstmt.setString(3, pPrice);
			i = pstmt.executeUpdate();
			
			}
		catch(Exception e) {
			e.printStackTrace();
		}
		if(i > 0) {
			return "SUCCESS";
		}
		else {
			return "FAIL";
		}
		
	}
}
