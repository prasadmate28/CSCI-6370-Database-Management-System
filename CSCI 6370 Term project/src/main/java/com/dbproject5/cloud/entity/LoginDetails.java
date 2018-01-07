package com.dbproject5.cloud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="login_details")
public class LoginDetails {

	@Column( name="userId")
	@Id
	public long userId;
	@Column( name="userpassword")
	public String userPassword;
	@Column( name="userType")
	public String userType;
	@Column( name="privilage")
	public String privilage;
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getPrivilage() {
		return privilage;
	}
	public void setPrivilage(String privilage) {
		this.privilage = privilage;
	}
	
	
}
