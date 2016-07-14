package com.feng.exception.util;

public enum ExceptionCode {
	
	UNKNOWN("000000","you want is not get");
	
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
