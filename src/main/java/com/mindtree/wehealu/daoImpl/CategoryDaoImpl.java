package com.mindtree.wehealu.daoImpl;

import java.util.List;


import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mindtree.wehealu.dao.CategoryDao;
import com.mindtree.wehealu.entity.Category;

@Repository	
public class CategoryDaoImpl implements CategoryDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

//--------------------------------------------------------------------------------------------

	public List<Category> getCategoryList(){
		Session session = sessionFactory.openSession();
		Query<?> query = session.createQuery("from Category");
		List<Category> categories = (List<Category>)query.getResultList();
		session.close();
		return categories;
	}
	

}
