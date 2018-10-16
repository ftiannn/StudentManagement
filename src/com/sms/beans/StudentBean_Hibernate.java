package com.sms.beans;

import com.sms.dao.StudentDAO;
import com.sms.dao.StudentHibernateDAO;
import com.sms.pojo.Student;

public class StudentBean_Hibernate {
	
	public boolean addstudent(Student s) {
			boolean errormsg = false;
			
			/*
			 * if ((!s.getName().matches("^[a-zA-Z]+$")) || (!s.getEmail().matches("/^[\\w.-]+@[\\w.]+\\.[A-Za-z]{2,3}$/"))
					|| (!s.getContact().matches("/^\\d{8}$/")) || s.getAddress() != null 
					|| s.getGender() != null || s.getCountry() != null) 
			 */
			if ((s.getName()== null) || (s.getEmail()== null) || (s.getContact()== null) || (s.getAddress() == null) || (s.getGender() == null) || (s.getCountry() == null)) {
					errormsg = true;
			} else {
				boolean DAOresult = StudentHibernateDAO.addstudent(s);
				if (DAOresult == true) {
					errormsg = false;
				} else {
					errormsg = true;
				}
			}
			return errormsg;
    }
	
	public boolean removestudent(Student s) {
		boolean errormsg = false;
		if (s.getId() == 0) {
			errormsg = true;
		} else {
			boolean DAOresult = StudentHibernateDAO.removestudent(s);
			if (DAOresult == true) {
				errormsg = false;
			} else {
				errormsg = true;
			}
		}
		return errormsg;
	}
	
	public String updatestudent(Student s) {
		String errormsg = "";
		if ((s.getId() == 0) || (s.getName()== null) || (s.getEmail()== null) || (s.getContact()== null) || (s.getAddress() == null) || (s.getGender() == null) || (s.getCountry() == null)) {
				errormsg = "Empty Entry";
		} else {
			String DAOresult = StudentHibernateDAO.updatestudent(s);
			if (DAOresult == "") {
				errormsg = "";
			} else {
				errormsg = DAOresult;
			}
		}
		return errormsg;
	}
	
	
	
}
