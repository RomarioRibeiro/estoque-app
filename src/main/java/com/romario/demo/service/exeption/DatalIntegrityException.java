package com.romario.demo.service.exeption;

public class DatalIntegrityException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DatalIntegrityException (String msg) {
		super(msg);
	}
	
	public DatalIntegrityException (String msg, Throwable cause ) {
		super(msg,cause);
	}
}
