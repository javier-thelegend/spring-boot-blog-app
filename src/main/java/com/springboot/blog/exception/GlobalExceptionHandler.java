package com.springboot.blog.exception;

import com.springboot.blog.payload.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice //Handle Exceptions Globally
public class GlobalExceptionHandler {

    //Handle Specific Exceptions
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), webRequest.getDescription(false));
        return  new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MismatchedException.class)
    public ResponseEntity<ErrorDetails> handleMismatchedException(MismatchedException exception, WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), webRequest.getDescription(false));
        return  new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    //Global Exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGlobalException(MethodArgumentNotValidException exception, WebRequest webRequest){
        //Instead of Comment those lines the approach could be create another method only for MethodArgumentNotValidException
//        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), webRequest.getDescription(false));
//        return  new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError)error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
