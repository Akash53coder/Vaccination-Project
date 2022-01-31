package com.xworkz.vaccine.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAOImpl implements LoginDAO{

	@Autowired
	private SessionFactory factory;
	
	@Override
	public String isUserExist(String userName) {
		Session session = null;
		try {
			session = factory.openSession();
			String hql = "SELECT password FROM UserSignUpEntity WHERE name=:user_name";
			Query query = session.createQuery(hql);
			query.setParameter("user_name", userName);
			String password = (String) query.uniqueResult();
			System.out.println("password is "+password);
			return password;
		} catch (HibernateException exp) {
			System.out.println("An exception occured " + exp.getMessage());
		} finally {
			if (session != null) {
				session.close();
				System.out.println("session closed");
			}
		}
		return null;
	}

}
