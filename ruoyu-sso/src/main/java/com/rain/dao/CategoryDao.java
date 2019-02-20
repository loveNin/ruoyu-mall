package com.rain.dao;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.rain.bean.entity.Category;

/**
 * 
 * @Title CategoryDao.java
 * @Description 商品类别表的基本增删改查
 * @author rain
 * @date 2019年2月14日
 */
public interface CategoryDao extends CrudRepository <Category, Serializable> {
	
}