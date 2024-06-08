package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.classes.SearchClass;
import com.classes.Product;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	SearchClass sc = new SearchClass();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String searchId = request.getParameter("searchId");
		
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
		
		PrintWriter pw = response.getWriter();
		try {
			if(rs.next()) {
				try {
					String htmlResponse = "<html><table border=2px solid><tr><td>"+rs.getString(1)+"</td><td>" +rs.getString(2)+"</td><td>"+rs.getString(3)+"</td></tr></table></html>";
					pw.println(htmlResponse);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	}

}
