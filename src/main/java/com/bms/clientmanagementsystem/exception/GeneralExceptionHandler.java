package com.bms.clientmanagementsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AppointmentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleAppointmentNotFoundException(AppointmentNotFoundException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }

    @ExceptionHandler(ClinicAlreadyExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<Object> handleClinicAlreadyExistException(ClinicAlreadyExistException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }

    @ExceptionHandler(ClinicNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleClinicNotFoundException(ClinicNotFoundException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }

    @ExceptionHandler(DocumentAlreadyExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<Object> handleDocumentAlreadyExistException(DocumentAlreadyExistException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }

    @ExceptionHandler(DocumentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleDocumentNotFoundException(DocumentNotFoundException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }

    @ExceptionHandler(DocumentTypeAlreadyExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<Object> handleDocumentTypeAlreadyExistException(DocumentTypeAlreadyExistException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }

    @ExceptionHandler(DocumentTypeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleDocumentTypeNotFoundException(DocumentTypeNotFoundException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }

    @ExceptionHandler(ClientAlreadyExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<Object> handleClientAlreadyExistException(ClientAlreadyExistException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }

    @ExceptionHandler(ClientNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleClientNotFoundException(ClientNotFoundException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }

    @ExceptionHandler(ClientCaseNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleClientCaseNotFoundException(ClientCaseNotFoundException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }

    @ExceptionHandler(StatusAlreadyExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<Object> handleStatusAlreadyExistException(StatusAlreadyExistException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }

    @ExceptionHandler(StatusNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleStatusNotFoundException(StatusNotFoundException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }

    @ExceptionHandler(StatusHistoryAlreadyExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<Object> handleStatusHistoryAlreadyExistException(StatusHistoryAlreadyExistException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }

    @ExceptionHandler(StatusHistoryNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleStatusHistoryNotFoundException(StatusHistoryNotFoundException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }
}
