package com.jpsraga.boardmeeting.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ATTACHMENT")
public class Attachment extends CommonEntityColumn {
	@Column(name = "ATTACHMENT_ID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long attachmentId;

	@Column(name = "ATTACHMENT_NAME")
	String attachmentName;

	@Column(name = "ATTACHMENT_LOCATION")
	String attachmentLocation;

	public long getAttachmentId() {
		return attachmentId;
	}

	public void setAttachmentId(long attachmentId) {
		this.attachmentId = attachmentId;
	}

	public String getAttachmentName() {
		return attachmentName;
	}

	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}

	public String getAttachmentLocation() {
		return attachmentLocation;
	}

	public void setAttachmentLocation(String attachmentLocation) {
		this.attachmentLocation = attachmentLocation;
	}

}
