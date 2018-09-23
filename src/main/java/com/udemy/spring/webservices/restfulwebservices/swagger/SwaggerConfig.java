package com.udemy.spring.webservices.restfulwebservices.swagger;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author TFNP0469 Elghareb ahmed
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    
    // to enhance the parts of swagger doc we should override the elements for example 
    //API INFO we get it from ApiInfo class and override it be changing values
    public static final Contact DEFAULT_CONTACT = new Contact("Essam Eldin", "www.essam.com", "udemy cource");
    public static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
        "Awsome Api Title", "Api Documentation", "1.0", "urn:tos",
        DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
   
    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<String>
    (Arrays.asList("application/json","application/xml"));
    

    //go to /swagger-ui.html -> we can share this with customer
    ///v2/api-docs -> we can share this with customer
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(DEFAULT_API_INFO)
            .produces(DEFAULT_PRODUCES_AND_CONSUMES);
    }
    
    //here define all paths and apis

}
