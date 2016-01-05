package com.feng.security.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;

public class GrantedAuthorityImpl implements GrantedAuthority {

	/**
	 * ROLE USER 权限
	 */
	private static final String ROLE_USER = "ROLE_USER";

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 1L;

	private UserDetailsService delegate;

	public GrantedAuthorityImpl(UserDetailsService user) {
		this.delegate = user;
	}

	public String getAuthority() {
		return ROLE_USER;
	}

}
