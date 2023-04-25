package com.oms.OrderManagementSystem.common.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class ExceptionHandler {

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	//@ExceptionHandler(Exception.class)
	public Map<String,String> handleBusinessLogicException(Exception ex){
		log.error("Exception encountered",ex);
		Map<String,String> errorMap = new HashMap<>();
		errorMap.put(null, null);
		return errorMap;
	}
}
