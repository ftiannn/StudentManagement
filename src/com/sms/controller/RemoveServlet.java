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

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.sms.beans.StudentBean;
import com.sms.beans.StudentBean_Hibernate;
import com.sms.pojo.Student;

/**
 * Servlet implementation class RemoveServlet
 */
@WebServlet("/RemoveServlet")
public class RemoveServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		HttpSession sess = request.getSession(false);
		if (sess == null) {
			response.sendRedirect("login.html");
		} else if (sess.getAttribute("loggedin") == null || (boolean) sess.getAttribute("loggedin") == false) {
			request.getRequestDispatcher("LogoutServlet").forward(request, response);
		} else {

			Student student = new Student();
			student.setId(Integer.parseInt(request.getParameter("id")));
			
			
			String[] beansXMLFiles = new String[]{
				      "file:C:/Users/724518/eclipse-workspace/StudentMgm1/src/beans-aspect.xml",
				      "file:C:/Users/724518/eclipse-workspace/StudentMgm1/src/beans.xml"
				      }; 
			ApplicationContext context = new FileSystemXmlApplicationContext(beansXMLFiles);
			StudentBean_Hibernate bean = (StudentBean_Hibernate) context.getBean("removestudent");
				

			Boolean errormsg = bean.removestudent(student);

			if (errormsg == false) {
				request.setAttribute("removesuccessful", student);
				RequestDispatcher rs = request.getRequestDispatcher("RemoveSuccessful.jsp");
				rs.forward(request, response);
			}

			else {
				request.setAttribute("removefail", student);
				RequestDispatcher rs = request.getRequestDispatcher("RemoveFailure.jsp");
				rs.forward(request, response);
			}
		}
	}
}
