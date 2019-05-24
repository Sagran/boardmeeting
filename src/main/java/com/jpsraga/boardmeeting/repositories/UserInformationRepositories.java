package com.jpsraga.boardmeeting.repositories;

import org.springframework.data.repository.CrudRepository;

import com.jpsraga.boardmeeting.entity.UserInformation;

public interface UserInformationRepositories extends CrudRepository<UserInformation, Long> {

}
