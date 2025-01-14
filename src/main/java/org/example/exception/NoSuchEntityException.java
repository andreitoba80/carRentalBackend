package org.example.exception;

public class NoSuchEntityException extends Exception {
    public NoSuchEntityException(String entityName) {
        super("Entity \"" + entityName + " does not exist...");
    }
}
