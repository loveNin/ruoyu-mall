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
 * @Title PaymentLog.java
 * @Description 支付日志记录表实体
 * @author rain
 * @date 2019年2月14日
 */
@Entity
@Table(name = "payment_log")
public class PaymentLog implements Serializable{
	
	private static final long serialVersionUID = 401753703692884397L;
	
	/** 支付日志编号 */
	private String paymentId;
	/** 订单主表编号 */
	private String orderId;
	/** 支付金额 */
	private BigDecimal payAmount;
	/** 支付时间 */
	private Date payTime;
	/** 支付状态：1 成功支付 0 支付失败 */
	private int payStatus;

	public PaymentLog() {
	}
	
	@Id
	@Column(name = "payment_id")
	public String getPaymentId() {
		return this.paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	@Column(name = "order_id")
	public String getOrderId() {
		return this.orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	@Column(name = "pay_amount")
	public BigDecimal getPayAmount() {
		return this.payAmount;
	}
	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
	}
	@Column(name = "pay_status")
	public int getPayStatus() {
		return this.payStatus;
	}
	public void setPayStatus(int payStatus) {
		this.payStatus = payStatus;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "pay_time")
	public Date getPayTime() {
		return this.payTime;
	}
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
}