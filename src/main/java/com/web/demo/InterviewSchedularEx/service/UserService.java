package com.web.demo.InterviewSchedularEx.service;

import java.util.List;

import com.web.demo.InterviewSchedularEx.dto.UserDto;
import com.web.demo.InterviewSchedularEx.model.User;

public interface UserService {

	UserDto createUser(UserDto userDto);

	UserDto getUser(long id);

	User findUserByEmailId(String  emailId);

	List<UserDto> getusers();
	User deleteEmployeeById(long id);

}