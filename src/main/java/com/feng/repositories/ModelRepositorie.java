package com.feng.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.feng.model.ModelEntity;

public interface ModelRepositorie extends PagingAndSortingRepository<ModelEntity,Long>,JpaSpecificationExecutor<ModelEntity>{

}
