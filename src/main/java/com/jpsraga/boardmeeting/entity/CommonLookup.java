package com.jpsraga.boardmeeting.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "COMMON_LOOKUP")
@Entity
public class CommonLookup extends CommonEntityColumn {

	@Column(name = "LOOKUP_ID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long lookupId;

	@Column(name = "LOOKUP_NAME")
	String name;

	@OneToMany(mappedBy = "lookupId")
	Set<CommonLookupCode> lookupCodes = new HashSet<>();

	public long getLookupId() {
		return lookupId;
	}

	public void setLookupId(long lookupId) {
		this.lookupId = lookupId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<CommonLookupCode> getLookupCodes() {
		return lookupCodes;
	}

	public void setLookupCodes(Set<CommonLookupCode> lookupCodes) {
		this.lookupCodes = lookupCodes;
	}

}
