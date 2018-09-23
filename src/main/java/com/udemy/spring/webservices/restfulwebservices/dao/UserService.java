package com.udemy.spring.webservices.restfulwebservices.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.udemy.spring.webservices.restfulwebservices.entity.User;

/**
 * @author TFNP0469 Elghareb ahmed
 *
 */

@Component("UserService")
public class UserService {
    
    private static List<User> users=new ArrayList<>();
    private int userCount=3;
    static{
        
        users.add(new User(1, "Essam", new Date()));
        users.add(new User(2, "Ahmed", new Date()));
        users.add(new User(3, "Emad", new Date()));
    }
    
    public List<User> findAll(){
        return users;
    }
    
    public User findOne(int id){
      for(User user:users){
          if(user.getId()==id)
              return user;
        
      }
      return null;
    }
    
    public User save(User user){
        if(user.getId()==0)
            user.setId(++userCount);
        
        users.add(user);
      return user;

    }
    
    public boolean update(User user){
        
//        for(User userInfo:users){
//            if(user.getId()==userInfo.getId())
//                return user;
//          
//        }
//        int size=users.size();
//        
//        users.add(user);
//        if(users.size()==size+1)
//            return true;
//        else 
           return false;

    }
    
    public User delete(int id){
        Iterator<User> iterator=users.iterator();
        
        while(iterator.hasNext()){
            User user=iterator.next();
            if(user.getId()==id){
                iterator.remove();
                return user;
            }
      
        }
        return null;
        
      }

}
