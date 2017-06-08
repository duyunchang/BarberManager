package com.barber.server.domain.vo.output;

public class UploadChunkMsg extends UploadMsg{
	private Long fileId;
	private int chunk;
	public Long getFileId() {
		return fileId;
	}
	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}
	public int getChunk() {
		return chunk;
	}
	public void setChunk(int chunk) {
		this.chunk = chunk;
	}
	
}
