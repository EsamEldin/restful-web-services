package com.udemy.spring.webservices.restfulwebservices.entity;

/**
 * @author TFNP0469 Elghareb ahmed
 *
 */
public class HelloWorldBean  {

    private String messag;

    /**
     * @param string
     */
    public HelloWorldBean(String message) {
      this.messag=message;
    }

    public String getMessag() {
        return messag;
    }

    public void setMessag(String messag) {
        this.messag = messag;
    }
    
    
    
    

}
