package com.sms.dao;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sms.entity.StudentEntity;
import com.sms.pojo.Student;


public class StudentHibernateDAO {

	// ADD STUDENT
	public static boolean addstudent(Student s) {
		boolean add = true;

		SessionFactory sf = null;
		Session session = null;
		Transaction tr = null;

		try {
			sf = util.HibernateUtil.getSessionFactory();
			session = sf.openSession();
			tr = session.beginTransaction();
			StudentEntity se = new StudentEntity();
			se.setName(s.getName());
			se.setEmail(s.getEmail());
			se.setContact(s.getContact());
			se.setGender(s.getGender());
			se.setAddress(s.getAddress());
			se.setCountry(s.getCountry());
			session.save(se);
			tr.commit();
			add = true;
		} catch (Exception e) {
			add = false;
			tr.rollback();
			session.close();
		}
		return add;
	}

	// UPDATE STUDENT
	public static String updatestudent(Student s) {
		String update = "";

		SessionFactory sf = null;
		Session session = null;
		Transaction tr = null;
		try {
			sf = util.HibernateUtil.getSessionFactory();
			session = sf.openSession();
			tr = session.beginTransaction();
			Query query = session.createQuery("update StudentEntity stu "
					+ "set stu.Name = :name, stu.Email = :email, stu.Contact = :contact, "
					+ "stu.Gender = :gender, stu.Address = :address, stu.Country = :country "
					+ "where stu.Id = :id");
	        query.setParameter("name", s.getName());
	        query.setParameter("email",s.getEmail());
	        query.setParameter("contact", s.getContact());
	        query.setParameter("gender", s.getGender());
	        query.setParameter("address", s.getAddress());
	        query.setParameter("country", s.getCountry());
	        query.setParameter("id", s.getId());
			int i = query.executeUpdate();
			session.getTransaction().commit();
	        	        
	        if(i>0){
	        	update = "";
	        } else {
	        	update = "DB not updated";
	        }

		} catch (Exception e) {
			update = "Exception occurs";
			tr.rollback();
			session.close();
		}
		return update;
	}

	// DELETE STUDENT
	public static boolean removestudent(Student s) {
		boolean remove = true;

		SessionFactory sf = null;
		Session session = null;
		Transaction tr = null;

		try {
			sf = util.HibernateUtil.getSessionFactory();
			session = sf.openSession();
			tr = session.beginTransaction();
			StudentEntity se = new StudentEntity();
			se.setId(s.getId());
			session.delete(se);
			tr.commit();
			remove = true;
		} catch (Exception e) {
			remove = false;
			tr.rollback();
			session.close();
		}
		return remove;
	}

	// LIST STUDENT
	public List<StudentEntity> ListStudent() {
		
		SessionFactory sf = null;
		Session session = null;
		sf = util.HibernateUtil.getSessionFactory();
		session = sf.openSession();
		Query query = session.createQuery("from StudentEntity");
	    List<StudentEntity> s = query.list();
	    return s;
	}

}
