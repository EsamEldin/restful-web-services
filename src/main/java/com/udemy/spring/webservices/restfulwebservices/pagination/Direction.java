package com.udemy.spring.webservices.restfulwebservices.pagination;

/**
 * @author TFNP0469 Elghareb ahmed
 *
 */
public enum Direction {
    ASCENDING("ASC"), DESCENDING("DESC");
    private final String directionCode;
   
    private Direction(String direction) {
    this.directionCode = direction;
    }
    
    public String getDirectionCode() {
    return this.directionCode;
    }
}
