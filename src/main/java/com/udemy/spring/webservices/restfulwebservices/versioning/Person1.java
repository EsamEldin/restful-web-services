package com.udemy.spring.webservices.restfulwebservices.versioning;

/**
 * @author TFNP0469 Elghareb ahmed
 *
 */
public class Person1 {
    private String name;

    /**
     * @param name
     */
    public Person1(String name) {
        super();
        this.name = name;
    }

    /**
     * 
     */
    public Person1() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    

}
