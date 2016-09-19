package com.feng.controller;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.feng.model.UserEntity;
import com.feng.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public UserEntity addUser(@PathVariable("id") Long userId){
		
		UserEntity user = userService.findById(userId);
		
		return user;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public UserEntity addUser(@RequestParam(value="userAccount",required=false) String userAccount){
		UserEntity user = userService.findByUserAccount(userAccount);
		return user;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public UserEntity addUser(){
		
		UserEntity user = new UserEntity();
		user.setCreationTime(DateTime.now());
		user.setMoble("18930061430");
		user.setNickName("冯帅炬");
		user.setPassword("fengshuaiju");
		user.setSalt("fengshuaiju");
		user.setUpdateTime(DateTime.now());
		user.setUserAccount("fengshuaiju");
		
		user = userService.add(user);
		
		return user;
	}
}
