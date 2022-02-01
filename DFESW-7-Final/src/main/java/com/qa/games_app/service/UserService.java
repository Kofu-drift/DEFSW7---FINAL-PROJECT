package com.qa.games_app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.games_app.data.entity.Games;
import com.qa.games_app.data.repository.UserRepository;

@Service
public class UserService {

	private UserRepository repo;
	
	@Autowired
	public UserService(UserRepository repo) {
		this.repo = repo;
	}
	
	
	
	// CRUD FUNCTIONALITY
	
	
		public Games addgame(Games games) {
		return this.repo.save(games);
		}
	
	
		public List<Games> getAllGames() {
		return this.repo.findAll();
		
	}
	
	
		public Games updateGame(Long id, Games newGame) {
		// Use findByID - returns optional so requires optional method
//			Optional<Games> existingOptional = this.repo.findById(id);
			Games update = this.repo.getById(id);
//			Games existing = existingOptional.get();
			// update the data
			update.setgDeveloper(newGame.getgDeveloper());
			update.setgGenre(newGame.getgGenre());
			update.setgPlatform(newGame.getgPlatform());
			update.setgProducer(newGame.getgProducer());
			update.setgTitle(newGame.getgTitle());
			update.setrDate(newGame.getrDate());
			// Save "newGame" back to the database and JPA updates for us
			return this.repo.save(update);
			
	}
	
	// Delete is a boolean to show whether the delete method has functioned properly
		public boolean removeGame(Long id) {
		this.repo.deleteById(id);
		// Checks repo to see if the id still exists
		boolean exist = this.repo.existsById(id);
		// returns true is id doesn't exist
		return !exist;
		}
	
	
	
	
	



}
