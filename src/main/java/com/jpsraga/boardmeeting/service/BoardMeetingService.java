package com.jpsraga.boardmeeting.service;

import com.jpsraga.boardmeeting.entity.BoardMeeting;

public interface BoardMeetingService {
	BoardMeeting save(BoardMeeting boardMeeting);

	BoardMeeting findById(Long boardMeetingId);

	BoardMeeting update(BoardMeeting boardMeeting);
}
