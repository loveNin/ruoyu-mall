package com.rain.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.rain.bean.entity.SysUser;

/**
 * 
 * @Title SysUserDao.java
 * @Description 系统用户表的基本增删改查
 * @author rain
 * @date 2019年2月14日
 */
public interface SysUserDao extends CrudRepository <SysUser, Serializable> {
	/**
	 * 根据用户名/手机号/邮箱和密码查询用户
	 * @param userName 用户名/手机号/邮箱
	 * @param password 密码
	 * @return
	 */
	//@Query(value = " select * from SysUser t where (t.userName=?1 or phoneNumber=?1 ) and password=?2 ", nativeQuery = true)
	@Query(" from SysUser where ( userName=?1 or phoneNumber=?1 or email=?1 ) and password=?2 ")
	SysUser findByNameAndPassword(String userName, String password);
	
	/**
	 * 单点登录令牌查询用户
	 * @param token 令牌
	 * @return
	 */
	@Query(" from SysUser where token=?1 ")
	SysUser findByToken(String token);
	
	/**
	 * 根据用户名查询用户
	 * @param userName
	 * @return
	 */
	@Query(" from SysUser where userName=?1 ")
	SysUser findByUserName(String userName);
	
	/**
	 * 根据手机号码查询用户
	 * @param phoneNumber
	 * @return
	 */
	@Query(" from SysUser where phoneNumber=?1 ")
	SysUser findByPhoneNumber(String phoneNumber);
	
	/**
	 * 根据邮箱查找用户
	 * @param email
	 * @return
	 */
	@Query(" from SysUser where mail=?1 ")
	SysUser findByEmail(String email);
	
	/**
	 * 根据userId修改token
	 * @param userId 用户编号
	 * @param token 令牌
	 */
	@Modifying
	@Query(" update SysUser set token=?2 where userId=?1 ")
	void updateTokenByUserId(String userId, String token);
}