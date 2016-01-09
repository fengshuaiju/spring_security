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

	@Override
	public Page<ModelEntity> findAll(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelEntity findById(Long modelId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelEntity create(ModelEntity modelEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelEntity update(Long modelId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long modelId) {
		// TODO Auto-generated method stub
		
	}
	
//	@Autowired
//	private ModelRepositorie modelRepositorie;
//
//	@Override
//	public Page<ModelEntity> findAll(Pageable page) {
//		Page<ModelEntity> list = modelRepositorie.findAll(page);
//		return list;
//	}
//
//	@Override
//	public ModelEntity findById(Long modelId) {
//		ModelEntity modelEntity = modelRepositorie.findOne(modelId);
//		return modelEntity;
//	}
//
//	@Override
//	public ModelEntity create(ModelEntity modelEntity) {
//		modelEntity = modelRepositorie.save(modelEntity);
//		return modelEntity;
//	}
//
//	@Override
//	public ModelEntity update(Long modelId) {
//		ModelEntity modelEntity = modelRepositorie.findOne(modelId);
//		modelEntity.setName("new Name");
//		return modelEntity;
//	}
//
//	@Override
//	public void delete(Long modelId) {
//		//modelRepositorie.delete(modelId);
//	}

}
