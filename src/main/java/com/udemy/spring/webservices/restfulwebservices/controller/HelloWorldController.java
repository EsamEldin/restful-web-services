package com.udemy.spring.webservices.restfulwebservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.spring.webservices.restfulwebservices.entity.HelloWorldBean;

/**
 * @author TFNP0469 Elghareb ahmed
 *
 */

@RestController
@ResponseBody()
public class HelloWorldController {
    // for internationalization
    @Autowired
    private MessageSource messageSource;

    
    
   @RequestMapping(method=RequestMethod.GET,path="/hello-world")
    public String HelloWorld(){
        
        return "Hello World ya essam";
    }
   
   @RequestMapping(method=RequestMethod.GET,path="/hello")
   public HelloWorldBean HelloWorldBean(){
       
       return new HelloWorldBean("Hello world Bean");
   }
   
   @RequestMapping(method=RequestMethod.GET,path="/hello/{id}")
   public HelloWorldBean HelloWorldBean(@PathVariable("id") String id){
       
       return new HelloWorldBean("Hello world Bean "+id);
   }
   
   @RequestMapping(method=RequestMethod.GET,path="/hello-world-interna")
   public String HelloWorldIntern(){
       
       return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
   }
   
   

}
