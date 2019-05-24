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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "AGENDA")
@Entity
public class Agenda extends CommonEntityColumn {

	@Column(name = "AGENDA_ID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long agendaId;

	@OneToOne()
	@JoinColumn(name = "AGENDA_TYPE")
	CommonLookupCode type;

	@Column(name = "SUBJECT")
	String subject;

	@Column(name = "ISSUE_OF_CONSIDERATION")
	String issueOfConsideration;

	@Column(name = "BACKGROUND")
	String backGround;

	@Column(name = "SUBMISSION")
	String submission;

	@JoinTable(name = "AGENDA_HAS_ATTACHMENTS", joinColumns = {
			@JoinColumn(name = "AGENDA_ID") }, inverseJoinColumns = { @JoinColumn(name = "ATTACHMENT_ID") })
	@OneToMany
	Set<Attachment> attachments = new HashSet<>();

	@OneToOne
	@JoinColumn(name = "APPROVAL_STATUS")
	CommonLookupCode approvalStatus;

	public long getAgendaId() {
		return agendaId;
	}

	public void setAgendaId(long agendaId) {
		this.agendaId = agendaId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getIssueOfConsideration() {
		return issueOfConsideration;
	}

	public void setIssueOfConsideration(String issueOfConsideration) {
		this.issueOfConsideration = issueOfConsideration;
	}

	public String getBackGround() {
		return backGround;
	}

	public void setBackGround(String backGround) {
		this.backGround = backGround;
	}

	public String getSubmission() {
		return submission;
	}

	public void setSubmission(String submission) {
		this.submission = submission;
	}

	public Set<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(Set<Attachment> attachments) {
		this.attachments = attachments;
	}

	public CommonLookupCode getType() {
		return type;
	}

	public void setType(CommonLookupCode type) {
		this.type = type;
	}

	public CommonLookupCode getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(CommonLookupCode approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
}
