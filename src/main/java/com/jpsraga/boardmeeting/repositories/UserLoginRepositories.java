package com.jpsraga.boardmeeting.repositories;

import org.springframework.data.repository.CrudRepository;

import com.jpsraga.boardmeeting.entity.UserLogin;

public interface UserLoginRepositories extends CrudRepository<UserLogin, Long> {

}
