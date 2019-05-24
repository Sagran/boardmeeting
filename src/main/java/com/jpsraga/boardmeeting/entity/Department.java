package com.jpsraga.boardmeeting.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Table(name = "DEPARTMENT")
@Entity
public class Department extends CommonEntityColumn {

	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long deptId;

	@Column
	String deptName;

	@ManyToMany(mappedBy = "departments")
	Set<UserInformation> userInformations = new HashSet<>();

	public long getDeptId() {
		return deptId;
	}

	public void setDeptId(long deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Set<UserInformation> getUserInformations() {
		return userInformations;
	}

	public void setUserInformations(Set<UserInformation> userInformations) {
		this.userInformations = userInformations;
	}
}
