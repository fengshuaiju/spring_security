package com.feng.util.weichat;

import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;

import com.alibaba.fastjson.JSON;
import com.feng.base.BaseComponent;
import com.feng.model.wx.WechatToken;
import com.feng.model.wx.WechatUserInfo;
import com.github.kevinsawicki.http.HttpRequest;

/**
 * 系统与微信服务器交互助手
 * @author Administrator
 *
 */
public class WechatRequestHelper extends BaseComponent{
	//osHNcwZkECtWUBNaYJTd7mKn_3Eg
	//用来存储token信息
	private static WechatToken token = null;
	
	//AppId sercet
	String appID = "wxd5862fe4b5068c5d";
	String appsecret = "ff985e2b30b9d7b37ed9bd9556a368bc";
	
	// 获取公众号Tokenhttp请求方式: GET
	// https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET
	private static final String getAccessTokenBaseUrl = "https://api.weixin.qq.com/cgi-bin/token";

	//获取用户基本信息	http请求方式: GET
	//https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN
	private static final String getUserInfoBaseUrl = "https://api.weixin.qq.com/cgi-bin/user/info";

	
	
	
	//获取公众号Token
	public String getToken(){
		String accessToken = "";
		
		//如果token未获取或者是失效，那么就获取token
		if(token==null || token.getExpiresTimeMillis() > DateTime.now().getMillis()){
			token = new WechatToken();
			Map<String, String> params = new HashMap<>();
			params.put("grant_type", "client_credential");
			params.put("appid", appID);
			params.put("secret", appsecret);
			String returnRequest = HttpRequest.get(getAccessTokenBaseUrl, params, false).body();
			
			token = JSON.parseObject(returnRequest, WechatToken.class);
			token.setObtainTimeMillis(DateTime.now().getMillis());
			token.setExpiresTimeMillis(DateTime.now().plusMinutes(90).getMillis());
		}
		
		accessToken = token.getAccess_token();
		
		return accessToken;
	}
	
	
	//获取微信用户信息
	public WechatUserInfo getWechatUserInfo(String accessToken,String openId){
		
		WechatUserInfo info = new WechatUserInfo();
		
		Map<String, String> params = new HashMap<>();
		params.put("lang", "zh_CN");
		params.put("access_token", accessToken);
		params.put("openid", openId);
		
		String returnRequest = HttpRequest.get(getUserInfoBaseUrl, params, false).body();
		
		info = JSON.parseObject(returnRequest, WechatUserInfo.class);
		
		System.out.println(JSON.toJSONString(info));
		loger.debug(JSON.toJSONString(info));
		
		return info;
	}
	
	
//	public static void main(String[] args) {
//		String openId = "osHNcwZkECtWUBNaYJTd7mKn_3Eg";
//		
//		WechatRequestHelper help = new WechatRequestHelper();
//		String access_token = help.getToken();
//		WechatUserInfo wechatUserInfo = help.getWechatUserInfo(access_token, openId);
//	}
	
}