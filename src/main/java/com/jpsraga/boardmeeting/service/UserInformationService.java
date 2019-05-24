package com.jpsraga.boardmeeting.service;

import com.jpsraga.boardmeeting.entity.UserInformation;

public interface UserInformationService {
	UserInformation save(UserInformation userInformation);

	UserInformation findById(Long userInformationId);

	UserInformation update(UserInformation userInformation);
}
