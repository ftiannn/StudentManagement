package com.sms.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sms.pojo.Student;

public class StudentDAO {
	
	// ADD STUDENT

	public static boolean addstudent(Student s) {
		boolean add = true;
		try {
	    	
	    	Connection  con= DBUtil.getConnection();
	    	String sql = "insert into student (name,email,contact,gender,address,country) values(?,?,?,?,?,?)";
	        PreparedStatement ps=con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	
	        ps.setString(1, s.getName());
	        ps.setString(2, s.getEmail());
	        ps.setString(3, s.getContact());
	        ps.setString(4, s.getGender());
	        ps.setString(5, s.getAddress());
	        ps.setString(6, s.getCountry());
	        
	        ps.executeUpdate();
	        ResultSet rs = ps.getGeneratedKeys();
	        if(rs.next()){
	        	int id = rs.getInt(1);
	            s.setId(id);
	            add = true;
	        } else {
	        	add = false;
	        }
	    } catch(Exception se) {
	    	se.printStackTrace();
	    }
		return add;
	}
	
	// REMOVE STUDENT
	
	public static boolean removestudent(Student s) {
		boolean remove = true;
		try {	    	
	    	Connection  con= DBUtil.getConnection();
	    	String sql = ("DELETE from student where idstudent=?");
	        PreparedStatement ps=con.prepareStatement(sql);

	        ps.setInt(1, s.getId());
	        
        	int i = ps.executeUpdate();
        	
	        if(i>0){
	        	remove = true;
	        } else {
	        	remove = false;
	        }
        } catch(Exception se) {
        	se.printStackTrace();
        	}
		return remove;
	}
	
	
	// UPDATE STUDENT

	public static boolean updatestudent(Student s) {
		boolean update = true;
		try {
	    	
	    	Connection  con= DBUtil.getConnection();
	    	String sql = ("update student set name = ?, email =?, contact=?, gender=?,address=?,country=? where idstudent=?");
	        PreparedStatement ps=con.prepareStatement(sql);
	
	        ps.setString(1, s.getName());
	        ps.setString(2, s.getEmail());
	        ps.setString(3, s.getContact());
	        ps.setString(4, s.getGender());
	        ps.setString(5, s.getAddress());
	        ps.setString(6, s.getCountry());
	        ps.setInt(7, s.getId());
	        
	        int i = ps.executeUpdate();
	        if(i>0){
	        	update = true;
	        } else {
	        	update = false;
	        }
        } catch(Exception se) {
        	se.printStackTrace();
        	}
		return update;
	}
	
	//LIST STUDENT
	
	public static List<Student> ListStudent() {
		List<Student> studentList = new ArrayList();
    	String query = "Select * from student"; 

		try {
			Statement stmt = DBUtil.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				Student s = new Student();
				s.setId(Integer.parseInt(rs.getString("idstudent")));
				s.setName(rs.getString("name"));
				s.setEmail(rs.getString("email"));
				s.setContact(rs.getString("contact"));
				s.setGender(rs.getString("gender"));
				s.setAddress(rs.getString("address"));
				s.setCountry(rs.getString("country"));
				studentList.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return studentList;
	}
}

