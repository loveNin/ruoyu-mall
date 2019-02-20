package com.rain.dao;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import com.rain.bean.entity.PaymentLog;

/**
 * 
 * @Title PaymentLogDao.java
 * @Description 支付日志表的基本增删改查
 * @author rain
 * @date 2019年2月14日
 */
public interface PaymentLogDao extends CrudRepository <PaymentLog, Serializable> {
	
}