package com.xworkz.vaccine.dao;

import org.hibernate.HibernateException;
import com.xworkz.vaccine.util.PasswordEncrypt;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
			userSignUpEntity.setPassword(PasswordEncrypt.encryptPassword(userSignUpEntity.getPassword()));
			session.save(userSignUpEntity);
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

}
