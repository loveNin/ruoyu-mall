package com.rain.dao;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import com.rain.bean.entity.SysNotice;

/**
 * 
 * @Title SysNoticeDao.java
 * @Description 系统公告表的基本增删改查
 * @author rain
 * @date 2019年2月14日
 */
public interface SysNoticeDao extends CrudRepository <SysNotice, Serializable> {
	
}