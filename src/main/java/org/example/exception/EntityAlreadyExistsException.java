package org.example.exception;

public class EntityAlreadyExistsException extends Exception {
    public EntityAlreadyExistsException(String entityName) {
        super("This entity already exists: " + entityName);
    }
}
