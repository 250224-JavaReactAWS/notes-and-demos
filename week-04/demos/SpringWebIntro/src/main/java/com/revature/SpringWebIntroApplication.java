package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringWebIntroApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebIntroApplication.class, args);
	}

	/*
	Just by adding in the Spring Boot Starter Web dependency we were able to get access to the Tomcat Server
	Tomcat is the default embedded server that we use for our web requests, think of it as an alternative to Javalin

	The default endpoint for tomcat is http://localhost:8080, we can change the port number in the application.properties
	if desired


	ANNOTATIONS USED IN SPRING WEB:
	@RestController -> Combo of @Controller and @ResponseBody, Marks the class as a REST controller
	@ResponseBody -> Method or class level, specifies the returned object from the method is the body of the response
	@RequestBody -> Allows us to take in the body of the request as a specific type
	@RequestMapping -> Class level annotation to provide a parent mapping for all API endpoints
	@Get/Post/Put/DeleteMapping -> Method level annotations to create handlers for GET/POST/PUT/DELETE request
	@PathVariable -> Allows us to extract a variable from the URL path (http://localhost:8080/creatures/{creatureId})
	@RequestParam -> Allows us to capture values passed as a query/request param (http://localhost:8080/creatures?country=USA)
	@ExceptionHandler -> Allows us to create a method specifically designed to handle errors that come up
	@ResponseStatus -> Changes the default status code of a method to whatever is specified
	 */

}
