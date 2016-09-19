package com.feng.security.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class NormalAuthAuthenticationProvider implements AuthenticationProvider {
	
//	@Autowired
//	private 

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		//登录时的唯一凭证,userName
		Object principal = authentication.getPrincipal();
		//登陆时，输入的密码
		Object credentials = authentication.getCredentials();
		
		List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
		SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_ADMIN");
		list.add(simpleGrantedAuthority);
		
		UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(principal, credentials, list);
		
		return result;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

}
