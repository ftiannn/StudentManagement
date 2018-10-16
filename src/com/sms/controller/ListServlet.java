package com.sms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.sms.beans.StudentBean_Hibernate;
import com.sms.dao.StudentDAO;
import com.sms.dao.StudentHibernateDAO;
import com.sms.entity.StudentEntity;
import com.sms.pojo.Student;

@WebServlet("/ListServlet")
public class ListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession sess = request.getSession(false);
		if (sess == null) {
			response.sendRedirect("login.html");
		} else if (sess.getAttribute("loggedin") == null || (boolean) sess.getAttribute("loggedin") == false) {
			request.getRequestDispatcher("LogoutServlet").forward(request, response);
		} else {
			
			String[] beansXMLFiles = new String[]{
				      "file:C:/Users/724518/eclipse-workspace/StudentMgm1/src/beans-aspect.xml",
				      "file:C:/Users/724518/eclipse-workspace/StudentMgm1/src/beans.xml"
				      }; 
			ApplicationContext context = new FileSystemXmlApplicationContext(beansXMLFiles);
			StudentHibernateDAO bean = (StudentHibernateDAO) context.getBean("liststudent");
				

			List<StudentEntity> studentList = bean.ListStudent();
			request.setAttribute("studentlist", studentList);
			request.getRequestDispatcher("ListStudent.jsp").forward(request, response);
		}


	}
}
