package com.feng.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.feng.exception.util.BusinessException;
import com.feng.exception.util.ExceptionModel;

public class BaseComponent {
//	protected Logger loger;
//	
//	public BaseComponent(){
//		loger = LoggerFactory.getLogger(this.getClass());
//	}
	
	/**
	 * 捕获业务上的异常
	 * @param e
	 * @return
	 */
	@ExceptionHandler({BusinessException.class})
	public ExceptionModel showBusinessException(BusinessException e){
		
		String exceptionMessage = e.getErrMessage();
		String exceptionCode = e.getErrCode();
		
		ExceptionModel exception = new ExceptionModel(exceptionCode,exceptionMessage);
		
		return exception;
	}
	
	/**
	 * 捕获未知的异常
	 * @param e
	 * @return
	 */
	@ExceptionHandler({Throwable.class})
	public ExceptionModel showException(Throwable e){
		
		String exceptionMessage =e.getStackTrace()[0] + ":" + e.getClass().getName()+":" + e.getMessage();
		String exceptionCode = "000000";
		
		ExceptionModel exception = new ExceptionModel(exceptionCode,exceptionMessage);
		
		return exception;
	}

}