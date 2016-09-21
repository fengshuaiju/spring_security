package com.feng.service;

import com.feng.entity.UserEntity;

public interface UserService {

	/**
	 * 增加一条用户信息
	 * @param user
	 * @return
	 */
	UserEntity add(UserEntity user);

	/**
	 * 根据userId查询一个用户
	 * @param userId
	 * @return
	 */
	UserEntity findById(Long userId);

	/**
	 * 根据用户账号查找用户
	 * @param userAccount
	 * @return
	 */
	UserEntity findByUserAccount(String userAccount);
}
