package com.rain.dao;

import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;
import com.rain.bean.entity.OperateLog;

/**
 * 
 * @Title OperateLogDao.java
 * @Description 操作日志表的基本增删改查
 * @author rain
 * @date 2019年2月14日
 */
public interface OperateLogDao extends CrudRepository <OperateLog, Serializable> {
	
}