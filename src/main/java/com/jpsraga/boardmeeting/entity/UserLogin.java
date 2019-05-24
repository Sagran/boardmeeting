package com.jpsraga.boardmeeting.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "USER_LOGIN")
@Entity
public class UserLogin extends CommonEntityColumn {

	@Column(name = "USER_LOGIN_ID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userLoginId;

	@Column(name = "USER_NAME")
	String userName;

	@Column(name = "PASSWORD")
	char[] password;

	public long getUserLoginId() {
		return userLoginId;
	}

	public void setUserLoginId(long userLoginId) {
		this.userLoginId = userLoginId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

}
