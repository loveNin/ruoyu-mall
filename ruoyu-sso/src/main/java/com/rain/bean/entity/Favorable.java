package com.rain.bean.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 * @Title Favorable.java
 * @Description 优惠券表实体
 * @author rain
 * @date 2019年2月14日
 */
@Entity
@Table(name = "favorable")
public class Favorable implements Serializable{

	private static final long serialVersionUID = 6288380633331559223L;
	
	/** 优惠券编号 */
	private String favorableId;
	/** 优惠券名称 */
	private String favorableName;
	/** 优惠金额 */
	private BigDecimal favorableAmount;
	/** 满减金额（达到多少可用） */
	private BigDecimal reachAmount;
	/** 优惠券描述 */
	private String favorableDesc;

	public Favorable() {
	}
	
	@Id
	@Column(name = "favorable_id")
	public String getFavorableId() {
		return this.favorableId;
	}
	public void setFavorableId(String favorableId) {
		this.favorableId = favorableId;
	}
	@Column(name = "favorable_amount")
	public BigDecimal getFavorableAmount() {
		return this.favorableAmount;
	}
	public void setFavorableAmount(BigDecimal favorableAmount) {
		this.favorableAmount = favorableAmount;
	}
	@Column(name = "favorable_desc")
	public String getFavorableDesc() {
		return this.favorableDesc;
	}
	public void setFavorableDesc(String favorableDesc) {
		this.favorableDesc = favorableDesc;
	}
	@Column(name = "favorable_name")
	public String getFavorableName() {
		return this.favorableName;
	}
	public void setFavorableName(String favorableName) {
		this.favorableName = favorableName;
	}
	@Column(name = "reach_amount")
	public BigDecimal getReachAmount() {
		return this.reachAmount;
	}
	public void setReachAmount(BigDecimal reachAmount) {
		this.reachAmount = reachAmount;
	}
}