package com.academics.exceptions;

public class EmptyRequestException extends Throwable {
    public EmptyRequestException(String message){
        super(message);
    }
}
