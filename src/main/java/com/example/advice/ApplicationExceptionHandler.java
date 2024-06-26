package com.example.advice;

import com.example.exception.GroceryItemNotAvailableException;
import com.example.exception.UserAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleInvalidArgument(MethodArgumentNotValidException ex){
        Map<String, String> errorMessages = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> errorMessages.put(error.getField(),error.getDefaultMessage()));
        return errorMessages;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(GroceryItemNotAvailableException.class)
    public Map<String,String> handleInvalidArgument(GroceryItemNotAvailableException ex){
        Map<String, String> errorMessages = new HashMap<>();
        errorMessages.put("Error Message",ex.getMessage());
        return errorMessages;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public Map<String,String> handleUserAlreadyExists(Exception ex){
        Map<String, String> errorMessages = new HashMap<>();
        errorMessages.put("Error Message","User already exists");
        return errorMessages;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UsernameNotFoundException.class)
    public Map<String,String> handleUserNotFound(Exception ex){
        Map<String, String> errorMessages = new HashMap<>();
        errorMessages.put("Error Message","User not Found");
        return errorMessages;
    }


}
