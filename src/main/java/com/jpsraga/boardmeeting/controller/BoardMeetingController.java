package com.jpsraga.boardmeeting.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpsraga.boardmeeting.entity.BoardMeeting;
import com.jpsraga.boardmeeting.service.BoardMeetingService;

@RestController
public class BoardMeetingController {

	@Autowired
	BoardMeetingService boardMeetingService;

	@PostMapping
	@ResponseBody
	public ResponseEntity<BoardMeeting> createBoardMeeting(@RequestBody BoardMeeting boardMeeting) {
		if (Objects.isNull(boardMeeting) || Objects.isNull(boardMeeting.getContent())
				|| Objects.isNull(boardMeeting.getMeetingDate()) || Objects.isNull(boardMeeting.getMeetingDate())) {
			return new ResponseEntity<BoardMeeting>(boardMeeting, HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok().body(boardMeetingService.save(boardMeeting));
	}

	@GetMapping
	@ResponseBody
	public ResponseEntity<BoardMeeting> createBoardMeeting(@RequestBody long boardMeetingId) {
		BoardMeeting boardMeeting = null;
		if (boardMeetingId <= 0) {
			return new ResponseEntity<BoardMeeting>(boardMeeting, HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok().body(boardMeetingService.findById(boardMeetingId));
	}

	@PutMapping
	@ResponseBody
	public ResponseEntity<BoardMeeting> updateBoardMeeting(@RequestBody BoardMeeting boardMeeting) {
		if (Objects.isNull(boardMeeting) || Objects.isNull(boardMeeting.getContent())
				|| Objects.isNull(boardMeeting.getMeetingDate()) || Objects.isNull(boardMeeting.getMeetingDate())) {
			return new ResponseEntity<BoardMeeting>(boardMeeting, HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok().body(boardMeetingService.update(boardMeeting));
	}

}
