package com.qa.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.qa.games_app.Dfesw7FinalApplication;
import com.qa.games_app.data.entity.Games;
import com.qa.games_app.data.repository.UserRepository;
import com.qa.games_app.service.UserService;

@SpringBootTest(classes = Dfesw7FinalApplication.class )
@Transactional
public class GamesServiceIntTest {
	@Autowired
	private UserService service;
	
	@Autowired
	private UserRepository repo;
	
	private List<Games> games;
	private Long nextNewElementsId;
	
	@BeforeEach
	public void preTest() {
		List<Games> newData = List.of(new Games(1l, "Undertale", "JRPG", "15 September 2015", "Toby Fox", "Toby Fox", "PC"), 
				new Games(2l, "Hollow Knight", "MetroidVania", "24 February 2017", "Team Cherry", "Team Cherry", "PC"),
				new Games(3l, "Outer Wilds", "28 May 2019", "Puzzle", "Mobius Digital", "Annapurna Interactive", "PC"));
			
		games = new ArrayList<>();
		games.addAll(repo.saveAll(newData));
		int size = games.size();
		nextNewElementsId = games.get(size - 1).getId() + 1;
	
	}
	
	@Test
	public void createTest() {
		Games testGame = new Games ("Chrono Trigger", "JRPG", "11 March 1995", "Square", "Square", "SNES");
		Games expectedGame = new Games(nextNewElementsId, testGame.getgTitle(), testGame.getgGenre(), testGame.getrDate(), testGame.getgDeveloper(), testGame.getgProducer(), testGame.getgPlatform());
		assertThat(expectedGame).isEqualTo(service.addgame(testGame));
	}
	
	@Test
	public void getAllGamesTest() {
		assertThat(games).isEqualTo(service.getAllGames());
	}


	@Test
	public void getByIdTest() {
		Games gameTest = games.get(0);
		assertThat(service.getById(gameTest.getId())).isEqualTo(gameTest);
	}
	
	@Test
	public void updateGameTest() {
		Games gameTest = games.get(0);
		long id = gameTest.getId();
		Games gameWithUpdates = new Games (
				gameTest.getId(), 
				gameTest.getgTitle(),
				gameTest.getgGenre(), 
				gameTest.getrDate(), 
				gameTest.getgDeveloper(),
				gameTest.getgProducer(),
				gameTest.getgPlatform());
				
				assertThat(service.updateGame(id, gameWithUpdates)).isEqualTo(gameWithUpdates);
				
				
				
	}
	
	@Test
	public void removeGameTest() {
		Games gameTest = games.get(0);
		long id = gameTest.getId();
		assertThat(service.removeGame(id)).isEqualTo(true);
	}


}
