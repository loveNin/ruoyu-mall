package com.rain.bean.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 * @Title OrderDetail.java
 * @Description 订单明细表实体
 * @author rain
 * @date 2019年2月14日
 */
@Entity
@Table(name = "order_detail")
public class OrderDetail implements Serializable{
	
	private static final long serialVersionUID = 8951587629014239077L;
	
	/** 订单明细编号 */
	private String orderDetailId;
	/** 订单主表编号 */
	private String orderId;
	/** 商品编号 */
	private String commodityId;
	/** 商品数量 */
	private int commodityAmount;
	/** 商品价格 */
	private BigDecimal commodityPrice;

	public OrderDetail() {
	}
	
	@Id
	@Column(name = "order_detail_id")
	public String getOrderDetailId() {
		return this.orderDetailId;
	}
	public void setOrderDetailId(String orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	@Column(name = "commodity_amount")
	public int getCommodityAmount() {
		return this.commodityAmount;
	}
	public void setCommodityAmount(int commodityAmount) {
		this.commodityAmount = commodityAmount;
	}
	@Column(name = "commodity_id")
	public String getCommodityId() {
		return this.commodityId;
	}
	public void setCommodityId(String commodityId) {
		this.commodityId = commodityId;
	}
	@Column(name = "commodity_price")
	public BigDecimal getCommodityPrice() {
		return this.commodityPrice;
	}
	public void setCommodityPrice(BigDecimal commodityPrice) {
		this.commodityPrice = commodityPrice;
	}
	@Column(name = "order_id")
	public String getOrderId() {
		return this.orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
}