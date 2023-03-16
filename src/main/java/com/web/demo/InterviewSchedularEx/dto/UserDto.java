package com.web.demo.InterviewSchedularEx.dto;

import com.web.demo.InterviewSchedularEx.Enum.Role;

import lombok.Data;

@Data
public class UserDto {
	private long id;
	private String name;
	private String address;
	private String mobile;
	private String emailId;
	private String password;
	private Role role;
	private String profileUrl;
	private String forgotToken;
	private Integer otp;

}
