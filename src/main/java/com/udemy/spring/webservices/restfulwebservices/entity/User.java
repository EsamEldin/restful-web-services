package com.udemy.spring.webservices.restfulwebservices.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author TFNP0469 Elghareb ahmed
 *
 */
@ApiModel(description="all details about user") // to change in swagger api
@Entity
public class User {
    
    @Id
    @GeneratedValue
    private int id;
    
    
    @Size(min=2,message="name should have at least 2 char")
    @ApiModelProperty(notes="name should have at least 2 char")
    private String name;
    
    @Past
    @ApiModelProperty(notes="birth date should be in the past")
   // @JsonIgnore
    private Date birthDate;
    
    @OneToMany(mappedBy="user") //this is a field in user
    private List<Post> posts;
    
    public User(){}

    /**
     * @param id
     * @param name
     * @param birthDate
     */
    public User(int id, String name, Date birthDate) {
        super();
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", posts=" + posts + "]";
    }
    
    
    
    

}
