package com.jpsraga.boardmeeting.repositories;

import org.springframework.data.repository.CrudRepository;

import com.jpsraga.boardmeeting.entity.BoardMeeting;

public interface BoardMeetingRepositories extends CrudRepository<BoardMeeting, Long> {

}
