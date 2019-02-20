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
 * @Title SysNotice.java
 * @Description 公告表实体
 * @author rain
 * @date 2019年2月14日
 */
@Entity
@Table(name = "sys_notice")
public class SysNotice implements Serializable{
	
	private static final long serialVersionUID = -7973742663832257497L;
	
	/** 公告编号 */
	private String noticeId;
	/** 公告标题 */
	private String noticeTitle;
	/** 公告内容 */
	private String noticeContent;
	/** 公告创建时间 */
	private Date createTime;
	/** 公告状态：1 生效 0 作废 */
	private int noticeStatus;

	public SysNotice() {
	}
	
	@Id
	@Column(name = "notice_id")
	public String getNoticeId() {
		return this.noticeId;
	}
	public void setNoticeId(String noticeId) {
		this.noticeId = noticeId;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time")
	public Date getCreateTime() {
		return this.createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Column(name = "notice_content")
	public String getNoticeContent() {
		return this.noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	@Column(name = "notice_status")
	public int getNoticeStatus() {
		return this.noticeStatus;
	}
	public void setNoticeStatus(int noticeStatus) {
		this.noticeStatus = noticeStatus;
	}
	@Column(name = "notice_title")

	public String getNoticeTitle() {
		return this.noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
}