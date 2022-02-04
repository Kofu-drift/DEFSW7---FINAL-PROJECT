package com.qa.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.qa.games_app.data.entity.Games;
import com.qa.games_app.data.repository.UserRepository;
import com.qa.games_app.exceptions.GameNotFoundException;
import com.qa.games_app.service.UserService;

import nl.jqno.equalsverifier.EqualsVerifier;

@ExtendWith(MockitoExtension.class)
public class GamesServiceUnitTest {
	@Mock
	private UserRepository repo;

	@InjectMocks
	private UserService service;

	private List<Games> games;

	private Games TEST_GAME;

	private Games TEST_SAVED_GAME;
	
	
	@BeforeEach
	public void preTest() {
		games = new ArrayList<>();
		games.addAll(List.of(new Games(1l, "Sonic the hedgehog", "Platformer", "1980", "Sega", "Sega",
				"Sega Genesis"), 
				new Games(2l, "Hollow Knight", "MetroidVania", "24 February 2017", "Team Cherry", "Team Cherry", "PC"),
				new Games(3l, "Outer Wilds", "28 May 2019", "Puzzle", "Mobius Digital", "Annapurna Interactive", "PC")));
		 TEST_GAME = new Games( "Sonic the hedgehog", "Platformer", "1980", "Sega", "Sega", "Sega Genesis");
		 TEST_SAVED_GAME = new Games(1l, "Sonic the hedgehog", "Platformer", "1980", "Sega", "Sega",
				"Sega Genesis");
	}

	@Test
	public void testCreate() {

		// WHEN
		Mockito.when(this.repo.save(TEST_GAME)).thenReturn(TEST_SAVED_GAME);

		// THEN

		Assertions.assertThat(this.service.addgame(TEST_GAME)).isEqualTo(TEST_SAVED_GAME);

		// verify repo was accessed exactly once

		Mockito.verify(this.repo, Mockito.times(1)).save(TEST_GAME);

	}
	

	@Test
	public void testGetALL() {
		Mockito.when(repo.findAll()).thenReturn(games);
		Assertions.assertThat(service.getAllGames()).isEqualTo(games);
		Mockito.verify(repo).findAll();
	}

	@Test
	public void testUpdateGame() {
		long id = TEST_SAVED_GAME.getId();
		Games gameWithUpdates = new Games(
				TEST_SAVED_GAME.getId(), 
				TEST_SAVED_GAME.getgTitle(),
				TEST_SAVED_GAME.getgGenre(), 
				TEST_SAVED_GAME.getrDate(), 
				TEST_SAVED_GAME.getgDeveloper(),
				TEST_SAVED_GAME.getgProducer(),
				TEST_SAVED_GAME.getgPlatform());
		
	
		Mockito.when(repo.getById(id)).thenReturn(TEST_SAVED_GAME);
		Mockito.when(repo.save(TEST_SAVED_GAME)).thenReturn(gameWithUpdates);
		
		Assertions.assertThat(service.updateGame(id, gameWithUpdates)).isEqualTo(gameWithUpdates);
		
		
		Mockito.verify(repo).getById(id);
		
		Mockito.verify(repo).save(TEST_SAVED_GAME);
		
		
		

	}
	
	 
	@Test
	 public void testEquals() {

	 EqualsVerifier.forClass(Games.class).usingGetClass().verify();

	 } 
	
	@Test
		public void testRemoveGame() {
			long id = TEST_SAVED_GAME.getId();
			Mockito.when(repo.existsById(id)).thenReturn(true);
			service.removeGame(id);
			
			Mockito.verify(repo).existsById(id);
			Mockito.verify(repo).deleteById(id);
			
			
			
			
		}
	
	@Test 
	public void testGetbyId() {
		long id = TEST_SAVED_GAME.getId();
		Mockito.when(repo.findById(id)).thenReturn(Optional.of(TEST_SAVED_GAME));
		Mockito.when(repo.existsById(id)).thenReturn(true);
		
		
		Assertions.assertThat(service.getById(id)).isEqualTo(TEST_SAVED_GAME);
		
		Mockito.verify(repo).findById(id);
	}
		
	@Test
	public void testGetByIdException() {
		long id = 666;
		
		GameNotFoundException thrown = assertThrows(
				GameNotFoundException.class,
				() -> {service.getById(id);
		});
		
		String expected = "Game with id " + id + " cannot be found";
		assertThat(thrown); is (expected);
		
	
		
	}
}
