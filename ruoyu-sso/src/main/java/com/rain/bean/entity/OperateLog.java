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
 * @Title OperateLog.java
 * @Description 操作日志表实体
 * @author rain
 * @date 2019年2月14日
 */
@Entity
@Table(name = "operate_log")
public class OperateLog implements Serializable{
	
	private static final long serialVersionUID = -5582238294022240348L;
	
	/** 操作日志编号 */
	private String operateId;
	/** 数据内容 */
	private String dataContent;
	/** 操作时间 */
	private Date operateTime;
	/** 操作表名 */
	private String operateTable;
	/** 操作类型：1 新增 2 修改 3 删除 */
	private int operateType;

	public OperateLog() {
	}
	
	@Id
	@Column(name = "operate_id")
	public String getOperateId() {
		return this.operateId;
	}
	public void setOperateId(String operateId) {
		this.operateId = operateId;
	}
	@Column(name = "data_content")
	public String getDataContent() {
		return this.dataContent;
	}
	public void setDataContent(String dataContent) {
		this.dataContent = dataContent;
	}
	@Column(name = "operate_table")
	public String getOperateTable() {
		return this.operateTable;
	}
	public void setOperateTable(String operateTable) {
		this.operateTable = operateTable;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "operate_time")
	public Date getOperateTime() {
		return this.operateTime;
	}
	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}
	@Column(name = "operate_type")
	public int getOperateType() {
		return this.operateType;
	}
	public void setOperateType(int operateType) {
		this.operateType = operateType;
	}
}