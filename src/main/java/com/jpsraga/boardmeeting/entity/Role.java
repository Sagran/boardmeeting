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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "ROLE")
@Entity
public class Role {
	@Column(name = "ROLE_ID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long roleId;

	@Column(name = "ROLE_NAME")
	private String roleName;

	@JoinTable(name = "ROLE_HAS_PRIVILAGES", joinColumns = { @JoinColumn(name = "ROLE_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "PRIVILAGE_ID") })
	@OneToMany
	Set<Privilage> privileges = new HashSet<>();

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
