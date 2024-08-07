package org.example.exception;

public class NotFoundException extends Exception {
    public NotFoundException(String entityName) {
        super("Entity: " + entityName + " not found...");
    }
}
