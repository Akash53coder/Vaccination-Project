package com.xworkz.vaccine.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.vaccine.entity.UserSignUpEntity;

@Repository
public class SignUpDAOImpl implements SignUpDAO {

	@Autowired
	private SessionFactory factory;

	@Override
	public boolean saveSignUpData(UserSignUpEntity userSignUpEntity) {

		Session session = null;
		try {
			session = factory.openSession();
			session.getTransaction().begin();
			session.save(userSignUpEntity);
			System.out.println("---------------------this is login attempt "+userSignUpEntity.getLoginAttempt());
			session.getTransaction().commit();
			return true;
		} catch (HibernateException exp) {
			session.getTransaction().rollback();
			System.out.println("An exception occured " + exp.getMessage());
		} finally {
			if (session != null) {
				session.close();
				System.out.println("session closed");
			}
		}
		return false;
	}

	@Override
	public String getPassword(String emailId) {
		Session session = null;
		try {
			session = factory.openSession();
			String hql = "SELECT password FROM UserSignUpEntity WHERE emailId=:emailId";
			Query query = session.createQuery(hql);
			query.setParameter("emailId", emailId);
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
