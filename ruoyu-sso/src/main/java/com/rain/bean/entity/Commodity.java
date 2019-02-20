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
 * @Title Commodity.java
 * @Description 商品表实体
 * @author rain
 * @date 2019年2月14日
 */
@Entity
@Table(name = "commodity")
public class Commodity implements Serializable{
	
	private static final long serialVersionUID = 7557855563427656514L;
	
	/** 商品编号 */
	private String commodityId;
	/** 商品名称 */
	private String commodityName;
	/** 类别编号 */
	private String categoryId;
	/** 商品图片 */
	private String commodityImage;
	/** 商品描述 */
	private String commodityDesc;
	/** 市场价格 */
	private BigDecimal marketPrice;
	/** 商城价格 */
	private BigDecimal mallPrice;
	/** 上架时间 */
	private Date launchTime;
	/** 是否下架：1 已下架 0 未下架 */
	private int isRemove;
	/** 是否热门：1 热门 0 不热门 */
	private int isPopular;
	
	public Commodity() {
	}
	
	@Id
	@Column(name = "commodity_id")
	public String getCommodityId() {
		return commodityId;
	}
	@Column(name = "category_id")
	public String getCategoryId() {
		return categoryId;
	}
	@Column(name = "commodity_desc")
	public String getCommodityDesc() {
		return commodityDesc;
	}
	@Column(name = "commodity_image")
	public String getCommodityImage() {
		return commodityImage;
	}
	@Column(name = "commodity_name")
	public String getCommodityName() {
		return commodityName;
	}
	@Column(name = "is_popular")
	public int getIsPopular() {
		return isPopular;
	}
	@Column(name = "is_remove")
	public int getIsRemove() {
		return isRemove;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "launch_time")
	public Date getLaunchTime() {
		return launchTime;
	}
	@Column(name = "mall_price")
	public BigDecimal getMallPrice() {
		return mallPrice;
	}
	@Column(name = "market_price")
	public BigDecimal getMarketPrice() {
		return marketPrice;
	}
	public void setCommodityId(String commodityId) {
		this.commodityId = commodityId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public void setCommodityDesc(String commodityDesc) {
		this.commodityDesc = commodityDesc;
	}
	public void setCommodityImage(String commodityImage) {
		this.commodityImage = commodityImage;
	}
	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}
	public void setIsPopular(int isPopular) {
		this.isPopular = isPopular;
	}
	public void setIsRemove(int isRemove) {
		this.isRemove = isRemove;
	}
	public void setLaunchTime(Date launchTime) {
		this.launchTime = launchTime;
	}
	public void setMallPrice(BigDecimal mallPrice) {
		this.mallPrice = mallPrice;
	}
	public void setMarketPrice(BigDecimal marketPrice) {
		this.marketPrice = marketPrice;
	}
}