package com.udemy.spring.webservices.restfulwebservices.pagination;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.udemy.spring.webservices.restfulwebservices.entity.Post;
import com.udemy.spring.webservices.restfulwebservices.entity.PostRepository;
import com.udemy.spring.webservices.restfulwebservices.entity.User;
import com.udemy.spring.webservices.restfulwebservices.entity.UserRepository;;

/**
 * @author TFNP0469 Elghareb ahmed
 *
 */

// this service class can contain any paged method for different resources like user,posts
@Service
public class PaginationService {
    
    
    @Autowired
    private UserRepository userDaoRepository;
    
    @Autowired
    private PostRepository postDaoRepository;

        
        public Page<User> findPagedUsers(String orderBy, String direction, int page, int size) {
                Sort sort = null;
                
                if (direction.equals("ASC")) {
                   sort = new Sort(Direction.ASC, orderBy);
                }
                if (direction.equals("DESC")) {
                  sort = new Sort(Direction.DESC, orderBy);
                }
                Pageable pageable =PageRequest.of(page, size, sort);
                Page<User> data = userDaoRepository.findAll(pageable);
                return data;
     }
        
        public Page<Post> findPagedPosts(String orderBy, String direction, int page, int size) {
            Sort sort = null;
            
            if (direction.equals("ASC")) {
               sort = new Sort(Direction.ASC, orderBy);
            }
            if (direction.equals("DESC")) {
              sort = new Sort(Direction.DESC, orderBy);
            }
            Pageable pageable =PageRequest.of(page, size, sort);
            Page<Post> data = postDaoRepository.findAll(pageable);
            return data;
 }
}