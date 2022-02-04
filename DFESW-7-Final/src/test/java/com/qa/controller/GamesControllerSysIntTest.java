package com.qa.controller;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.games_app.Dfesw7FinalApplication;
import com.qa.games_app.data.entity.Games;
import com.qa.games_app.data.repository.UserRepository;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = Dfesw7FinalApplication.class)

@AutoConfigureMockMvc
@Transactional
public class GamesControllerSysIntTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private UserRepository repo;

	private List<Games> games;

	private Long nextNewElementsId;

	@BeforeEach
	public void preTest() {
		List<Games> newData = List.of(
				new Games(1l, "Undertale", "JRPG", "15 September 2015", "Toby Fox", "Toby Fox", "PC"),
				new Games(2l, "Hollow Knight", "MetroidVania", "24 February 2017", "Team Cherry", "Team Cherry", "PC"),
				new Games(3l, "Outer Wilds", "28 May 2019", "Puzzle", "Mobius Digital", "Annapurna Interactive", "PC"));

		games = new ArrayList<>();
		games.addAll(repo.saveAll(newData));
		int size = games.size();
		nextNewElementsId = games.get(size - 1).getId() + 1;

	}
	
	 
	  @AfterEach
	  public void teardown() {
	    repo.deleteAll();
	  }
	  

	@Test
	public void createTest() throws Exception {
		Games testGame = new Games("Chrono Trigger", "JRPG", "11 March 1995", "Square", "Square", "SNES");
		Games expectedGame = new Games(nextNewElementsId, testGame.getgTitle(), testGame.getgGenre(),
				testGame.getrDate(), testGame.getgDeveloper(), testGame.getgProducer(), testGame.getgPlatform());

		// Mock request

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.POST, "/create");

		mockRequest.contentType(MediaType.APPLICATION_JSON); // Type of content in the body

		mockRequest.content(objectMapper.writeValueAsString(testGame)); // Sets JSON body to string

		mockRequest.accept(MediaType.APPLICATION_JSON);

		ResultMatcher statusMatcher = MockMvcResultMatchers.status().isCreated();
		ResultMatcher contentMatcher = MockMvcResultMatchers.content()
				.json(objectMapper.writeValueAsString(expectedGame));

		mockMvc.perform(mockRequest).andExpect(statusMatcher).andExpect(contentMatcher);

	}

	@Test
	public void getGamesTest() throws Exception {
		String returnGames = objectMapper.writeValueAsString(games);
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.GET, "/getAll");
		mockRequest.accept(MediaType.APPLICATION_JSON);
		ResultMatcher statusMatcher = MockMvcResultMatchers.status().isOk();
		ResultMatcher contentMatcher = MockMvcResultMatchers.content().json(returnGames);
		mockMvc.perform(mockRequest).andExpect(statusMatcher).andExpect(contentMatcher);

	}

	@Test
	public void getGamesByIdTest() throws Exception {
		Long testId = games.get(0).getId();
		

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.GET,
				"/getById/" + testId);
		mockRequest.accept(MediaType.APPLICATION_JSON);
		mockRequest.contentType(MediaType.APPLICATION_JSON);
		mockRequest.content(objectMapper.writeValueAsString(games));

		ResultMatcher statusMatcher = MockMvcResultMatchers.status().isOk();

		mockMvc.perform(mockRequest).andExpect(statusMatcher);

	}

	@Test
	public void updateGamesTest() throws Exception {
		Long testId = games.get(0).getId();
		Games testGameUpdate = new Games("Sonic the hedgehog", "Platformer", "1980", "Sega", "Sega", "Sega Genesis");
		Games expectedGame = new Games(testId, "Sonic the hedgehog", "Platformer", "1980", "Sega", "Sega",
				"Sega Genesis");
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.PUT, "/update/" + testId);
		mockRequest.accept(MediaType.APPLICATION_JSON);
		mockRequest.contentType(MediaType.APPLICATION_JSON);
		mockRequest.content(objectMapper.writeValueAsString(testGameUpdate));
		String expectedJSON = objectMapper.writeValueAsString(expectedGame);
		ResultMatcher statusMatcher = MockMvcResultMatchers.status().isAccepted();
		ResultMatcher contentMatcher = MockMvcResultMatchers.content().json(expectedJSON);

		mockMvc.perform(mockRequest).andExpect(statusMatcher).andExpect(contentMatcher);

	}

	@Test
	public void deleteGamesTest() throws Exception {

		Long testId = games.get(0).getId();
		;

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.DELETE,
				"/delete/" + testId);

		mockRequest.accept(MediaType.APPLICATION_JSON);
		mockRequest.contentType(MediaType.APPLICATION_JSON);
		mockRequest.content(objectMapper.writeValueAsString(games));

		ResultMatcher statusMatcher = MockMvcResultMatchers.status().isOk();

		mockMvc.perform(mockRequest).andExpect(statusMatcher);
	}

}
