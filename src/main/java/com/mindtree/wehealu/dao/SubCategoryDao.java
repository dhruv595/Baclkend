package com.mindtree.wehealu.dao;

import java.util.List;


import com.mindtree.wehealu.entity.SubCategory;

public interface SubCategoryDao {

	public List<SubCategory> getSubCategoryList(int category_id);
	public List<SubCategory> getAllSubcategories();
}
