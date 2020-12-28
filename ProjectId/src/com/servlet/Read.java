package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Read")
public class Read extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sql = "SELECT * FROM PRODUCT WHERE ID=?;";
		Connection conn = null;
		PreparedStatement pst = null;
		
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
			pst = conn.prepareStatement(sql);
			pst.setString(1, request.getParameter("searchTerm"));
			ResultSet rs = pst.executeQuery();
			if (!rs.next()) {
				response.getWriter().println("not found");
			} else {
				String id = rs.getString(1);
				String name = rs.getString(2);
				response.getWriter().println("The product with ID "+id+" is called "+name);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// close the statement
				pst.close();
				// close the onnection
				conn.close();
				if (conn.isClosed())
					System.out.println("connection is closed");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
	}

}
