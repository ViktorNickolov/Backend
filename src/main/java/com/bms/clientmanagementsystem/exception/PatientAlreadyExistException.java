package com.bms.clientmanagementsystem.exception;

public class PatientAlreadyExistException extends RuntimeException {
    public PatientAlreadyExistException(String message) {
        super(message);
    }
}
