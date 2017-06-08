package com.barber.server.domain.vo.output;

/**
 * 
 * @author RS
 * @date May 27, 2017
 */
public class CommResult {

	private Integer code;// 返回结果:0 成功,1 失败
	private String msg;// 返回信息
	private Object info;// 结果列表

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

	public Object getInfo() {
		return info;
	}

	public void setInfo(Object info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "CommResult [code=" + code + ", msg=" + msg + ", info=" + info
				+ "]";
	}

}
