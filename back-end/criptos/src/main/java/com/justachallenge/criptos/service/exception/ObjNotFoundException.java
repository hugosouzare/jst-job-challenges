package com.justachallenge.criptos.service.exception;

/**
* Exceção Not Found - Status 404
* 
**/
public class ObjNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ObjNotFoundException(String msg) {
		super(msg);
	}
	
	public ObjNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
