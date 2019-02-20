package com.rain.dao;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import com.rain.bean.entity.OrderDetail;

/**
 * 
 * @Title OrderDetailDao.java
 * @Description 订单明细表的基本增删改查
 * @author rain
 * @date 2019年2月14日
 */
public interface OrderDetailDao extends CrudRepository <OrderDetail, Serializable> {
	
}