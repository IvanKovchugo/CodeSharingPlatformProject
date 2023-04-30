package com.ivankauchuha.codesharingplatformproject.exceptions;

public class NotFound extends RuntimeException{

    public NotFound(String id) {
        super(String.format("Code with UUID %s was not found", id));
    }
}
