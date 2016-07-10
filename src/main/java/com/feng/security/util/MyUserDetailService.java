package com.feng.security.util;

import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		// String username, String password, Collection<? extends GrantedAuthority> authorities
		
		username = "fengshuaiju";
		String password = "123";
		List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
		GrantedAuthorityImpl grantedAuthorityImpl = new GrantedAuthorityImpl();
		list.add(grantedAuthorityImpl);
		
		User user = new User(username,password,list);
		
		return user;
	}

	
}
