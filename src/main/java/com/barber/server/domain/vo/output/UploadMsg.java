package com.barber.server.domain.vo.output;

public class UploadMsg {
	private Integer code;
	private String msg;
	private Object info;
	
	
	public Object getInfo() {
		return info;
	}
	public void setInfo(Object info) {
		this.info = info;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "UploadMsg [code=" + code + ", msg=" + msg + ", info=" + info
				+ "]";
	}
}
