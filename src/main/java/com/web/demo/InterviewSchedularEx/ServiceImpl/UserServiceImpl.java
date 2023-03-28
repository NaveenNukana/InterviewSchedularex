package com.web.demo.InterviewSchedularEx.ServiceImpl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.web.demo.InterviewSchedularEx.Repository.UserRepository;
import com.web.demo.InterviewSchedularEx.dto.UserDto;
import com.web.demo.InterviewSchedularEx.exception.ResourceNotFoundException;
import com.web.demo.InterviewSchedularEx.mapper.UserMapper;
import com.web.demo.InterviewSchedularEx.model.User;
import com.web.demo.InterviewSchedularEx.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired(required = false)
	private UserMapper userMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = userMapper.toUser(userDto);
		User userEntity = userRepository.save(user);
		userDto = userMapper.toUserDto(userEntity);
		return userDto;
	}

	@Override
	public UserDto getUser(long id) {
		Optional<User> optionalUser = userRepository.findById(id);
		User user = optionalUser
				.orElseThrow(() -> new ResourceNotFoundException("Resource not found ", HttpStatus.NOT_FOUND));
		UserDto userDto = userMapper.toUserDto(user);
		return userDto;
	}

	@Override
	public List<User> getusers() {
		List<User> user = userRepository.findAll();

		return user;
	}

	@Override
	public User findUserByEmailId(String emailId) {
		User user = userRepository.findUserByEmailId(emailId);

		return user;
	}

	public User deleteEmployeeById(long id) {
		userRepository.deleteById(id);
		return null;
	}

}
