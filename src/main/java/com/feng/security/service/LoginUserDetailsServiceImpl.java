package com.feng.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginUserDetailsServiceImpl implements LoginUserDetailsService {

	@Autowired
	private UserAccountService userAccountService;

	/** 
	 * 
	 */
	public LoginUserDetailsServiceImpl() {
	}

	/**
	 * getter method
	 * 
	 * @see LoginUserDetailsServiceImpl#userAccountService
	 * @return the userAccountService
	 */
	public UserAccountService getUserAccountService() {
		return userAccountService;
	}

	/**
	 * 功能描述：查找登录的用户
	 * <p>
	 * 前置条件：
	 * <p>
	 * 方法影响：
	 * <p>
	 * Author , 2012-9-26
	 * 
	 * @since server 2.0
	 * @param username
	 * @return
	 */
	public UserDetails loadUserByUsername(String username, String password) throws UsernameNotFoundException {
		//2
		boolean result = userAccountService.validate(username, password);
		if (!result) {
			return null;
		}

		LoginUserDetailsImpl user = new LoginUserDetailsImpl(username, password);
		return user;
	}

	/**
	 * setter method
	 * 
	 * @see LoginUserDetailsServiceImpl#userAccountService
	 * @param userAccountService
	 *            the userAccountService to set
	 */
	public void setUserAccountService(UserAccountService userAccountService) {
		this.userAccountService = userAccountService;
	}

}