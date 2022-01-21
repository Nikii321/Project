package com.example.myfirstprojectaboutauthors.exception;

public class NoSuchAuthorOrBookException extends RuntimeException{
    public NoSuchAuthorOrBookException(String message) {
        super(message);
    }
}
