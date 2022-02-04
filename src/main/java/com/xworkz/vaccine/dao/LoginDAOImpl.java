package com.xworkz.vaccine.dao;

import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.vaccine.service.LoginServiceImpl;

@Repository
public class LoginDAOImpl implements LoginDAO {

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
			System.out.println("password is " + password);
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

	@Override
	public int updateLoginAttempt(String userName, int currentAttempt) {

		Session session = null;
		try {
			String passwordNullCheck = this.isUserExist(userName);
			if (passwordNullCheck != null) {
				int attempt = currentAttempt + 1;
				session = factory.openSession();
				session.getTransaction().begin();
				String hql = "UPDATE UserSignUpEntity SET loginAttempt=:attempt WHERE name=:user_name";
				Query query = session.createQuery(hql);
				query.setParameter("user_name", userName);
				query.setParameter("attempt", attempt);
				query.executeUpdate();
				session.getTransaction().commit();
				int updatedAttempt = this.getUpdatedAttempt(userName);
				return updatedAttempt;
			}

		} catch (HibernateException exp) {
			System.out.println("An exception occured " + exp.getMessage());
		} finally {
			if (session != null) {
				session.close();
				System.out.println("session closed");
			}
		}
		return 0;
	}

	@Override
	public int getUpdatedAttempt(String userName) {
		Session session = null;
		try {
			String passwordNullCheck = this.isUserExist(userName);
			if (passwordNullCheck != null) {
				session = factory.openSession();
				String hql = "SELECT loginAttempt FROM UserSignUpEntity WHERE name=:user_name";
				Query query = session.createQuery(hql);
				query.setParameter("user_name", userName);
				int updatedAttempt = (int) query.uniqueResult();
				System.out.println("login attempt updated is " + updatedAttempt);
				return updatedAttempt;
			}
		} catch (HibernateException exp) {
			System.out.println("An exception occured " + exp.getMessage());
		} finally {
			if (session != null) {
				session.close();
				System.out.println("session closed");
			}
		}
		return 0;
	}

	@Override
	public boolean resetPassword(String password, String emailId) {
		Session session = null;
		try {
			session = factory.openSession();
			session.getTransaction().begin();
			String hql = "UPDATE UserSignUpEntity SET password=:password WHERE emailId=:emailId";
			Query query = session.createQuery(hql);
			query.setParameter("emailId", emailId);
			query.setParameter("password", password);
			int rowsUpdated = query.executeUpdate();
			if(rowsUpdated>=1) {
				LoginServiceImpl.loginAttempt=0;
				String hqlLoginAttempt = "UPDATE UserSignUpEntity SET loginAttempt=0 WHERE emailId=:emailId";
				Query query1 = session.createQuery(hqlLoginAttempt);
				query1.setParameter("emailId", emailId);
				query1.executeUpdate();
			}
			session.getTransaction().commit();
			return true;

		} catch (HibernateException exp) {
			System.out.println("An exception occured " + exp.getMessage());
		} finally {
			if (session != null) {
				session.close();
				System.out.println("session closed");
			}
		}
		return false;
	}

}
