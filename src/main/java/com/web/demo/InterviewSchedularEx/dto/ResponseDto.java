package com.web.demo.InterviewSchedularEx.dto;





import java.util.Collection;
import java.util.Set;

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

	
}
