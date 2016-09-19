package com.feng.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name="role")
public class Role extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4883038413820066264L;

	@Column(name="roleName")
	private String roleName;
	
	@Column(name="note")
	private String note;
	
	@ManyToMany
	@JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "roleid") }, inverseJoinColumns = { @JoinColumn(name = "userid") })
	private List<UserEntity> users = new ArrayList<UserEntity>();

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}
	
}