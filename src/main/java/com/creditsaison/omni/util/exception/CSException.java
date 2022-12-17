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
public class CSException extends Exception {

    private static final long serialVersionUID = 1L;
    private String errorCode;
    private String errorMessage;
    //This field is only used for logging uncaught exceptions at different log levels
    //This default value can be different in a subclass.
    private transient Level level = Level.INFO;

    public CSException(String errorCode, String errorMessage, Level level) {

        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.level = level;
    }

    public CSException(String errorCode, String errorMessage) {
        this(errorCode, errorMessage, Level.INFO);
    }

    public CSException(ErrorCode errorCode, String errorMessage, Level level) {
        this(errorCode.name(), errorMessage, level);
    }

    public CSException(ErrorCode errorCode, String errorMessage) {
        this(errorCode.name(), errorMessage, Level.INFO);
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void String(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "VException{" + "errorCode=" + errorCode + ", errorMessage=" + errorMessage + ", level=" + level + '}';
    }

}
