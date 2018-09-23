package com.udemy.spring.webservices.restfulwebservices.dao;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.udemy.spring.webservices.restfulwebservices.Exceptions.UserNotFoundException;
import com.udemy.spring.webservices.restfulwebservices.entity.Post;
import com.udemy.spring.webservices.restfulwebservices.entity.PostRepository;
import com.udemy.spring.webservices.restfulwebservices.entity.User;
import com.udemy.spring.webservices.restfulwebservices.entity.UserRepository;

/**
 * @author TFNP0469 Elghareb ahmed
 *
 */
@RestController
public class UserJpaResource {

    
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @RequestMapping(value="/jpa/users",method=RequestMethod.GET)
    public List<User> getUsers(){
        
        return userRepository.findAll();
    }
    
    @RequestMapping(value="/jpa/users/{id}",method=RequestMethod.GET)
    public Resource<User> getUser(@PathVariable("id") int id){
        
        Optional<User> user=userRepository.findById(id);
        if(!user.isPresent())
            throw new UserNotFoundException("id="+id);
        
        Resource<User> resource = new Resource<User>(user.get());
        //this enaple us to create links from methods
        //we need to import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
        ControllerLinkBuilder linkTo= 
            linkTo(methodOn(this.getClass()).getUsers());
        
        //add link to resource
        resource.add(linkTo.withRel("all-users"));
        return resource; 
    }
    
    @RequestMapping(value="/jpa/users",method=RequestMethod.POST)
    public ResponseEntity<Object> save(@Valid @RequestBody User user){
        
       User savedUser=userRepository.save(user);
       URI location= ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(savedUser.getId())
        .toUri();
       
       
       
       return ResponseEntity.created(location).build();
         
    }
    
    //this will return 200 
    @RequestMapping(value="/jpa/users/{id}",method=RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") int id){
        
       userRepository.deleteById(id);
       
    }
    
    @RequestMapping(value="/jpa/users/{id}/posts",method=RequestMethod.GET)
    public List<Post> getPostsForUser(@PathVariable("id") int id){
        Optional<User> userOptional= userRepository.findById(id);
        if(!userOptional.isPresent()){
            throw new UserNotFoundException("id-"+id);
        }
        
       return userOptional.get().getPosts();
       
    }
    
    @RequestMapping(value="/jpa/users/{id}/posts",method=RequestMethod.POST)
    public ResponseEntity<Object> savePosts(@PathVariable int id,@RequestBody Post post){
        
        
        Optional<User> userOptional=userRepository.findById(id);
        if(!userOptional.isPresent())
            throw new UserNotFoundException("id="+id);
        
        
        User user=userOptional.get();
        post.setUser(user);
       Post savedPost=postRepository.save(post);
      

       URI location= ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(savedPost.getId())
        .toUri();
       
       
       
       return ResponseEntity.created(location).build();
         
    }
    

}
