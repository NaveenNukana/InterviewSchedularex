package com.web.demo.InterviewSchedularEx.IExceptionHandle;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.web.demo.InterviewSchedularEx.dto.ResponseDto;
import com.web.demo.InterviewSchedularEx.exception.ResourceNotFoundException;
import com.web.demo.InterviewSchedularEx.util.ResponseUtil;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class InterviewshedulerExceptionHandle {

	@ExceptionHandler(value = ResourceNotFoundException.class)
	public ResponseEntity<ResponseDto> notFoundException(ResourceNotFoundException notFoundException){
    log.info("no resource found");
	return new ResponseEntity<>(ResponseUtil.getFailureResponse(notFoundException.getMessage()),notFoundException.getCode());

     
	}

}
//     return new ResponseEntity<>(ResponseUtil.getFailureResponse(notFoundException.getMessage()),notFoundException.getCode());
