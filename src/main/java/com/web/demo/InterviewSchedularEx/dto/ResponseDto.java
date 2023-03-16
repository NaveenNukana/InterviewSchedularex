package com.web.demo.InterviewSchedularEx.dto;





import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto<T> {
	
	private String message;
	private String statusCode;
	private Collection<T> data;
	public void setData(Collection<Object> data) {
		// TODO Auto-generated method stub
		
		
	}
	
}
