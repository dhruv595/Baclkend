package com.mindtree.wehealu.daoImpl;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mindtree.wehealu.dao.ZipcodeDao;
import com.mindtree.wehealu.entity.Doctor;
import com.mindtree.wehealu.entity.Zipcode;

@Repository
public class ZipcodeDaoImpl implements ZipcodeDao {

	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//------------------------------------------------------------------------------------------------
	public List<Zipcode> getAddressList(){
		Session session = sessionFactory.openSession();
		Query<?> query = session.createQuery("from Zipcode");
		List<Zipcode> zipcodes = (List<Zipcode>)query.getResultList();
		session.close();
		return zipcodes;
	}


	@Override
	public boolean addZipcode(Zipcode zipcode) {
		Session session = sessionFactory.openSession();
		Transaction trx=session.beginTransaction();
		session.saveOrUpdate(zipcode);
		trx.commit();
		session.close();
		return true;
	}
}
