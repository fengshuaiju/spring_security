package com.feng.util.exception;

public class ValidateUtils {

	public static void isTrue(boolean expression,ExceptionCode exceptionCode){
		if(!expression){
			throw new BusinessException(exceptionCode);
		}
	}
	
}
