package com.example.demo.exception;

public class EntityNotExistsException extends RuntimeException{
    private String message;

    public EntityNotExistsException() {}

    public EntityNotExistsException(String msg)
    {
        super(msg);
        this.message = msg;
    }
}
