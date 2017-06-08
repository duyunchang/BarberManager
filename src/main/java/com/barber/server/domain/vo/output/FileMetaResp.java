package com.barber.server.domain.vo.output;


public class FileMetaResp {
	
	private Long fileId;
	
	//文件名
	private String fileName;
	
	private String lastModifiedDate; //上传日期
	
	private Long fileLoaded;
	
	//0 初始化完成   1 上传完成   2上传没完成
	private Integer fileState;
	
	private Long fileSize;
	
	private String chunks;
	
	private String md5File;
	
	private Integer chunkSize;
	
	private Integer code;
	private String msg;
	
	public String getMd5File() {
		return md5File;
	}

	public void setMd5File(String md5File) {
		this.md5File = md5File;
	}

	public FileMetaResp() {
		super();
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Long getFileId() {
		return fileId;
	}

	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}

	public String getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(String lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	public Integer getFileState() {
		return fileState;
	}

	public void setFileState(Integer fileState) {
		this.fileState = fileState;
	}

	public Long getFileLoaded() {
		return fileLoaded;
	}

	public void setFileLoaded(Long fileLoaded) {
		this.fileLoaded = fileLoaded;
	}
	
	public String getChunks() {
		return chunks;
	}

	public void setChunks(String chunks) {
		this.chunks = chunks;
	}

	public Integer getChunkSize() {
		return chunkSize;
	}

	public void setChunkSize(Integer chunkSize) {
		this.chunkSize = chunkSize;
	}

	public Long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
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
		return "FileMetaResp [fileId=" + fileId + ", fileName=" + fileName + ", lastModifiedDate=" + lastModifiedDate
				+ ", fileLoaded=" + fileLoaded + ", fileState=" + fileState + ", fileSize=" + fileSize + ", chunks="
				+ chunks + ", md5File=" + md5File + ", chunkSize=" + chunkSize + ", code=" + code + ", msg=" + msg
				+ "]";
	}

	
}
