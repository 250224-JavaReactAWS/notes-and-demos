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
	 */

}
