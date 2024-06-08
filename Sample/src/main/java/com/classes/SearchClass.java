package com.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchClass {
	public void getResult(String searchId) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String url = "jdbc:mysql://localhost:3306/servlet";
			String username = "root";
			String password = "root";
			
			String query = "select * from product where pID=?";
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1,searchId);
			rs = pstmt.executeQuery();			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		if(rs.next()) {
			System.out.print(rs.getString(2));
		}
	}
}
