package com.jpsraga.boardmeeting.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpsraga.boardmeeting.entity.BoardMeeting;
import com.jpsraga.boardmeeting.repositories.BoardMeetingRepositories;
import com.jpsraga.boardmeeting.service.BoardMeetingService;

@Service
public class BoardMeetingServiceImpl implements BoardMeetingService {

	@Autowired
	private BoardMeetingRepositories boardMeetingRepositories;

	@Autowired
	BoardMeetingServiceImpl(BoardMeetingRepositories boardMeetingRepositories) {
		this.boardMeetingRepositories = boardMeetingRepositories;
	}

	@Override
	public BoardMeeting save(BoardMeeting boardMeeting) {
		return boardMeetingRepositories.save(boardMeeting);
	}

	@Override
	public BoardMeeting findById(Long boardMeetingId) {
		Optional<BoardMeeting> optional = boardMeetingRepositories.findById(boardMeetingId);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	@Override
	public BoardMeeting update(BoardMeeting boardMeeting) {
		return boardMeetingRepositories.save(boardMeeting);
	}

}
