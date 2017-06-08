package com.barber.server.domain.vo.input;

/**
 * 
 * @author RS
 * @date May 27, 2017
 */
public class ResourceInfoReq {

	private String bgPicUp;
	private String infoUp;
	private String infDown;
	private String bgPicDown;
	private Integer activityResources;

	public String getBgPicUp() {
		return bgPicUp;
	}

	public void setBgPicUp(String bgPicUp) {
		this.bgPicUp = bgPicUp;
	}

	public String getInfoUp() {
		return infoUp;
	}

	public void setInfoUp(String infoUp) {
		this.infoUp = infoUp;
	}

	public String getInfDown() {
		return infDown;
	}

	public void setInfDown(String infDown) {
		this.infDown = infDown;
	}

	public String getBgPicDown() {
		return bgPicDown;
	}

	public void setBgPicDown(String bgPicDown) {
		this.bgPicDown = bgPicDown;
	}

	public Integer getActivityResources() {
		return activityResources;
	}

	public void setActivityResources(Integer activityResources) {
		this.activityResources = activityResources;
	}

	@Override
	public String toString() {
		return "ResourceInfoReq [bgPicUp=" + bgPicUp + ", infoUp=" + infoUp
				+ ", infDown=" + infDown + ", bgPicDown=" + bgPicDown
				+ ", activityResources=" + activityResources + "]";
	}

}
