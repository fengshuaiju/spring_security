package com.feng.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="menu")
public class MenuEntity extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6702068179824994933L;
	
	//菜单名称
	@Column(name="menuName")
	private String menuName;
	
	//菜单等级
	@Column(name="menuGrade")
	private String menuGrade;
	
	//排序
	@Column(name="menuRank")
	private String menuRank;
	
	//菜单url
	@Column(name="menuUrl")
	private String menuUrl;
	
	//菜单描述
	@Column(name="menuNote")
	private String menuNote;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "role_menu", joinColumns = { @JoinColumn(name = "menuid") }, inverseJoinColumns = { @JoinColumn(name = "roleid") })
	private List<RoleEntity> roles = new ArrayList<RoleEntity>();

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuGrade() {
		return menuGrade;
	}

	public void setMenuGrade(String menuGrade) {
		this.menuGrade = menuGrade;
	}

	public String getMenuRank() {
		return menuRank;
	}

	public void setMenuRank(String menuRank) {
		this.menuRank = menuRank;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public String getMenuNote() {
		return menuNote;
	}

	public void setMenuNote(String menuNote) {
		this.menuNote = menuNote;
	}

	public List<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}
	
}
