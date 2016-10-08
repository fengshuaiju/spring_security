package com.feng.model.wx;

import java.util.HashSet;
import java.util.Set;

public class ReplayTextMessage {
	
	private String msgtype = "text";
	private MessageText text;
	private Set<String> touser = new HashSet<>();
	public String getMsgtype() {
		return msgtype;
	}
	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}
	public Set<String> getTouser() {
		return touser;
	}
	public void setTouser(Set<String> touser) {
		this.touser = touser;
	}
	public MessageText getText() {
		return text;
	}
	public void setText(MessageText text) {
		this.text = text;
	}


	public static class MessageText{
		private String content;
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
	}
}
