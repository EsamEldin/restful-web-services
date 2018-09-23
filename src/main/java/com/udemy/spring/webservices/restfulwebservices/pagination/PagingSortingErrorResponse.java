package com.udemy.spring.webservices.restfulwebservices.pagination;

/**
 * @author TFNP0469 Elghareb ahmed
 *
 */

public class PagingSortingErrorResponse {
    
    private int errorCode;
    private String message;
    // Setter Getters
   
    public int getErrorCode() {
        return errorCode;
    }
    public void setErrorCode(int errorCode) {
    this.errorCode = errorCode;
    }
    public String getMessage() {
        return message;
    }
public void setMessage(String message) {
    this.message = message;
}


}
