package com.barber.server.domain.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="memberinfo")
public class memberinfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4085889294843756463L;
	@Id
	@GeneratedValue
	@Column(name="id",nullable=false)
	private Long id;
	@Column(name="name")
	private String name;  //名字
	@Column(name="m_desc")
	private String m_desc;  //会员信息描述
	@Column(name="level")
	private Integer level;  //会员级别
	@Column(name="levelintegral")
	private Long levelIntegral;//会员积分
	@Column(name="levelprice")
	private Integer levelPrice;  // 商品价格
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

	
	public memberinfo() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public String getM_desc() {
		return m_desc;
	}


	public void setM_desc(String m_desc) {
		this.m_desc = m_desc;
	}


	public Integer getLevel() {
		return level;
	}


	public void setLevel(Integer level) {
		this.level = level;
	}


	public Long getLevelIntegral() {
		return levelIntegral;
	}


	public void setLevelIntegral(Long levelIntegral) {
		this.levelIntegral = levelIntegral;
	}


	public Integer getLevelPrice() {
		return levelPrice;
	}


	public void setLevelPrice(Integer levelPrice) {
		this.levelPrice = levelPrice;
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


}
