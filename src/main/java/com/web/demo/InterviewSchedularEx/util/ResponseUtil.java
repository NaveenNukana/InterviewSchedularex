package com.web.demo.InterviewSchedularEx.util;

import java.util.Collection;
import java.util.Collections;


import com.web.demo.InterviewSchedularEx.Enum.ApiStatus;
import com.web.demo.InterviewSchedularEx.dto.ResponseDto;

public class ResponseUtil {

	public static ResponseDto getSuccessResponse(Object data) {
		ResponseDto response = new ResponseDto();
		response.setMessage("Data fetched successfully");
		response.setStatusCode(ApiStatus.SUCCCESS.getvalue());
		response.setData(Collections.singleton(data));
		return response;
	}
	public static ResponseDto getFailureResponse(String message) {
		ResponseDto response = new ResponseDto();
		response.setMessage(message);
		response.setStatusCode(ApiStatus.failure.getvalue());
		return response;
	}
	public static ResponseDto getResponse(String message,String status,Collection data) {
		ResponseDto response = new ResponseDto();
		response.setMessage(message);
		response.setStatusCode(status);
		response.setData(data);
		return response;		
	}
	public static ResponseDto getResponse(String message,String status,Object data) {
		ResponseDto response = new ResponseDto();
		response.setMessage(message);
		response.setStatusCode(status);
		response.setData(Collections.singleton(data));
		return response;		
	}


}
