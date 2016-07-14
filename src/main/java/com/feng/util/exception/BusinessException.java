package com.feng.util.exception;

public class BusinessException extends RuntimeException{

	private static final long serialVersionUID = -6972322936634761970L;
	
	private String errMessage;
	private String errCode;
	
	public BusinessException(){
	}

	public BusinessException(ExceptionCode exceptionCode){
		this.errMessage = exceptionCode.getErrMessage();
		this.errCode = exceptionCode.getErrCode();
	}
	
	public BusinessException(String errMessage, String errCode) {
		this.errMessage = errMessage;
		this.errCode = errCode;
	}

	public String getErrMessage() {
		return errMessage;
	}

	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

}
