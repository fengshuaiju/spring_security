package com.feng.model;

import java.util.HashSet;
import java.util.Set;

import com.feng.entity.MenuEntity;
import com.feng.entity.RoleEntity;
import com.feng.entity.UserEntity;

public class UserModel {
	
	private String userAccount;
	
	private String nickName;
	
	private String moble;
	
	private Set<RoleModel> roles = new HashSet<>();
	
	private Set<MenuModel> menus = new HashSet<>();

	public UserModel(){
	}
	
	public UserModel(UserEntity userEntity){
		this.userAccount = userEntity.getUserAccount();
		this.nickName = userEntity.getNickName();
		this.moble = userEntity.getMoble();
		Set<RoleEntity> roleEntitys = userEntity.getRoles();
		for (RoleEntity roleEntity : roleEntitys) {
			roles.add(new RoleModel(roleEntity));
			Set<MenuEntity> menuEntitys = roleEntity.getMenus();
			for (MenuEntity menuEntity : menuEntitys) {
				menus.add(new MenuModel(menuEntity));
			}
		}
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getMoble() {
		return moble;
	}

	public void setMoble(String moble) {
		this.moble = moble;
	}

	public Set<RoleModel> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleModel> roles) {
		this.roles = roles;
	}

	public Set<MenuModel> getMenus() {
		return menus;
	}

	public void setMenus(Set<MenuModel> menus) {
		this.menus = menus;
	}
	
}
