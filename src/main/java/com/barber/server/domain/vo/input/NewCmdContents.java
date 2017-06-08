package com.barber.server.domain.vo.input;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class NewCmdContents {
	private String cmd;
	private List<NewContents> content;
	public String getCmd() {
		return cmd;
	}
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	public List<NewContents> getContent() {
		return content;
	}
	public void setContent(List<NewContents> content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "NewCmdContents [cmd=" + cmd + ", content=" + content + "]";
	}
	

}
