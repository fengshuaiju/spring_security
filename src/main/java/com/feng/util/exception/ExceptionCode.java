package com.feng.util.exception;

public enum ExceptionCode {
	
	//COMMON
	UNKNOWN("000000","you want is not get"),
	
	//USER
	user_USERNAME_PASSWORD_WRONG("000001","username or password is wrong"),
	user_USERID_IS_NULL("000002","user id is null");
	
	ExceptionCode(String errCode , String errMessage){
		this.errCode = errCode;
		this.errMessage = errMessage;
	}
	
	private String errCode;
	private String errMessage;
	public String getErrCode() {
		return errCode;
	}
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	public String getErrMessage() {
		return errMessage;
	}
	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}
}
