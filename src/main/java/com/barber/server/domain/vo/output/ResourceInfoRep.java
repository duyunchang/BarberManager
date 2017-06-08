package com.barber.server.domain.vo.output;

/**
 * 
 * @author RS
 * @date May 27, 2017
 */
public class ResourceInfoRep {

	private String backImageUp;
	private Object adData1;
	private Object adData2;
	private String backImageDown;

	public String getBackImageUp() {
		return backImageUp;
	}

	public void setBackImageUp(String backImageUp) {
		this.backImageUp = backImageUp;
	}

	public Object getAdData1() {
		return adData1;
	}

	public void setAdData1(Object adData1) {
		this.adData1 = adData1;
	}

	public Object getAdData2() {
		return adData2;
	}

	public void setAdData2(Object adData2) {
		this.adData2 = adData2;
	}

	public String getBackImageDown() {
		return backImageDown;
	}

	public void setBackImageDown(String backImageDown) {
		this.backImageDown = backImageDown;
	}

	@Override
	public String toString() {
		return "ResourceInfoRep [backImageUp=" + backImageUp + ", adData1="
				+ adData1 + ", adData2=" + adData2 + ", backImageDown="
				+ backImageDown + "]";
	}

}
