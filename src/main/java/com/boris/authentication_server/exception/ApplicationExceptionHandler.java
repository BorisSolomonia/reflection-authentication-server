package com.boris.authentication_server.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handlerException(UserAlreadyExistsException e) {
        return new ResponseEntity<>(new ErrorResponse("User already exists"), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlerException(UserNotFoundException e) {
        return new ResponseEntity<>(new ErrorResponse("User Not Found"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ErrorResponse> handlerException(AuthenticationException e) {
        return new ResponseEntity<>(new ErrorResponse("Invalid Credentials"), HttpStatus.UNAUTHORIZED);
    }
}
