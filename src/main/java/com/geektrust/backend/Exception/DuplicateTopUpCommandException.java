package com.geektrust.backend.Exception;

public class DuplicateTopUpCommandException extends RuntimeException{
    public DuplicateTopUpCommandException()
    {
        super();
    }
    public DuplicateTopUpCommandException(String msg)
    {
        super(msg);
    }
}
