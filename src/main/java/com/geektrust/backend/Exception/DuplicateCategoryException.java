package com.geektrust.backend.Exception;

public class DuplicateCategoryException extends RuntimeException{
    public DuplicateCategoryException()
    {
     super();
    }
    public DuplicateCategoryException(String msg)
    {
     super(msg);
    }
}
