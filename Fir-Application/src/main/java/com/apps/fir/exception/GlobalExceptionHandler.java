package com.apps.fir.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserException.class)
    public ResponseEntity<MyError> userExceptionHandler(UserException se, WebRequest req){

        MyError err= new MyError();
        err.setTimestamp(LocalDateTime.now());
        err.setMessage(se.getMessage());
        err.setDetails(req.getDescription(false));

        return new ResponseEntity<MyError>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FirException.class)
    public ResponseEntity<MyError> firExceptionHandler(FirException se, WebRequest req){

        MyError err= new MyError();
        err.setTimestamp(LocalDateTime.now());
        err.setMessage(se.getMessage());
        err.setDetails(req.getDescription(false));

        return new ResponseEntity<MyError>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(LoginException.class)
    public ResponseEntity<MyError> loginExceptionHandler(LoginException se, WebRequest req){

        MyError err= new MyError();
        err.setTimestamp(LocalDateTime.now());
        err.setMessage(se.getMessage());
        err.setDetails(req.getDescription(false));

        return new ResponseEntity<MyError>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyError> exceptionHandler(Exception se, WebRequest req){

        MyError err= new MyError();
        err.setTimestamp(LocalDateTime.now());
        err.setMessage(se.getMessage());
        err.setDetails(req.getDescription(false));

        return new ResponseEntity<MyError>(err, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
