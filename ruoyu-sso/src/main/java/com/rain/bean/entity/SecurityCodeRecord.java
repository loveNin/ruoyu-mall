package com.rain.bean.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @Title SecurityCodeRecord.java
 * @Description 手机验证码表实体
 * @author rain
 * @date 2019年2月13日
 */
@Entity
@Table(name = "security_code_record")
public class SecurityCodeRecord {
	/** 手机号 */
	private String phoneNumber;
	/** 验证码 */
	private String securityCode;

	public SecurityCodeRecord() {
	}
	@Id
	@Column(name = "phone_number")
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Column(name = "security_code")
	public String getSecurityCode() {
		return securityCode;
	}
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}
}