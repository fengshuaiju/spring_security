package com.feng.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.feng.service.HelloService;

@Controller
public class HelloController {

	@Autowired
	private HelloService helloService;
	
	@RequestMapping(value="/sayHello")
	public String sayHello(@RequestParam(required=false) String name,Model model){
		
		String say = helloService.say(name);
		System.out.println(say);
		
		model.addAttribute("say",say);
		
		this.getCurrentUser();
		
		return "hello/hello";
	}
	
	
	public void getCurrentUser(){
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		
		String name = authentication.getName();//获取当前登录用户姓名
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();//获取当前用户的所有权限
		Object principal = authentication.getPrincipal();
		Object details = authentication.getDetails();
		
		WebAuthenticationDetails authenticationDetails = (WebAuthenticationDetails) authentication.getDetails();
		
		String token = authenticationDetails.getSessionId();
		
		Object credentials = authentication.getCredentials();
		boolean authenticated = authentication.isAuthenticated();
		
		System.out.println(token);
		
	}
}
