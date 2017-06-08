package com.barber.server.domain.vo.input;

public class DataLogReq {
	private String monitorPeriod;//监控时间段 (yymmddHH) 
	private String monitorPeriodFrom;//监控时间段 (yymmddHH) 
	private String monitorPeriodTo;//监控时间段 (yymmddHH) 
	private String source_type;//监控log类型 (source/cdn) 多个用半角逗号分隔
	private String fileType;//文件类型 (m3u8/ts)
	private String status;//记录状态（200,206/403/404）多个用半角逗号分隔
	private Integer page;//页码
	private Integer size;//记录数
	
	
	
	public DataLogReq() {
		super();
	}
	

	public DataLogReq(String monitorPeriod, String monitorPeriodFrom, String monitorPeriodTo, String source_type,
			String fileType, String status, Integer page, Integer size) {
		super();
		this.monitorPeriod = monitorPeriod;
		this.monitorPeriodFrom = monitorPeriodFrom;
		this.monitorPeriodTo = monitorPeriodTo;
		this.source_type = source_type;
		this.fileType = fileType;
		this.status = status;
		this.page = page;
		this.size = size;
	}


	public String getMonitorPeriod() {
		return monitorPeriod;
	}
	public void setMonitorPeriod(String monitorPeriod) {
		this.monitorPeriod = monitorPeriod;
	}
	public String getMonitorPeriodFrom() {
		return monitorPeriodFrom;
	}
	public void setMonitorPeriodFrom(String monitorPeriodFrom) {
		this.monitorPeriodFrom = monitorPeriodFrom;
	}
	public String getMonitorPeriodTo() {
		return monitorPeriodTo;
	}
	public void setMonitorPeriodTo(String monitorPeriodTo) {
		this.monitorPeriodTo = monitorPeriodTo;
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


	@Override
	public String toString() {
		return "DataLogReq [monitorPeriod=" + monitorPeriod + ", monitorPeriodFrom=" + monitorPeriodFrom
				+ ", monitorPeriodTo=" + monitorPeriodTo + ", source_type=" + source_type + ", fileType=" + fileType
				+ ", status=" + status + ", page=" + page + ", size=" + size + "]";
	}
	
	

}
