package com.xworkz.vaccine.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.xworkz.vaccine.entity.AddMemberEntity;

@Repository
public class AddMemberDAOImpl implements AddMemberDAO{

	@Autowired
	private SessionFactory factory;
	@Override
	public boolean saveAddMember(AddMemberEntity addMemberEntity) {
		
		Session session = null;
		try {
			session = factory.openSession();
			session.getTransaction().begin();
			session.save(addMemberEntity);
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
	public int returnAddMemberCount(String userName) {
		Session session = null;
		try {
			session = factory.openSession();
			String hql = "SELECT COUNT(*) FROM AddMemberEntity WHERE byUser=:userName";
			Query query = session.createQuery(hql);
			query.setParameter("userName", userName);
			//int addMemberRowcount = (int)query.uniqueResult(); 
			//count give BigDecimal value
			Long countRows = (Long) query.uniqueResult();
			Integer count = countRows.intValue();
			System.out.println("count is ----------------"+count.intValue());
			return count.intValue();
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
	public List<AddMemberEntity> getAllAddedMember(String userName) {
		Session session = null;
		System.out.println("invoked DaoImpl getNewsPaperEntity()");
		try {
			session = factory.openSession();
			String hqlQuery = "From AddMemberEntity WHERE byUser=:userName";
			Query query = session.createQuery(hqlQuery);
			query.setParameter("userName", userName);
			List<AddMemberEntity> list = query.list();
			if (!list.isEmpty() && list != null) {
				return list;
			} else {
				System.out.println("Table is Empty");
			}
		} catch (HibernateException exp) {
			System.out.println("An exception occured" + exp.getMessage());
		} finally {
			if (session != null) {
				System.out.println("session is closed");
				session.close();
			}
		}
		return null;
	}

}
