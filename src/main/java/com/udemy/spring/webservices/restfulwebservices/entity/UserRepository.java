package com.udemy.spring.webservices.restfulwebservices.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author TFNP0469 Elghareb ahmed
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
