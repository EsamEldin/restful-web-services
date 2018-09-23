package com.udemy.spring.webservices.restfulwebservices.pagination;

/**
 * @author TFNP0469 Elghareb ahmed
 *
 */
public enum OrderBy {
    ID("id"), NAME("name"),BIRTHDATE("birthDate");
    private String OrderByCode;
    
    private OrderBy(String orderBy) {
    this.OrderByCode = orderBy;
    }
    public String getOrderByCode() {
    return this.OrderByCode;
    }
}