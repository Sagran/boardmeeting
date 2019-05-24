package com.jpsraga.boardmeeting.repositories;

import org.springframework.data.repository.CrudRepository;

import com.jpsraga.boardmeeting.entity.BoardMeetingHistory;

public interface BoardMeetingHistoryRepositories extends CrudRepository<BoardMeetingHistory, Long> {

}
