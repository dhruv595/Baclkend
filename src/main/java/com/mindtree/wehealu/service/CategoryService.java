package com.mindtree.wehealu.service;

import java.util.List;


import com.mindtree.wehealu.entity.Category;
import com.mindtree.wehealu.entity.SubCategory;

public interface CategoryService {
	
	public List<Category> getCategories();
	public List<SubCategory> getSubCategories(int category_id);
	public List<SubCategory> getAllSubCategories();

}
