package com.justachallenge.criptos.service.exception;

/**
* Exceção para Bad Requests - Status 400
**/
public class BadRequestException extends RuntimeException {


	private static final long serialVersionUID = 1L;

	public BadRequestException(String msg) {
		super(msg);
	}
	
	public BadRequestException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
