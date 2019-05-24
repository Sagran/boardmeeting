package com.jpsraga.boardmeeting.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "COMMON_LOOKUP_CODE")
@Entity
public class CommonLookupCode {
	@Column(name = "LOOKUP_CODE_ID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;

	@Column(name = "LOOKUP_CODE_NAME")
	String name;

	@ManyToOne(targetEntity = CommonLookup.class)
	@JoinColumn(name = "COMMON_LOOKUP_ID", referencedColumnName = "LOOKUP_ID")
	CommonLookup lookupId;

	@OneToMany(mappedBy = "lookupCodeId")
	Set<CommonLookupValue> lookupValues = new HashSet<>();

	public CommonLookup getLookupId() {
		return lookupId;
	}

	public void setLookupId(CommonLookup lookupId) {
		this.lookupId = lookupId;
	}

	public Set<CommonLookupValue> getLookupValues() {
		return lookupValues;
	}

	public void setLookupValues(Set<CommonLookupValue> lookupValues) {
		this.lookupValues = lookupValues;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
