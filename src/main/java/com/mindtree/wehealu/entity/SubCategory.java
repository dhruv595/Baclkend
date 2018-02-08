package com.mindtree.wehealu.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.mindtree.wehealu.entity.Category;

@Entity
@Table(name="subcategory")
public class SubCategory {

	@Id
	@Column(nullable=false,length=7)
	private int subCategoryId;
	@Column(nullable=false,length=40)
	private String subCategoryName;
	@ManyToOne
	@JoinColumn(name="categoryId",nullable=false)
	private Category category;
	
	public SubCategory() {
	}

	public int getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "SubCategory [subCategoryId=" + subCategoryId + ", subCategoryName=" + subCategoryName + ", category="
				+ category + "]";
	}

	
	
	
}
