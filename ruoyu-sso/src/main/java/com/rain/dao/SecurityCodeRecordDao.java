package com.rain.dao;

import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;
import com.rain.bean.entity.SecurityCodeRecord;

/**
 * 
 * @Title CommodityDao.java
 * @Description 手机验证码表的基本增删改查
 * @author rain
 * @date 2019年2月14日
 */
public interface SecurityCodeRecordDao extends CrudRepository <SecurityCodeRecord, Serializable> {

}