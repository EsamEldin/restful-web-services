package com.udemy.spring.webservices.restfulwebservices.pagination;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.spring.webservices.restfulwebservices.entity.Post;
import com.udemy.spring.webservices.restfulwebservices.entity.User;

/**
 * @author TFNP0469 Elghareb ahmed
 *
 */

// it is good to have one controller for paginated pages that represen resources 
// here we can 

@RestController
@RequestMapping(value = "/pagination")
public class PaginationController {
    

@Autowired
private PaginationService paginationService;
   

    @RequestMapping(
        value = "/pagedUsers", 
        params = { "orderBy", "direction", "page","size" }, 
        method = RequestMethod.GET)
    @ResponseBody
    public List<User> findUsersByPageAndSize(
        @RequestParam("orderBy") String orderBy,
        @RequestParam("direction") String direction, @RequestParam("page") int page,
        @RequestParam("size") int size) {
    
     if (!(direction.equals(Direction.ASCENDING.getDirectionCode())|| direction.equals(Direction.DESCENDING.getDirectionCode()))) {
         throw new PaginationSortingException("Invalid sort direction");
         }
     if (!(orderBy.equals(OrderBy.ID.getOrderByCode()) || orderBy.equals(OrderBy.NAME.getOrderByCode()))) {
         throw new PaginationSortingException("Invalid orderBy condition");
         }
    
     Page<User> list = paginationService.findPagedUsers(orderBy, direction, page, size);
     return list.getContent();
     
    }
    
    
    @RequestMapping(
        value = "/pagedPosts", 
        params = { "orderBy", "direction", "page","size" }, 
        method = RequestMethod.GET)
    @ResponseBody
    public Page<Post> findPostsByPageAndSize(
        @RequestParam("orderBy") String orderBy,
        @RequestParam("direction") String direction, @RequestParam("page") int page,
        @RequestParam("size") int size) {
    
     if (!(direction.equals(Direction.ASCENDING.getDirectionCode())|| direction.equals(Direction.DESCENDING.getDirectionCode()))) {
         throw new PaginationSortingException("Invalid sort direction");
         }
     if (!(orderBy.equals(OrderBy.ID.getOrderByCode()) || orderBy.equals(OrderBy.NAME.getOrderByCode()))) {
         throw new PaginationSortingException("Invalid orderBy condition");
         }
    
     Page<Post> list = paginationService.findPagedPosts(orderBy, direction, page, size);
     return list;
     
    }
    
    
    
    @ExceptionHandler(PaginationSortingException.class)
    public ResponseEntity<PagingSortingErrorResponse> exceptionHandler(Exception ex) {
        PagingSortingErrorResponse pagingSortingErrorResponse = new PagingSortingErrorResponse();
        pagingSortingErrorResponse.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
        pagingSortingErrorResponse.setMessage(ex.getMessage());
        return new ResponseEntity<PagingSortingErrorResponse>(pagingSortingErrorResponse, HttpStatus.OK);
    }

}
