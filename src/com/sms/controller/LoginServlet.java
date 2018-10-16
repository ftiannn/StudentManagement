package com.sms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();

		String user = request.getParameter("user");
		String pw = request.getParameter("password");

		if (ValidateUserServlet.checkUser(user, pw) == true) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			session.setAttribute("loggedin", true);
			RequestDispatcher rs = request.getRequestDispatcher("Home.jsp");
			rs.forward(request, response);
		} else {
			out.println("username/password is incorrect");
			RequestDispatcher rs = request.getRequestDispatcher("Login.html");
			rs.include(request, response);
		}
	}
}