package com.feng.service.impl;

import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.feng.base.BaseService;
import com.feng.model.wx.EventMessage;
import com.feng.model.wx.TuLingReply;
import com.feng.service.WeichatReplyService;
import com.feng.util.weichat.TuLingHelper;

@Service
public class WeichatReplyServiceImpl extends BaseService implements WeichatReplyService {

	@Override
	public void textReply(EventMessage eventMessage, HttpServletResponse response) {

		// 返回给服务器的信息
		String replay = "";

		String toUser = eventMessage.getFromUserName();
		String fromUser = eventMessage.getToUserName();

		String content = eventMessage.getContent();
		TuLingReply tlReply = TuLingHelper.getTlReply(content);

		if (TuLingReply.RETURN_CODE.equals(tlReply.getCode())) {
			replay = tlReply.getText();
		} else {
			replay = "服务器异常，请稍后重试！";
		}

		String returnValue = "<xml><ToUserName><![CDATA[" + toUser + "]]></ToUserName><FromUserName><![CDATA["
				+ fromUser + "]]></FromUserName><CreateTime>" + System.currentTimeMillis()
				+ "</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[" + replay + "]]></Content></xml>";

		try {
			OutputStream outputStream = response.getOutputStream();
			outputStream.write(returnValue.getBytes());
			outputStream.close();
		} catch (Exception e) {
			loger.debug(e.getMessage());
		}

	}

	@Override
	public void defaultReply(EventMessage eventMessage,HttpServletResponse response) {

		// 要封装
		// 返回给服务器的信息
		String replay = "小静不想理你，并向你扔了一只狗！！！ /::D";

		String toUser = eventMessage.getFromUserName();
		String fromUser = eventMessage.getToUserName();

		String returnValue = "<xml><ToUserName><![CDATA[" + toUser + "]]></ToUserName><FromUserName><![CDATA["
				+ fromUser + "]]></FromUserName><CreateTime>" + System.currentTimeMillis()
				+ "</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[" + replay + "]]></Content></xml>";

		try {
			OutputStream outputStream = response.getOutputStream();
			outputStream.write(returnValue.getBytes());
			outputStream.close();
		} catch (Exception e) {
			loger.debug(e.getMessage());
		}

	}

}
