package com.barber.server.domain.vo.input;

import java.util.Date;

public class ComResourcesParamsReq {

	private String resourcesGroupCode;// 资源组编号uuid

	private String resourcesName;// 资源组编号

	private String bakBgPicUp;// 备背景图上

	private String bakBgPicDown;// 备背景图下

	private String mainBgPicDown;// 备背景图上

	private String mainBgPicUp;// 备背景图下

	private String mainInfoUp;// 主资源上

	private String mainInfoDown;// 主资源下

	private String bakInfoUp;// 备用资源上

	private String bakInfoDown;// 备用资源下

	private String newsContent;// 新闻内容

	private Integer activityResources;// 启用资源 1：正式资源 2：备用资源

	private String liveUrl;// 直播推送url

	private Integer liveStatus;// 直播推送状态 1:推送中 2:停止推送

	private Integer livePos;// 直播推送位置 1:up 2:down

	private Integer status;// '状态，1可用，2不可用',

	private Integer isDelete;// '是否删除，1上线，2离线，3报障',

	private String creater;// 创建人

	private Date createTime;// 创建时间

	private String updater;// 更新人

	private Date updateTime;// 更新时间

	private String cmd;//内容
	private String deviceCode;//sn设备号
	
	private String time;//时间
	
	public ComResourcesParamsReq() {
		super();
	}
	
	
	//livePush
	public ComResourcesParamsReq(String resourcesGroupCode, String liveUrl, Integer liveStatus, Integer livePos,
			String updater, Date updateTime) {
		super();
		this.resourcesGroupCode = resourcesGroupCode;
		this.liveUrl = liveUrl;
		this.liveStatus = liveStatus;
		this.livePos = livePos;
		this.updater = updater;
		this.updateTime = updateTime;
		
	}


    //roll news public
	public ComResourcesParamsReq(String resourcesGroupCode, String newsContent, String updater, Date updateTime,String cmd,String deviceCode) {
		super();
		this.resourcesGroupCode = resourcesGroupCode;
		this.newsContent = newsContent;
		this.updater = updater;
		this.updateTime = updateTime;
		
		this.cmd = cmd;
		this.deviceCode = deviceCode;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public String getCmd() {
		return cmd;
	}


	public void setCmd(String cmd) {
		this.cmd = cmd;
	}


	public String getDeviceCode() {
		return deviceCode;
	}


	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}


	public Integer getActivityResources() {
		return activityResources;
	}

	public void setActivityResources(Integer activityResources) {
		this.activityResources = activityResources;
	}

	public String getResourcesGroupCode() {
		return resourcesGroupCode;
	}

	public void setResourcesGroupCode(String resourcesGroupCode) {
		this.resourcesGroupCode = resourcesGroupCode;
	}

	public String getResourcesName() {
		return resourcesName;
	}

	public void setResourcesName(String resourcesName) {
		this.resourcesName = resourcesName;
	}

	public String getBakBgPicUp() {
		return bakBgPicUp;
	}

	public void setBakBgPicUp(String bakBgPicUp) {
		this.bakBgPicUp = bakBgPicUp;
	}

	public String getBakBgPicDown() {
		return bakBgPicDown;
	}

	public void setBakBgPicDown(String bakBgPicDown) {
		this.bakBgPicDown = bakBgPicDown;
	}

	public String getMainBgPicDown() {
		return mainBgPicDown;
	}

	public void setMainBgPicDown(String mainBgPicDown) {
		this.mainBgPicDown = mainBgPicDown;
	}

	public String getMainBgPicUp() {
		return mainBgPicUp;
	}

	public void setMainBgPicUp(String mainBgPicUp) {
		this.mainBgPicUp = mainBgPicUp;
	}

	public String getMainInfoUp() {
		return mainInfoUp;
	}

	public void setMainInfoUp(String mainInfoUp) {
		this.mainInfoUp = mainInfoUp;
	}

	public String getMainInfoDown() {
		return mainInfoDown;
	}

	public void setMainInfoDown(String mainInfoDown) {
		this.mainInfoDown = mainInfoDown;
	}

	public String getBakInfoUp() {
		return bakInfoUp;
	}

	public void setBakInfoUp(String bakInfoUp) {
		this.bakInfoUp = bakInfoUp;
	}

	public String getBakInfoDown() {
		return bakInfoDown;
	}

	public void setBakInfoDown(String bakInfoDown) {
		this.bakInfoDown = bakInfoDown;
	}

	public String getNewsContent() {
		return newsContent;
	}

	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}

	public String getLiveUrl() {
		return liveUrl;
	}

	public void setLiveUrl(String liveUrl) {
		this.liveUrl = liveUrl;
	}

	public Integer getLiveStatus() {
		return liveStatus;
	}

	public void setLiveStatus(Integer liveStatus) {
		this.liveStatus = liveStatus;
	}

	public Integer getLivePos() {
		return livePos;
	}

	public void setLivePos(Integer livePos) {
		this.livePos = livePos;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdater() {
		return updater;
	}

	public void setUpdater(String updater) {
		this.updater = updater;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}


	@Override
	public String toString() {
		return "ComResourcesParamsReq [resourcesGroupCode=" + resourcesGroupCode + ", resourcesName=" + resourcesName
				+ ", bakBgPicUp=" + bakBgPicUp + ", bakBgPicDown=" + bakBgPicDown + ", mainBgPicDown=" + mainBgPicDown
				+ ", mainBgPicUp=" + mainBgPicUp + ", mainInfoUp=" + mainInfoUp + ", mainInfoDown=" + mainInfoDown
				+ ", bakInfoUp=" + bakInfoUp + ", bakInfoDown=" + bakInfoDown + ", newsContent=" + newsContent
				+ ", activityResources=" + activityResources + ", liveUrl=" + liveUrl + ", liveStatus=" + liveStatus
				+ ", livePos=" + livePos + ", status=" + status + ", isDelete=" + isDelete + ", creater=" + creater
				+ ", createTime=" + createTime + ", updater=" + updater + ", updateTime=" + updateTime + ", cmd=" + cmd
				+ ", deviceCode=" + deviceCode + "]";
	}

	

}
