package com.jpsraga.boardmeeting.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "BOARD_MEETING")
public class BoardMeeting extends CommonEntityColumn {

	@Column(name = "BOARD_MEETING_ID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long boardMeetingId;

	@Column(name = "BOARD_MEETING_SUBJECT")
	String Subject;

	@Column(name = "BOARD_MEETING_CONTENT")
	String content;

	@Column(name = "BOARD_MEETING_DATE")
	String meetingDate;

	@Column(name = "BOARD_MEETING_COMMENTS")
	String comments;

	@JoinTable(name = "BOARD_MEETING_AGENDAS", joinColumns = {
			@JoinColumn(name = "BOARD_MEETING_ID") }, inverseJoinColumns = { @JoinColumn(name = "AGENDA_ID") })
	@OneToMany
	List<Agenda> agendas;

	public List<Agenda> getAgendas() {
		return agendas;
	}

	public void setAgendas(List<Agenda> agendas) {
		this.agendas = agendas;
	}

	public long getBoardMeetingId() {
		return boardMeetingId;
	}

	public void setBoardMeetingId(long boardMeetingId) {
		this.boardMeetingId = boardMeetingId;
	}

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMeetingDate() {
		return meetingDate;
	}

	public void setMeetingDate(String meetingDate) {
		this.meetingDate = meetingDate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}
