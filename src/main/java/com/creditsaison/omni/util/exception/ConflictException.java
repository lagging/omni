/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditsaison.omni.util.exception;

import org.apache.logging.log4j.Level;

/**
 *
 * @author ajith
 */
public class ConflictException extends CSException {

	private static final long serialVersionUID = 786249363287807047L;

	public ConflictException(ErrorCode errorCode, String errorMessage) {
		super(errorCode.name(), errorMessage);
	}

	public ConflictException(String errorCode, String errorMessage) {
		super(errorCode, errorMessage);
	}


	public ConflictException(ErrorCode errorCode, String errorMessage, Level level) {
		super(errorCode.name(), errorMessage, level);
	}

	public ConflictException(String errorCode, String errorMessage, Level level) {
		super(errorCode, errorMessage, level);
	}

}
