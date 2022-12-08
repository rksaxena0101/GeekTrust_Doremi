package com.geektrust.backend.Factory.Exceptions;

public class DateTimeNotExistException extends RuntimeException{
    public DateTimeNotExistException() {
        super();
    }   
    public DateTimeNotExistException(String msg) {
        super(msg);
    }
}
