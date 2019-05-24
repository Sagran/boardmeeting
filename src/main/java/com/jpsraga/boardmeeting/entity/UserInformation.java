package com.jpsraga.boardmeeting.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "USER_INFORMATION")
@Entity
public class UserInformation extends CommonEntityColumn {

	@Column(name = "USER_ID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userInfoId;

	@Column(name = "USER_NAME")
	String userName;

	@ManyToMany
	@JoinTable(name = "DEPARTMENT_HAS_USER_INFORMATION", joinColumns = {
			@JoinColumn(name = "USER_ID") }, inverseJoinColumns = { @JoinColumn(name = "DEPT_ID") })
	Set<Department> departments = new HashSet<>();

	@OneToOne
	@JoinColumn(name = "userLoginId")
	UserLogin userLogin;

	public long getUserInfoId() {
		return userInfoId;
	}

	public void setUserInfoId(long userInfoId) {
		this.userInfoId = userInfoId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Set<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(Set<Department> departments) {
		this.departments = departments;
	}

	public UserLogin getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(UserLogin userLogin) {
		this.userLogin = userLogin;
	}

}
