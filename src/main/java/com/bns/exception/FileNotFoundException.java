package com.bns.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FileNotFoundException extends RuntimeException  {

	/**
	 * @author mehul
	 */
	private static final long serialVersionUID = 8551448289632530137L;
	  
	  public FileNotFoundException(String message) { 
		  super(message); 
	  }
	  
	  public FileNotFoundException(String message, Throwable cause) {
		  super(message, cause); 
	  }	 
}
