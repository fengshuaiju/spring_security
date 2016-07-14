package com.feng.exception.util;

public class ValidateUtils {

	public static void isTrue(boolean expression,ExceptionCode exceptionCode){
		if(!expression){
			throw new BusinessException(exceptionCode);
		}
	}
	
}
