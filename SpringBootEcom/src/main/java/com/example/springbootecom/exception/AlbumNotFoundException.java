package com.example.springbootecom.exception;

public class AlbumNotFoundException extends RuntimeException{

    public AlbumNotFoundException(String message) {
        super(message);
    }
}
