package com.udemy.spring.webservices.restfulwebservices.Exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author TFNP0469 Elghareb ahmed
 *
 */
@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandling 
extends ResponseEntityExceptionHandler{
    
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
        
        ExceptionResponse exceptionResponse=new 
            ExceptionResponse(new Date(), ex.getMessage(), 
                request.getDescription(false));
        
       return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    
    }
    //1-when throw UserNotFoundException get here
    //2-change your methods name
    //3-change the class parameter to be UserNotFoundException
    //4-change the return status
    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) throws Exception {
        
        ExceptionResponse exceptionResponse=new 
            ExceptionResponse(new Date(), ex.getMessage(), 
                request.getDescription(false));
        
       return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    
    }
    
    ////////////////////////////////////////////////////////////////
    //this for fireing the validation messages
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
        MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        ExceptionResponse exceptionResponse=new 
            ExceptionResponse(new Date(), "validation Failed", 
                ex.getBindingResult().getAllErrors().toString()); // getbindingresult show the reason for validation why not work
        
       return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
}
    

}
