package com.barber.server.domain.vo.input;

public class UploadFileMetaReq {
	private String fileName;
	private String extName;
	private Long fileSize;
	private String md5File;
	private String comeFrom;
	private Integer chunkSize;
	private String contentBody;
	private String image;
	private String partnerCode;
	
	private Integer pageIndex;
	private Integer pageSize;
	private Integer fileState;
	private String uploader;
	private String uploadTimeThan;
	private String uploadTimeLess;
	private Integer fileId;
	private Integer fileUseState;
	
	private String resourcesGroupCode;
	
	public UploadFileMetaReq() {
		super();
	}
	
	
	public UploadFileMetaReq(String fileName, Long fileSize, String md5File, String comeFrom, String uploader) {
		super();
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.md5File = md5File;
		this.comeFrom = comeFrom;
		this.uploader = uploader;
	}


	public String getResourcesGroupCode() {
		return resourcesGroupCode;
	}


	public void setResourcesGroupCode(String resourcesGroupCode) {
		this.resourcesGroupCode = resourcesGroupCode;
	}


	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getExtName() {
		return extName;
	}
	public void setExtName(String extName) {
		this.extName = extName;
	}

	public Long getFileSize() {
		return fileSize;
	}
	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}
	public String getMd5File() {
		return md5File;
	}
	public void setMd5File(String md5File) {
		this.md5File = md5File;
	}
	public Integer getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getFileState() {
		return fileState;
	}
	public void setFileState(Integer fileState) {
		this.fileState = fileState;
	}
	public String getUploader() {
		return uploader;
	}
	public void setUploader(String uploader) {
		this.uploader = uploader;
	}
	public String getUploadTimeThan() {
		return uploadTimeThan;
	}
	public void setUploadTimeThan(String uploadTimeThan) {
		this.uploadTimeThan = uploadTimeThan;
	}
	public String getUploadTimeLess() {
		return uploadTimeLess;
	}
	public void setUploadTimeLess(String uploadTimeLess) {
		this.uploadTimeLess = uploadTimeLess;
	}
	public Integer getFileId() {
		return fileId;
	}
	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}
	public Integer getFileUseState() {
		return fileUseState;
	}
	public void setFileUseState(Integer fileUseState) {
		this.fileUseState = fileUseState;
	}
	
	public String getComeFrom() {
		return comeFrom;
	}
	public void setComeFrom(String comeFrom) {
		this.comeFrom = comeFrom;
	}
	
	public Integer getChunkSize() {
		return chunkSize;
	}
	public void setChunkSize(Integer chunkSize) {
		this.chunkSize = chunkSize;
	}
	
	
	public String getContentBody() {
		return contentBody;
	}
	public void setContentBody(String contentBody) {
		this.contentBody = contentBody;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getPartnerCode() {
		return partnerCode;
	}
	public void setPartnerCode(String partnerCode) {
		this.partnerCode = partnerCode;
	}


	@Override
	public String toString() {
		return "UploadFileMetaReq [fileName=" + fileName + ", extName=" + extName + ", fileSize=" + fileSize
				+ ", md5File=" + md5File + ", comeFrom=" + comeFrom + ", chunkSize=" + chunkSize + ", contentBody="
				+ contentBody + ", image=" + image + ", partnerCode=" + partnerCode + ", pageIndex=" + pageIndex
				+ ", pageSize=" + pageSize + ", fileState=" + fileState + ", uploader=" + uploader + ", uploadTimeThan="
				+ uploadTimeThan + ", uploadTimeLess=" + uploadTimeLess + ", fileId=" + fileId + ", fileUseState="
				+ fileUseState + ", resourcesGroupCode=" + resourcesGroupCode + "]";
	}



	
	
}
