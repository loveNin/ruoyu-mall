package com.rain.dao;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import com.rain.bean.entity.Favorable;

/**
 * 
 * @Title FavorableDao.java
 * @Description 优惠券表的基本增删改查
 * @author rain
 * @date 2019年2月14日
 */
public interface FavorableDao extends CrudRepository <Favorable, Serializable> {
	
}