package com.jpsraga.boardmeeting.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "COMMON_LOOKUP_VALUE")
@Entity
public class CommonLookupValue extends CommonEntityColumn {
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;

	@Column
	String value;

	@ManyToOne
	@JoinColumn(name = "LOOKUP_CODE_ID", referencedColumnName = "LOOKUP_CODE_ID")
	CommonLookupCode lookupCodeId;

	@Column
	String lang;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public CommonLookupCode getLookupCodeId() {
		return lookupCodeId;
	}

	public void setLookupCodeId(CommonLookupCode lookupCodeId) {
		this.lookupCodeId = lookupCodeId;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

}
