package com.academics.utilities;

import com.academics.beans.AcademicsResponse;
import com.academics.beans.Error;
import com.academics.exceptions.AcademicsException;
import com.academics.exceptions.EmptyRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class AcademicsExceptionHandler {
    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<AcademicsResponse> noResourceFoundException(NoResourceFoundException ex,WebRequest request) {
        AcademicsResponse message = new AcademicsResponse();
        message.setData(null);
        message.setStatus(ErrorCodes.FAILED);
        Error error = new Error();
        error.setMessage(ex.getMessage());
        error.setReasonCode(ex.getStatusCode().toString());
        message.setError(error);
        return new ResponseEntity<>(message, ex.getStatusCode());
    }
    @ExceptionHandler({HttpMessageNotReadableException.class,EmptyRequestException.class})
    public ResponseEntity<AcademicsResponse> emptyRequest(HttpMessageNotReadableException ex,WebRequest request) {
        AcademicsResponse message = new AcademicsResponse();
        message.setData(null);
        message.setStatus(ErrorCodes.FAILED);
        Error error = new Error();
        error.setMessage(ex.getMessage());
        error.setReasonCode(HttpStatus.BAD_REQUEST.toString());
        message.setError(error);
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<AcademicsResponse> illegalStateException(IllegalStateException ex,WebRequest request) {
        AcademicsResponse message = new AcademicsResponse();
        message.setData(null);
        message.setStatus(ErrorCodes.FAILED);
        Error error = new Error();
        error.setMessage(ex.getMessage());
        error.setReasonCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
        message.setError(error);
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<AcademicsResponse> illegalArgumentException(IllegalArgumentException ex,WebRequest request) {
        AcademicsResponse message = new AcademicsResponse();
        message.setData(null);
        message.setStatus(ErrorCodes.FAILED);
        Error error = new Error();
        error.setMessage(ex.getMessage());
        error.setReasonCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
        message.setError(error);
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<AcademicsResponse> noSuchElementException(NoSuchElementException ex,WebRequest request) {
        AcademicsResponse message = new AcademicsResponse();
        message.setData(null);
        message.setStatus(ErrorCodes.FAILED);
        Error error = new Error();
        error.setMessage(ex.getMessage());
        error.setReasonCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
        message.setError(error);
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(AcademicsException.class)
    public ResponseEntity<AcademicsResponse> academicsException(AcademicsException ex,WebRequest request) {
        AcademicsResponse message = new AcademicsResponse();
        message.setData(null);
        message.setStatus(ErrorCodes.FAILED);
        Error error = new Error();
        error.setMessage(ex.getMessage());
        error.setReasonCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
        message.setError(error);
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
