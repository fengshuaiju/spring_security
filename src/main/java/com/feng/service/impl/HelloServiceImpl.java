package com.feng.service.impl;

import org.springframework.stereotype.Service;

import com.feng.service.HelloService;

@Service
public class HelloServiceImpl implements HelloService{

	@Override
	public String say(String name) {
		return "Hello " + name ;
	}

}
