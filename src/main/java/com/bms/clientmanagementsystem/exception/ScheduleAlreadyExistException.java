package com.bms.clientmanagementsystem.exception;

public class ScheduleAlreadyExistException extends RuntimeException {
    public ScheduleAlreadyExistException(String message) {
        super(message);
    }
}
