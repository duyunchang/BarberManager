package com.barber.server.domain.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7693572823945401792L;

	@Id
	@GeneratedValue
	@Column(name="id",nullable=false)
	private Long id;
	@Column(name="name")
	private String name;  //名字
	@Column(name="c_desc")
	private String c_desc;  //客户信息描述
	@Column(name="pictureaddress")
	private String pictureAddress; //图片地址
	
	
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

	
	public customer() {
		super();
	}


	public customer(String name, String c_desc, String pictureAddress) {
		super();
		this.name = name;
		this.c_desc = c_desc;
		this.pictureAddress = pictureAddress;
		this.creatTime = new Date();
		this.updateTime =  new Date();
		this.isDelete = 2;
		this.updater = "systemer";
		this.creater = "systemer";
	}


	public String getName() {
		return this.name;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getC_desc() {
		return c_desc;
	}


	public void setC_desc(String c_desc) {
		this.c_desc = c_desc;
	}


	public String getPictureAddress() {
		return pictureAddress;
	}


	public void setPictureAddress(String pictureAddress) {
		this.pictureAddress = pictureAddress;
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


	public void setName(String name) {
		this.name = name;
	}
	
	

}
