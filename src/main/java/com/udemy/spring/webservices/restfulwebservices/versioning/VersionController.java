package com.udemy.spring.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author TFNP0469 Elghareb ahmed
 *
 */
@RestController
public class VersionController {
    
    
    @RequestMapping(value="/person/param",method=RequestMethod.GET)
    public Person2 person(){
        
        return new Person2(new Name("Essam", "Eldin"));
    }
    
    @RequestMapping(value="/person/param", params="version=v1",method=RequestMethod.GET)
    public Person1 persionVersion1(){
        
        return new Person1("Essam Eldin");
    }
    
    @RequestMapping(value="/person/param", params="version=v2",method=RequestMethod.GET)
    public Person2 persionVersion2(){
        
        return new Person2(new Name("Essam", "Eldin"));
    }
    
    @RequestMapping(value="/person/header", headers="version=v1",method=RequestMethod.GET)
    public Person1 persionVersion1Headers(){
        
        return new Person1("Essam Eldin");
    }
    
    @RequestMapping(value="/person/header", headers="version=v2",method=RequestMethod.GET)
    public Person2 persionVersion2Headers(){
        
        return new Person2(new Name("Essam", "Eldin"));
    }
    
//    @RequestMapping(value="/person/produces", produces="application/v1",method=RequestMethod.GET)
//    public Person1 persionVersion1Produces(){
//        
//        return new Person1("Essam Eldin");
//    }
//    
//    @RequestMapping(value="/person/produces", produces="application/v2",method=RequestMethod.GET)
//    public Person2 persionVersion2Produces(){
//        
//        return new Person2(new Name("Essam", "Eldin"));
//    }

}
