package com.mindtree.wehealu.controller;

import java.util.List;


import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.wehealu.service.CategoryService;
import com.mindtree.wehealu.dto.CustomResponse;
import com.mindtree.wehealu.entity.Category;
import com.mindtree.wehealu.entity.SubCategory;

@CrossOrigin
@RestController
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
//-------------------------------------------------------------------------------
	
	@RequestMapping(value="/category",method=RequestMethod.GET)
	public List<Category> getCategoryList(){
		return categoryService.getCategories();
	}
	
	@RequestMapping(value="/subcategory",method=RequestMethod.GET)
	public List<SubCategory> getSubCategoryList(@QueryParam("category_id") Integer categoryId){
		return categoryService.getSubCategories(categoryId);
	}

	@RequestMapping(value="/subcategories",method=RequestMethod.GET)
	public List<SubCategory> getAllSubcategories(){
		/*CustomResponse cr = new CustomResponse();
		cr.setData(categoryService.getAllSubCategories());
		if(cr.getData()!=null){
			cr.setError(101);
			cr.setMessage("Success");
		}
		else {
			cr.setError(109);
			cr.setMessage("Failure");
		}*/
		
		return categoryService.getAllSubCategories();
	} 

}
