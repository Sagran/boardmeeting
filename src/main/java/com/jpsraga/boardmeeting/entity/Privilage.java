package com.jpsraga.boardmeeting.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "PRIVILAGES")
@Entity
public class Privilage {

	@Column(name = "PRIVILAGE_ID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long privilageId;

	@Column(name = "PRIVILAGE_NAME")
	private String privilageName;

	public long getPrivilageId() {
		return privilageId;
	}

	public void setPrivilageId(long privilageId) {
		this.privilageId = privilageId;
	}

	public String getPrivilageName() {
		return privilageName;
	}

	public void setPrivilageName(String privilageName) {
		this.privilageName = privilageName;
	}

}
