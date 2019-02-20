package com.rain.bean.dto;

/**
 * 
 * @Title SysUserLoginDTO.java
 * @Description 用户登录参数实体
 * @author rain
 * @date 2019年2月14日
 */
public class SysUserLoginDTO {
	/** 用户名（登陆名）、手机号码、邮箱地址 */
	private String userName;
	/** 用户密码 */
	private String password;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}