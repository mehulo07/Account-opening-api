package com.bns.exception;

public class FileStorageException extends RuntimeException  {

	/**
	 * @author mehul
	 */
	private static final long serialVersionUID = -8220064866862542919L;

	
		public FileStorageException(String message) {
	        super(message);
	    }

	    public FileStorageException(String message, Throwable cause) {
	        super(message, cause);
	    }
}

