package com.rain.bean.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 * @Title UserFavorableRelation.java
 * @Description 用户优惠券关系表实体
 * @author rain
 * @date 2019年2月14日
 */
@Entity
@Table(name = "user_favorable_relation")
public class UserFavorableRelation implements Serializable{
	
	private static final long serialVersionUID = -932706309845105630L;
	
	/** 主键编号 */
	private String relationId;
	/** 用户编号 */
	private String userId;
	/** 优惠券编号 */
	private String favorableId;
	/** 优惠券数量 */
	private int favorableTotal;

	public UserFavorableRelation() {
	}
	
	@Id
	@Column(name = "relation_id")
	public String getRelationId() {
		return this.relationId;
	}
	public void setRelationId(String relationId) {
		this.relationId = relationId;
	}
	@Column(name = "favorable_id")
	public String getFavorableId() {
		return this.favorableId;
	}
	public void setFavorableId(String favorableId) {
		this.favorableId = favorableId;
	}
	@Column(name = "favorable_total")
	public int getFavorableTotal() {
		return this.favorableTotal;
	}
	public void setFavorableTotal(int favorableTotal) {
		this.favorableTotal = favorableTotal;
	}
	@Column(name = "user_id")
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}