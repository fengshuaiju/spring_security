package com.feng.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.feng.model.UserEntity;

public interface UserRepositorie extends PagingAndSortingRepository<UserEntity,Long>,JpaSpecificationExecutor<UserEntity>{

}
