package com.classes;

import java.sql.*;

public class DeleteClass {
	public String setDelete(String deleteID) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt = null;
		int i=0;
		try {
			String url = "jdbc:mysql://localhost:3306/servlet";
			String username = "root";
			String password = "root";
			
			String query = "delete from product where pID=?";
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, deleteID);
			i = pstmt.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		if(i>0) {
			return "SUCCESS";
		}
		else {
			return "FAIL";
		}
	}
}
