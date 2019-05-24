package com.jpsraga.boardmeeting.service;

import com.jpsraga.boardmeeting.entity.UserLogin;

public interface UserLoginService {
	UserLogin save(UserLogin userLogin);

	UserLogin findById(Long boardMeetingId);

	UserLogin update(UserLogin userLogin);
}
