package com.feng.security.util;

import org.springframework.security.core.GrantedAuthority;

public class GrantedAuthorityImpl implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	@Override
	public String getAuthority() {
		return "ROLE_ADMIN";
	}

}
