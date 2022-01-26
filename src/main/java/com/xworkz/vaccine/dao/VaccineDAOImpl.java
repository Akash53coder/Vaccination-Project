package com.xworkz.vaccine.dao;

import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.vaccine.entity.UserOTPEntity;

@Repository
public class VaccineDAOImpl implements VaccineDAO {

	@Autowired
	private SessionFactory factory;

	@Override
	public Integer saveOTP(UserOTPEntity userOTPEntity) {
		Session session = null;
		try {
			session = factory.openSession();
			session.getTransaction().begin();
			Integer lastInsertId =  (Integer) session.save(userOTPEntity);
			System.out.println("Last Insert Id"+lastInsertId);
			session.getTransaction().commit();
			return lastInsertId;
		} catch (HibernateException exp) {
			session.getTransaction().rollback();
			System.out.println("An exception occured" + exp.getMessage());
		} finally {
			if (session != null) {
				session.close();
				System.out.println("session closed");
			}
		}
		return 0;
	}

	@Override
	public Integer isOTPPresent(Integer id) {
		System.out.println("called isOTPPresent()");
		Session session = null;
		try {
			session = factory.openSession();
			String hqlQuery = "SELECT otp FROM UserOTPEntity WHERE id=:id";
			Query query = session.createQuery(hqlQuery);
			query.setParameter("id", id);
			Integer otpFromDb = (Integer)query.uniqueResult();
			System.out.println("otp from db "+otpFromDb);
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
	public String getEmailById(Integer id) {
		System.out.println("called getEmailById()");
		Session session = null;
		try {
			session = factory.openSession();
			String hqlQuery = "SELECT emailId FROM UserOTPEntity WHERE id=:id";
			Query query = session.createQuery(hqlQuery);
			query.setParameter("id", id);
			String emailIdFromDB = (String)query.uniqueResult();
			System.out.println("emailId from db "+emailIdFromDB);
			return emailIdFromDB;
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

}
