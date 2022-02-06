package com.qa.games_app.exceptions;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class GameNotFoundException extends EntityNotFoundException {

	private static final long serialVersionUID = 1L;
	
	public GameNotFoundException(String message) {
		super(message);
	}
	
	

}
