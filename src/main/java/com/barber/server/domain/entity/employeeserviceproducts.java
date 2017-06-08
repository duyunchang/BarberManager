package com.barber.server.domain.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="employeeserviceproducts")
public class employeeserviceproducts implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3626239695933530349L;
	@Id
	@GeneratedValue
	@Column(name="id",nullable=false)
	private Long id;
	@Column(name="employeeid")
	private Long EmployeeId;//员工id
	@Column(name="serviceproductsid")
	private Long ServiceProductsId;//服务产品id
	@Column(name="currentnumber")
	private Integer currentNumber;  //当前理发数
	@Column(name="historynumber")
	private Integer historyNumber;  //历史理发数
	
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

	
	public employeeserviceproducts() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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


	public Integer getCurrentNumber() {
		return currentNumber;
	}


	public void setCurrentNumber(Integer currentNumber) {
		this.currentNumber = currentNumber;
	}


	public Integer getHistoryNumber() {
		return historyNumber;
	}


	public void setHistoryNumber(Integer historyNumber) {
		this.historyNumber = historyNumber;
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
