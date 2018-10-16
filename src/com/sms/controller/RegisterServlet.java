package com.sms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sms.dao.DBUtil;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String email = request.getParameter("email");
        String contact = request.getParameter("contact");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String country = request.getParameter("country");
        String hobby = request.getParameter("hobby");
        
        try {
	    	Connection  con= DBUtil.getConnection();
        	String query = "Select count(*) from user1 where user =?"; 
        	PreparedStatement ps1=con.prepareStatement(query);
        	ps1.setString(1, user);
        	
        	ResultSet r1 = ps1.executeQuery();
        	
        	if(r1.next()) {
	            int count = r1.getInt(1);
	            
	            if(count == 0){ 
        	
	            	PreparedStatement ps=con.prepareStatement("insert into user1 (user,pass,email,contact,gender,address,country,hobby) values(?,?,?,?,?,?,?,?)");

	            	ps.setString(1, user);
	            	ps.setString(2, pass);
	            	ps.setString(3, email);
	            	ps.setString(4, contact);
	            	ps.setString(5, gender);
	            	ps.setString(6, address);
	            	ps.setString(7, country);
	            	ps.setString(8, hobby);
            
	            	int i=ps.executeUpdate();
            
	            	if(i>0){
	            		out.println("You are sucessfully registered<br>");
	            		out.println("<a href='Login.html'>Click Here</a> to login.");
	            	}
	            	else {
	            		RequestDispatcher rs=request.getRequestDispatcher("fail.html");
	            		rs.include(request, response);
	            	}
	            }
        	
        	else {
        		RequestDispatcher rs=request.getRequestDispatcher("fail.html");
        		rs.include(request, response);
        		}
        	}
        }
        catch(Exception se) {
        	se.printStackTrace();
        }
    }
}
     
