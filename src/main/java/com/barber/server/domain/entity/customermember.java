package com.barber.server.domain.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="customermember")
public class customermember implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2170658441197505263L;
	@Id
	@GeneratedValue
	@Column(name="id",nullable=false)
	private Long id;
	@Column(name="customerid")
	private Long customerId;  //客户id
	@Column(name="memberid")
	private Long memberId;  //会员id
	@Column(name="currentamount")
	private Integer currentAmount;  //当前金额
	@Column(name="remainingamount")
	private Integer remainingAmount;  //剩余金额
	@Column(name="historyamount")
	private Integer historyAmount;  //历史总消费金额
	
	@Column(name="creattime")
	private Date creatTime;   //创建时间
	@Column(name="updatetime")
	private Date updateTime;  //更新时间	
	@Column(name="isdelete")
	private Integer isDelete;  //是否删除;1删除,2未删除
	@Column(name="updater")
	private String updater;   //更新人
	@Column(name="creater")
	private String creater;   //创建人

	
	public customermember() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}


	public Long getMemberId() {
		return memberId;
	}


	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}


	public Integer getCurrentAmount() {
		return currentAmount;
	}


	public void setCurrentAmount(Integer currentAmount) {
		this.currentAmount = currentAmount;
	}


	public Integer getRemainingAmount() {
		return remainingAmount;
	}


	public void setRemainingAmount(Integer remainingAmount) {
		this.remainingAmount = remainingAmount;
	}


	public Integer getHistoryAmount() {
		return historyAmount;
	}


	public void setHistoryAmount(Integer historyAmount) {
		this.historyAmount = historyAmount;
	}


	public Date getCreatTime() {
		return creatTime;
	}


	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}


	public Date getUpdateTime() {
		return updateTime;
	}


	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}


	public Integer getIsDelete() {
		return isDelete;
	}


	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}


	public String getUpdater() {
		return updater;
	}


	public void setUpdater(String updater) {
		this.updater = updater;
	}


	public String getCreater() {
		return creater;
	}


	public void setCreater(String creater) {
		this.creater = creater;
	}



}
