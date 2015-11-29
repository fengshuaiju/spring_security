package com.feng.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
		
		return "hello/hello";
	}
}
