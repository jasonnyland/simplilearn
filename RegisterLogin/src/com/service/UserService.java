package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dao.UserDao;
import com.model.Login;
import com.model.Registration;

public class UserService implements UserDao{

	String sql = "insert into employee(empName, empEmail, empCity, empPass) values (?,?,?,?)";
	String sql2 = "select emppass from employee where empname=?";
	
	@Override
	public void registration(Registration reg) {
		
		Connection conn = null;
		PreparedStatement pst = null;

		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");

			// write the statement
			pst = conn.prepareStatement(sql);
			pst.setString(1, reg.getName());
			pst.setString(2, reg.getEmail());
			pst.setString(3, reg.getCity());
			pst.setString(4, reg.getPass());
			int registered = pst.executeUpdate();
			if (registered > 0) {
				System.out.println("added");
				System.out.println(reg.getName()+" is registered");
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("user is inserted");

			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
		

	@Override
	public void login(Login login) {
		Connection conn = null;
		PreparedStatement pst = null;

		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");

			// write the statement
			pst = conn.prepareStatement(sql2);
			pst.setString(1, login.getName());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String passAttempt = rs.getString(1);
				if (passAttempt.equals(login.getPass())) {
					System.out.println("User login succeeded");
				} else {
					System.out.println("Incorrect password");
				}
			} else {
				System.out.println("User not found");
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("login attempt done");

			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		
	}

}
