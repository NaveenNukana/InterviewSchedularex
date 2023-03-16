package com.web.demo.InterviewSchedularEx.cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.demo.InterviewSchedularEx.dto.ResponseDto;
import com.web.demo.InterviewSchedularEx.dto.UserDto;
import com.web.demo.InterviewSchedularEx.model.User;
import com.web.demo.InterviewSchedularEx.service.UserService;
import com.web.demo.InterviewSchedularEx.util.ResponseUtil;

@RequestMapping("/user")
@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping
	public HttpEntity<UserDto> createUser(@RequestBody UserDto userDto) {
		userDto = userService.createUser(userDto);
		return new ResponseEntity<>(userDto, HttpStatus.CREATED);
	}

	@GetMapping("/naveen/{id}")
	public HttpEntity<UserDto> findById(@PathVariable Long id) {
		UserDto userDto = userService.getUser(id);
		return new ResponseEntity<>(userDto, HttpStatus.CREATED);
	}
	@GetMapping("/{emailId}")
	public HttpEntity<User> findUserByEmailId(@PathVariable String emailId) {
		User user= userService.findUserByEmailId(emailId);
//		UserDto userDto=userMapper.toUserDto(user);		
		return new ResponseEntity<>(user, HttpStatus.CREATED);

}
	@GetMapping("users")
	public HttpEntity<ResponseDto> findAll(){
//	List<User> users=userService.findAll(); 
		List<UserDto> users = userService.getusers();
//		List<UserDto> userDto=userMapper.toUserDto(user);
		return  new ResponseEntity<>(ResponseUtil.getSuccessResponse(users),HttpStatus.OK);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<User>  deleteEmployee(@PathVariable("id") long id) {
		User user=userService.deleteEmployeeById(id);
		return new ResponseEntity<>(user,HttpStatus.NOT_FOUND) ; 
				}

}
