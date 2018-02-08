package com.mindtree.wehealu.serviceImpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.wehealu.dao.CategoryDao;
import com.mindtree.wehealu.dao.SubCategoryDao;
import com.mindtree.wehealu.entity.Category;
import com.mindtree.wehealu.entity.SubCategory;
import com.mindtree.wehealu.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	SubCategoryDao subCategoryDao;
	
		
	public SubCategoryDao getSubCategoryDao() {
		return subCategoryDao;
	}
	public void setSubCategoryDao(SubCategoryDao subCategoryDao) {
		this.subCategoryDao = subCategoryDao;
	}
	public CategoryDao getCategoryDao() {
		return categoryDao;
	}
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
//-----------------------------------------------------------------------------------------------------


	public List<Category> getCategories() {
		return categoryDao.getCategoryList();
	}
	
	
	
	//------------------------------- Subcategory ----------------------------------------------------
	
	public List<SubCategory> getSubCategories(int category_id){
		return subCategoryDao.getSubCategoryList(category_id);
	}
	public List<SubCategory> getAllSubCategories() {
		
		return subCategoryDao.getAllSubcategories();
	}

}
