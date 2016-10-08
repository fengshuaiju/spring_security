package com.feng.service;

import javax.servlet.http.HttpServletResponse;

import com.feng.model.wx.EventMessage;

public interface WeichatReplyService {

	/**
	 * 文本类回复
	 * @param eventMessage
	 * @param response 
	 */
	void textReply(EventMessage eventMessage, HttpServletResponse response);

	/**
	 * 默认回复，不支持的消息格式
	 * @param eventMessage 
	 * @param response
	 */
	void defaultReply(EventMessage eventMessage, HttpServletResponse response);

}
