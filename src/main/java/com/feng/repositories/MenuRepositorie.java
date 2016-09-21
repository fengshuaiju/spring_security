package com.feng.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.feng.entity.MenuEntity;

public interface MenuRepositorie extends PagingAndSortingRepository<MenuEntity,Long>,JpaSpecificationExecutor<MenuEntity>{

}
