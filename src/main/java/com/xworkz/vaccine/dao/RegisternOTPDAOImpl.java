package com.xworkz.vaccine.dao;

import org.hibernate.HibernateException;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.vaccine.entity.UserOTPEntity;

@Repository
public class RegisternOTPDAOImpl implements RegisternOTPDAO {

	@Autowired
	private SessionFactory factory;

	@Override
	public boolean saveOTP(UserOTPEntity userOTPEntity) {
		Session session = null;
		try {
			session = factory.openSession();
			session.getTransaction().begin();
			session.save(userOTPEntity);
			session.getTransaction().commit();
			return true;
		} catch (HibernateException exp) {
			session.getTransaction().rollback();
			System.out.println("An exception occured" + exp.getMessage());
		} finally {
			if (session != null) {
				session.close();
				System.out.println("session closed");
			}
		}
		return false;
	}

	@Override
	public Integer isOTPPresent(String emailId) {
		System.out.println("called isOTPPresent()");
		Session session = null;
		try {
			session = factory.openSession();
			String hqlQuery = "SELECT otp FROM UserOTPEntity WHERE emailId=:emailId";
			Query query = session.createQuery(hqlQuery);
			query.setParameter("emailId", emailId);
			Integer otpFromDb = (Integer) query.uniqueResult();
			System.out.println("otp from db " + otpFromDb);
			return otpFromDb;
		} catch (HibernateException exp) {
			System.out.println("An exception occured" + exp.getMessage());
		} finally {
			if (session != null) {
				session.close();
				System.out.println("session closed");
			}
		}
		return null;
	}

	@Override
	public boolean updateOTPDetails(UserOTPEntity userOTPEntity) {
		System.out.println("called updateOTPDetails()");
		Session session = null;
		try {
			session = factory.openSession();
			session.getTransaction().begin();
			String hqlQuery = "UPDATE UserOTPEntity SET otp=:otp WHERE emailId=:emailId";
			Query query = session.createQuery(hqlQuery);
			query.setParameter("emailId", userOTPEntity.getEmailId());
			query.setParameter("otp", userOTPEntity.getOtp());
			query.executeUpdate();
			session.getTransaction().commit();
			return true;
		} catch (HibernateException exp) {
			session.getTransaction().rollback();
			System.out.println("An exception occured" + exp.getMessage());
		} finally {
			if (session != null) {
				session.close();
				System.out.println("session closed");
			}
		}
		return false;
	}

}
