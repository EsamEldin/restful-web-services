package com.udemy.spring.webservices.restfulwebservices.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author TFNP0469 Elghareb ahmed
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

    /**
     * @param string
     */
    public UserNotFoundException(String message) {
       super(message);
    }

}
