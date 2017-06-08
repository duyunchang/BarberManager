package com.barber.server.domain.vo.output;

public class ResultProxy {
	
	private Integer code;//返回结果，0表示成功
	private String msg;//返回信息
	
	private String monitorPeriod;//监控时间段(范围查询时用半角逗号分隔)
	private String source_type;//监控log类型 (source/cdn)
	private String fileType;//文件类型 (m3u8/ts)
	private String status;//记录状态（200,206/403/404）多个用半角逗号分隔
	private Integer page;//当前页数
	private Integer size;//每页条数
	
	
	private Object data;//结果列表
	public ResultProxy(){}
	
	
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


	public String getMonitorPeriod() {
		return monitorPeriod;
	}


	public void setMonitorPeriod(String monitorPeriod) {
		this.monitorPeriod = monitorPeriod;
	}


	public String getSource_type() {
		return source_type;
	}


	public void setSource_type(String source_type) {
		this.source_type = source_type;
	}


	public String getFileType() {
		return fileType;
	}


	public void setFileType(String fileType) {
		this.fileType = fileType;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Integer getPage() {
		return page;
	}


	public void setPage(Integer page) {
		this.page = page;
	}


	public Integer getSize() {
		return size;
	}


	public void setSize(Integer size) {
		this.size = size;
	}


	public Object getData() {
		return data;
	}


	public void setData(Object data) {
		this.data = data;
	}


	@Override
	public String toString() {
		return "ResultProxy [code=" + code + ", msg=" + msg + ", monitorPeriod=" + monitorPeriod + ", source_type="
				+ source_type + ", fileType=" + fileType + ", status=" + status + ", page=" + page + ", size=" + size
				 + "]";
	}


}
