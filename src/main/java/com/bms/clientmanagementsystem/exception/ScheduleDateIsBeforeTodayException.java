package com.bms.clientmanagementsystem.exception;

public class ScheduleDateIsBeforeTodayException extends RuntimeException {
    public ScheduleDateIsBeforeTodayException(String message) {
        super(message);
    }
}
