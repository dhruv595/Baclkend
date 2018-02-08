package com.mindtree.wehealu.daoImpl;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mindtree.wehealu.dao.SubCategoryDao;
import com.mindtree.wehealu.entity.SubCategory;

@Repository
public class SubCategoryDaoImpl implements SubCategoryDao {
	
	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//-----------------------------------------------------------------
	
	public List<SubCategory> getSubCategoryList(int categoryId){
		Session session = sessionFactory.openSession();
		Query<?> query = session.createQuery("from SubCategory where categoryId = :id");
		query.setParameter("id",categoryId);
		List<SubCategory> subCategories = (List<SubCategory>)query.getResultList();
		session.close();
		return subCategories;
	}

	public List<SubCategory> getAllSubcategories() {
		Session session = sessionFactory.openSession();
		Query<?> query = session.createQuery("from SubCategory");
		List<SubCategory> subcategories = (List<SubCategory>)query.getResultList();
		session.close();
		return subcategories;
	}

}
