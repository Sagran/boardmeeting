package com.jpsraga.boardmeeting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class BoardmeetingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardmeetingApplication.class, args);
	}

}
