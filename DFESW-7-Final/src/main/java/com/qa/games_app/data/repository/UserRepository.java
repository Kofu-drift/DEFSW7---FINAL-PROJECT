package com.qa.games_app.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.games_app.data.entity.POJO_Game;


public interface UserRepository extends JpaRepository <POJO_Game, Long> {

}
