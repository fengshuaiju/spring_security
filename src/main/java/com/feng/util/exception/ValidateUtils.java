package com.feng.util.exception;

import java.util.Collection;

public class ValidateUtils {

	public static void isTrue(boolean expression, ExceptionCode exceptionCode){
		if(!expression){
			throw new BusinessException(exceptionCode);
		}
	}
	
	public static void notNull(Object object, ExceptionCode exceptionCode){
		if(object == null){
			throw new BusinessException(exceptionCode);
		}
	}
	
	public static void notEmpty(Collection<?> collection, ExceptionCode exceptionCode){
		if(collection != null){
			if(collection.size() == 0){
				throw new BusinessException(exceptionCode);
			}
		}
		throw new BusinessException(exceptionCode);
	}
	
}
