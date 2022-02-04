package com.qa.games_app.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.games_app.data.entity.Games;


public interface UserRepository extends JpaRepository <Games, Long> {

}
