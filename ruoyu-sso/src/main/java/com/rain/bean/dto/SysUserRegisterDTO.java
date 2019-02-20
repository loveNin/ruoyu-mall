package com.rain.bean.dto;

/**
 * 
 * @Title SysUserRegisterDTO.java
 * @Description 用户注册参数实体
 * @author rain
 * @date 2019年2月14日
 */
public class SysUserRegisterDTO {
	/** 用户名（登陆名） */
	private String userName;
	/** 用户密码 */
	private String password;
	/** 手机号码 */
	private String phoneNumber;
	/** 邮箱 */
	private String email;
	/** 手机验证码 */
	private String securityCode;
	
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getSecurityCode() {
		return securityCode;
	}
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}