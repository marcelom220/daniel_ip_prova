package com.daniel_ip.prova.util.exception;

public class ApplicationException extends RuntimeException {

	private static final long serialVersionUID = 1L;
    
	public ApplicationException(String msg) {
		super(msg);
	}
}
