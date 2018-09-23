package com.udemy.spring.webservices.restfulwebservices;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@SpringBootApplication
public class RestfulWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServicesApplication.class, args);
	}
	
	@Bean
	public LocaleResolver localResolver(){
	    //this avoid me to use ->
	    //@RequestHeader(name="Accept-language",required=false) Locale locale    in each method parameters
	    //2- allow me to configure the base for resource bundle without needing to create bean ->spring.messages.basename=message
	    AcceptHeaderLocaleResolver localeResolver=new AcceptHeaderLocaleResolver();
	    localeResolver.setDefaultLocale(Locale.US);
	    return localeResolver;
	}
	
}
