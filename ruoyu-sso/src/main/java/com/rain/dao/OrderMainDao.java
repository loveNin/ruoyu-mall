package com.rain.dao;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import com.rain.bean.entity.OrderMain;

/**
 * 
 * @Title OrderMainDao.java
 * @Description 订单主表的基本增删改查
 * @author rain
 * @date 2019年2月14日
 */
public interface OrderMainDao extends CrudRepository <OrderMain, Serializable> {
	
}