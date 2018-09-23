package com.udemy.spring.webservices.restfulwebservices.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.udemy.spring.webservices.restfulwebservices.Exceptions.UserNotFoundException;
import com.udemy.spring.webservices.restfulwebservices.dao.UserService;
import com.udemy.spring.webservices.restfulwebservices.entity.User;

/**
 * @author TFNP0469 Elghareb ahmed
 *
 */
@RestController
public class UserController {
    
    @Autowired
    private UserService userService;

    @RequestMapping(value="/users",method=RequestMethod.GET)
    public List<User> getUsers(){
        
        return userService.findAll();
    }
    
    @RequestMapping(value="/users/{id}",method=RequestMethod.GET)
    public Resource<User> getUser(@PathVariable("id") String id){
        
        User user=userService.findOne(Integer.parseInt(id));
        if(user==null)
            throw new UserNotFoundException("id="+id);
        
        Resource<User> resource = new Resource<User>(user);
        //this enaple us to create links from methods
        //we need to import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
        ControllerLinkBuilder linkTo= 
            linkTo(methodOn(this.getClass()).getUsers());
        
        //add link to resource
        resource.add(linkTo.withRel("all-users"));
        return resource; 
    }
    
    @RequestMapping(value="/users",method=RequestMethod.POST)
    public ResponseEntity<Object> save(@Valid @RequestBody User user){
        
       User savedUser=userService.save(user);
       URI location= ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(savedUser.getId())
        .toUri();
       
       
       
       return ResponseEntity.created(location).build();
         
    }
    
    //this will return 200 
    @RequestMapping(value="/users/{id}",method=RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable("id") String id){
        
        User user=userService.delete(Integer.parseInt(id));
        if(user==null)
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else   
          return new ResponseEntity<User>(user, HttpStatus.OK);
       
    }
    
    
  
    

}
