package com.itstep.controller;

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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		String sql = "SELECT * FROM tbl_user WHERE username=? AND password=?";
		String urlConnect = "jdbc:mysql://localhost:3306/register_demo?useSSL=false";
		Connection connect = null;
		
		try {
			connect = DriverManager.getConnection(urlConnect, "root", "12345678aA");
			PreparedStatement statement = connect.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet rs = statement.executeQuery();
			
			boolean successful = rs.next();
			
			if (successful) {
				HttpSession session = request.getSession();
				session.setMaxInactiveInterval(10);
				
				session.setAttribute("username", username);
				session.setAttribute("password", password);
				
				request.getRequestDispatcher("userdetails.jsp").forward(request, response);	
			} else {
				response.setContentType("text/html");
				response.getWriter().print("Login failed!");
				request.getRequestDispatcher("login.html").include(request, response);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
