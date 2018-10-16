package com.sms.controller;

import java.sql.*;

import com.sms.dao.DBUtil;

public class ValidateUserServlet {
     public static boolean checkUser(String user,String pass) {
      boolean st =false;
      try {
	    	Connection  con= DBUtil.getConnection();
	    	PreparedStatement ps =con.prepareStatement
                             ("select user,pass from user1 where user=? and pass=?");
         ps.setString(1, user);
         ps.setString(2, pass);
         ResultSet rs =ps.executeQuery();
         st = rs.next();
        
      } catch(Exception e){
          e.printStackTrace();
      }
         return st;                 
  }
     
}