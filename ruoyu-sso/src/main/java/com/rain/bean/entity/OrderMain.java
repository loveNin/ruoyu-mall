package com.rain.bean.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * 
 * @Title OrderMain.java
 * @Description 订单主表实体
 * @author rain
 * @date 2019年2月14日
 */
@Entity
@Table(name = "order_main")
public class OrderMain implements Serializable{
	
	private static final long serialVersionUID = -8923390727226360668L;
	
	/** 订单编号 */
	private String orderId;
	/** 订单时间 */
	private Date orderTime;
	/** 订单原价总额 */
	private BigDecimal totalAmount;
	/** 订单支付金额 */
	private BigDecimal orderAmount;
	/** 优惠券编号 */
	private String favorableId;
	/** 收货人名称 */
	private String consigneeName;
	/** 收货人电话 */
	private String consigneePhone;
	/** 收货人地址 */
	private String consigneeAddress;
	/** 订单状态：10 未支付 20 已支付 30 配送中 40 已收货 */
	private int orderStatus;
	/** 快递单号 */
	private String deliveryNum;
	/** 订单创建人编号 */
	private String createUserId;

	public OrderMain() {
	}
	
	@Id
	@Column(name = "order_id")
	public String getOrderId() {
		return this.orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	@Column(name = "consignee_address")
	public String getConsigneeAddress() {
		return this.consigneeAddress;
	}
	public void setConsigneeAddress(String consigneeAddress) {
		this.consigneeAddress = consigneeAddress;
	}
	@Column(name = "consignee_name")
	public String getConsigneeName() {
		return this.consigneeName;
	}
	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}
	@Column(name = "consignee_phone")
	public String getConsigneePhone() {
		return this.consigneePhone;
	}
	public void setConsigneePhone(String consigneePhone) {
		this.consigneePhone = consigneePhone;
	}
	@Column(name = "create_user_id")
	public String getCreateUserId() {
		return this.createUserId;
	}
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}
	@Column(name = "delivery_num")
	public String getDeliveryNum() {
		return this.deliveryNum;
	}
	public void setDeliveryNum(String deliveryNum) {
		this.deliveryNum = deliveryNum;
	}
	@Column(name = "favorable_id")
	public String getFavorableId() {
		return this.favorableId;
	}
	public void setFavorableId(String favorableId) {
		this.favorableId = favorableId;
	}
	@Column(name = "order_amount")
	public BigDecimal getOrderAmount() {
		return this.orderAmount;
	}
	public void setOrderAmount(BigDecimal orderAmount) {
		this.orderAmount = orderAmount;
	}
	@Column(name = "order_status")
	public int getOrderStatus() {
		return this.orderStatus;
	}
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "order_time")
	public Date getOrderTime() {
		return this.orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	@Column(name = "total_amount")
	public BigDecimal getTotalAmount() {
		return this.totalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
}