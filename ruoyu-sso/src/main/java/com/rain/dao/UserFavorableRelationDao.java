package com.rain.dao;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import com.rain.bean.entity.UserFavorableRelation;

/**
 * 
 * @Title UserFavorableRelationDao.java
 * @Description 用户优惠券关系表的基本增删改查
 * @author rain
 * @date 2019年2月14日
 */
public interface UserFavorableRelationDao extends CrudRepository <UserFavorableRelation, Serializable> {
	
}