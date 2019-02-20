package com.rain.bean.entity;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * 
 * @Title SysUser.java
 * @Description 用户表实体
 * @author rain
 * @date 2019年2月14日
 */
@Entity
@Table(name = "sys_user")
public class SysUser implements Serializable{
	
	private static final long serialVersionUID = 6227136873986605560L;
	
	/** 用户编号 */
	private String userId;
	/** 用户名（登陆名） */
	private String userName;
	/** 用户密码 */
	private String password;
	/** 用户昵称 */
	private String userNick;
	/** 手机号码 */
	private String phoneNumber;
	/** 邮箱地址 */
	private String email;
	/** 真实姓名 */
	private String realName;
	/** 性别：1 男 2 女 3 其他 */
	private Integer sex;
	/** 身份证号码 */
	private String idCard;
	/** 出生日期 */
	private Date birthday;
	/** 头像地址 */
	private String headPhoto;
	/** 创建时间 */
	private Date createTime;
	/** 是否管理员：1 是 0 否 */
	private int isAdmin;
	/** 用户账号状态：1 启用 0 未用 */
	private int userStatus;
	/** 用户令牌 */
	private String token;

	public SysUser() {
	}
	
	@Id
	@Column(name = "user_id")
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "birthday")
	public Date getBirthday() {
		return this.birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time")
	public Date getCreateTime() {
		return this.createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Column(name = "email")
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name = "head_photo")
	public String getHeadPhoto() {
		return this.headPhoto;
	}
	public void setHeadPhoto(String headPhoto) {
		this.headPhoto = headPhoto;
	}
	@Column(name = "id_card")
	public String getIdCard() {
		return this.idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	@Column(name = "is_admin")
	public int getIsAdmin() {
		return this.isAdmin;
	}
	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}
	@Column(name = "password")
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name = "phone_number")
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Column(name = "real_name")
	public String getRealName() {
		return this.realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	@Column(name = "sex")
	public Integer getSex() {
		return this.sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	@Column(name = "token")
	public String getToken() {
		return this.token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Column(name = "user_name")
	public String getUserName() {
		return this.userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Column(name = "user_nick")
	public String getUserNick() {
		return this.userNick;
	}
	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}
	@Column(name = "user_status")
	public int getUserStatus() {
		return this.userStatus;
	}
	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}
}