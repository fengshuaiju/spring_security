package com.feng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.feng.model.ModelEntity;
import com.feng.service.ModelService;

@RestController
@RequestMapping("/api/model")
public class ModelController {

	@Autowired
	private ModelService modelService;
	
	@RequestMapping(method=RequestMethod.GET)
	public Page<ModelEntity> sayHello(Pageable page){
		Page<ModelEntity> pageList = modelService.findAll(page);
		return pageList;
	}
	
	@RequestMapping(value="/{modelId}",method=RequestMethod.GET)
	private ModelEntity getById(@PathVariable Long modelId){
		modelId = 1l;
		ModelEntity modelEntity = modelService.findById(modelId);
		return modelEntity;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	private ModelEntity create(@RequestBody ModelEntity entity){
		entity = modelService.create(entity);
		return entity;
	}
	
	@RequestMapping(value="/{modelId}",method=RequestMethod.PUT)
	private ModelEntity update(@PathVariable Long modelId){
		ModelEntity modelEntity = modelService.update(modelId);
		return modelEntity;
	}
	
	@RequestMapping(value="/{modelId}",method=RequestMethod.DELETE)
	private String delete(@PathVariable Long modelId){
		modelService.delete(modelId);
		return "success";
	}
}
