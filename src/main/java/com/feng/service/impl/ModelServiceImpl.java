package com.feng.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.feng.model.ModelEntity;
import com.feng.repositories.ModelRepositorie;
import com.feng.service.ModelService;

@Service
public class ModelServiceImpl implements ModelService{
	
	@Autowired
	private ModelRepositorie modelRepositorie;

	@Override
	public Page<ModelEntity> findAll(Pageable page) {
		Page<ModelEntity> findAll = modelRepositorie.findAll(page);
		return findAll;
	}

	@Override
	public ModelEntity findById(Long modelId) {
		return modelRepositorie.findOne(modelId);
	}

	@Override
	public ModelEntity create(ModelEntity modelEntity) {
		return modelRepositorie.save(modelEntity);
	}

	@Override
	public ModelEntity update(Long modelId) {
		ModelEntity entity = modelRepositorie.findOne(modelId);
		entity.setName("new_name_冯帅炬");
		return modelRepositorie.save(entity);
	}

	@Override
	public void delete(Long modelId) {
		ModelEntity entity = modelRepositorie.findOne(modelId);
		entity.setRemovemark(true);
		modelRepositorie.save(entity);
	}
}
