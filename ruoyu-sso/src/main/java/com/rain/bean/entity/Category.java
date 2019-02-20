package com.rain.bean.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @Title Category.java
 * @Description 商品类别表实体
 * @author rain
 * @date 2019年2月13日
 */
@Entity
@Table(name = "category")
public class Category implements Serializable{
	
	private static final long serialVersionUID = -5280303814704819954L;
	
	/** 类别编号 */
	private String categoryId;
	/** 类别名称 */
	private String categoryName;
	/** 类别描述 */
	private String categoryDesc;

	public Category() {
	}
	
	@Id
	@Column(name = "category_id")
	public String getCategoryId() {
		return categoryId;
	}
	@Column(name = "category_name")
	public String getCategoryName() {
		return categoryName;
	}
	@Column(name = "category_desc")
	public String getCategoryDesc() {
		return categoryDesc;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}
}