package com.feng.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.feng.entity.UserEntity;

public interface UserRepositorie extends PagingAndSortingRepository<UserEntity,Long>,JpaSpecificationExecutor<UserEntity>{

	UserEntity findByUserAccount(String userAccount);

}
