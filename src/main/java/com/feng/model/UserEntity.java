package com.feng.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class UserEntity extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1877312406266364501L;

	@Column(name="userAccount")
	private String userAccount;
	
	@Column(name="password")
	private String password;
	
	@Column(name="salt")
	private String salt;
	
	@Column(name="nickName")
	private String nickName;
	
	@Column(name="moble")
	private String moble;
	
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
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
	
}