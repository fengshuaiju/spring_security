package com.feng.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feng.model.UserEntity;
import com.feng.repositories.UserRepositorie;
import com.feng.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepositorie userRepositorie;

	@Override
	public UserEntity add(UserEntity user) {
		
		UserEntity userEntity = userRepositorie.save(user);
		
		return userEntity;
	}
	
}
