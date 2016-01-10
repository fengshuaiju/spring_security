package com.feng.security.service;

import org.springframework.stereotype.Service;

@Service
public class UserAccountService {

	public boolean validate(String username, String password) {
		System.out.println(username+"XXXXXXXXXXXXXXXXXX"+password);
		return true;
	}
}
