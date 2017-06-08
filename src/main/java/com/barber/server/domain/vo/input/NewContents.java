package com.barber.server.domain.vo.input;

import org.springframework.stereotype.Component;

@Component
public class NewContents {
	private String title;
	private String info;
	private String time;
	
	
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "NewContents [title=" + title + ", info=" + info + "]";
	}
	
}
