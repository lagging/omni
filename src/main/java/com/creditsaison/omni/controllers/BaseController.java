package com.creditsaison.omni.controllers;


import com.creditsaison.omni.commons.*;
import com.creditsaison.omni.util.exception.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BaseController {

    public BaseController() {
    }

    protected <T, E extends Throwable> ResponseEntity<?> executeTask(SupplierThrowsException<T, E> fn) {
        return Try.withThrowable(fn)
                  .map(this::getSuccessResponse)
                  .recover(this::getFailureResponse)
                  .get();
    }

    private <T> ResponseEntity<?> getSuccessResponse(T t) {
        return new ResponseEntity<>(new SuccessResponse<>(t), HttpStatus.OK);
    }

    private ResponseEntity<?> getFailureResponse(Throwable throwable) {
        HttpStatus httpStatus = getStatusCode(throwable);
        if (throwable instanceof CSException) {
            CSException vexception = (CSException) throwable;
            return this.getFailureResponse(0, vexception.getErrorCode(), vexception.getMessage(), httpStatus);
        }
        log.error("Error while calling service", throwable);
        return new ResponseEntity<>(this.getFailureResponse("Ops something went wrong"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private HttpStatus getStatusCode(Throwable throwable) {

        if (throwable instanceof BadRequestException) {
            return HttpStatus.BAD_REQUEST;
        }
        if (throwable instanceof UnauthorizedException) {
            return HttpStatus.UNAUTHORIZED;
        }
        if (throwable instanceof ForbiddenException) {
            return HttpStatus.FORBIDDEN;
        }
        if (throwable instanceof NotFoundException) {
            return HttpStatus.NOT_FOUND;
        }
        if (throwable instanceof ConflictException) {
            return HttpStatus.CONFLICT;
        }
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

    private ResponseEntity<?> getFailureResponse(int code, ErrorCode errorCode, String errorMessage, HttpStatus HttpStatus) {
        ErrorResponse errorResponse = new ErrorResponse(errorCode, errorMessage);
        errorResponse.setStatusCode(code);
        return new ResponseEntity<>(errorResponse, HttpStatus);
    }

    private ResponseEntity<?> getFailureResponse(int code, String errorCode, String errorMessage, HttpStatus HttpStatus) {
        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.valueOf(errorCode), errorMessage);
        errorResponse.setStatusCode(code);
        return new ResponseEntity<>(errorResponse, HttpStatus);
    }

    private Response<?> getFailureResponse(String errorMessage) {
        return new ErrorResponse(errorMessage);
    }


}
