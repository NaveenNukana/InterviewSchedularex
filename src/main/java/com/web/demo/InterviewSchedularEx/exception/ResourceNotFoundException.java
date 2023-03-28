package com.web.demo.InterviewSchedularEx.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ResourceNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	private HttpStatus code;


	public ResourceNotFoundException(String message, HttpStatus code) {
		super();
		this.message = message;
		this.code = code;
	}
	
	 
	
	
	
	
	
	

}
