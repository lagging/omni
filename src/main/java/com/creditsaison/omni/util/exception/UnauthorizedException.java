package com.creditsaison.omni.util.exception;

import org.apache.logging.log4j.Level;


public class UnauthorizedException extends CSException {

	private static final long serialVersionUID = 1L;

	public UnauthorizedException(ErrorCode errorCode, String errorMessage) {
		super(errorCode, errorMessage);
	}

	public UnauthorizedException(ErrorCode errorCode, String errorMessage, Level level) {
		super(errorCode, errorMessage, level);
	}
}
