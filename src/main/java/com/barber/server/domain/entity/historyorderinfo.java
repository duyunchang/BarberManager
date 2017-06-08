package com.barber.server.domain.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="historyorderinfo")
public class historyorderinfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5395980127997990813L;
	@Id
	@GeneratedValue
	@Column(name="id",nullable=false)
	private Long id;
	@Column(name="customerid")
	private Long customerId;//客户id
	@Column(name="memberid")
	private Long memberId;//会员id
	@Column(name="employeeid")
	private Long EmployeeId;//员工id
	@Column(name="serviceproductsid")
	private Long ServiceProductsId;//服务产品id
	@Column(name="currentamount")
	private Integer currentAmount;  //当前消费金额
	@Column(name="remainingamount")
	private Integer remainingAmount;  //剩余消费金额
	@Column(name="historyamount")
	private Integer historyAmount;  //历史总消费金额
	@Column(name="h_desc")
	private String h_desc;  //客户+会员+员工+服务4个对象订单详细历史记录

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

	
	public historyorderinfo() {
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


	public Long getEmployeeId() {
		return EmployeeId;
	}


	public void setEmployeeId(Long employeeId) {
		EmployeeId = employeeId;
	}


	public Long getServiceProductsId() {
		return ServiceProductsId;
	}


	public void setServiceProductsId(Long serviceProductsId) {
		ServiceProductsId = serviceProductsId;
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

	public String getH_desc() {
		return h_desc;
	}


	public void setH_desc(String h_desc) {
		this.h_desc = h_desc;
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
