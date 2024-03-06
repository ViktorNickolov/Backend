package com.bms.clientmanagementsystem.exception;

public class ClientAlreadyExistException extends RuntimeException {
    public ClientAlreadyExistException(String message) {
        super(message);
    }
}
