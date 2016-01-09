package com.feng.controller;

import java.net.URLClassLoader;
import java.util.Arrays;

import org.jboss.jandex.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.feng.model.ModelEntity;
import com.feng.service.ModelService;

@Controller
@RequestMapping("/api/model")
public class ModelController {

	@Autowired
	private ModelService modelService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String sayHello(){
		Page<ModelEntity> say = modelService.findAll();
		ModelEntity entity = modelService.findById(1L);
		System.out.println(entity);
		//model.addAttribute("say",say);
		return "hello/hello";
	}
	
	@RequestMapping(value="/{modelId}",method=RequestMethod.GET)
	private String getById(@PathVariable Long modelId){
		ModelEntity modelEntity = modelService.findById(modelId);
		return "";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	private String create(){
		ModelEntity modelEntity = new ModelEntity();
		modelEntity = modelService.create(modelEntity);
		return "";
	}
	
	@RequestMapping(value="/{modelId}",method=RequestMethod.PUT)
	private String update(@PathVariable Long modelId){
		ModelEntity modelEntity = modelService.update(modelId);
		return null;
	}
	
	@RequestMapping(value="/{modelId}",method=RequestMethod.DELETE)
	private String delete(@PathVariable Long modelId){
		modelService.delete(modelId);
		return null;
	}
	public static void main(String[] args) {
        URLClassLoader classLoader = (URLClassLoader)Main.class.getClassLoader();
        System.out.println(Arrays.toString(classLoader.getURLs()));
}
}
