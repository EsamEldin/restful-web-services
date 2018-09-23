package com.udemy.spring.webservices.restfulwebservices.versioning;

/**
 * @author TFNP0469 Elghareb ahmed
 *
 */
public class Person2 {
    
    private Name name;

    /**
     * @param name
     */
    public Person2(Name name) {
        super();
        this.name = name;
    }

    /**
     * 
     */
    public Person2() {
        super();
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }
    
    

}
