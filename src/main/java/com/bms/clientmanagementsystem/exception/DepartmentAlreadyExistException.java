package com.bms.clientmanagementsystem.exception;

public class DepartmentAlreadyExistException extends RuntimeException {
    public DepartmentAlreadyExistException(String message) {
        super(message);
    }
}
