package com.feng.controller;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.feng.base.BaseController;
import com.feng.model.UserEntity;
import com.feng.service.UserService;
import com.feng.util.exception.ExceptionCode;
import com.feng.util.exception.ValidateUtils;

@RestController
@RequestMapping("/api/user")
public class UserController extends BaseController{

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public UserEntity addUser(@PathVariable("id") Long userId){
		
		ValidateUtils.notNull(userId, ExceptionCode.user_USERID_IS_NULL);
		
		loger.debug("find user by id %s ", userId);
		UserEntity user = userService.findById(userId);
		
		return user;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public UserEntity addUser(@RequestParam(value="userAccount",required=true) String userAccount){
		
		loger.debug("find user by userAccount %s ", userAccount);
		UserEntity user = userService.findByUserAccount(userAccount);
		return user;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public UserEntity addUser(UserEntity user_){
		
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
