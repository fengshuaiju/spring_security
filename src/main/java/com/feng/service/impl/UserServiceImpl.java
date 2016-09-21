package com.feng.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feng.base.BaseService;
import com.feng.entity.UserEntity;
import com.feng.repositories.UserRepositorie;
import com.feng.service.UserService;

@Service
public class UserServiceImpl extends BaseService implements UserService{

	@Autowired
	private UserRepositorie userRepositorie;

	@Override
	public UserEntity add(UserEntity user) {
		UserEntity userEntity = userRepositorie.save(user);
		return userEntity;
	}

	@Override
	public UserEntity findById(Long userId) {
		UserEntity user = userRepositorie.findOne(userId);
		return user;
	}

	@Override
	public UserEntity findByUserAccount(String userAccount) {
		loger.debug(String.format("find by userAccount : %s", userAccount));
		UserEntity userEntity = userRepositorie.findByUserAccount(userAccount);
		return userEntity;
	}
	
	
}
