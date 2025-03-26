package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}

	/*
	What is happening inside of this class? This class contains the main method for the project and it is in charge
	of starting up the entire application as needed. This class is also used for configuration but more on that later.
	This method starts the application, in the long run it will start up our server and allow us to keep the application
	running so we can listen for Web Traffic.

	Spring Core Annotations:
	@Bean
	@Scope
	@Configuration
	@ComponentScan
	Stereotype Annotations
	@Component
	@Repository
	@Service
	@Controller

	What is @SpringBootApplication?
	This is the one major annotation for Spring Boot itself. It's a combination of 3 other annotations
	- @Configuration
		- This marks this class as a configuration class and we can define Beans inside of here using @Bean
	- @ComponentScan
		- This searches the components in this package (com.revature) and its subpackages for classes with Stereotype
		annotations to make beans of them
	- @EnableAutoConfiguration
		- This allows for the automatic configuration of the ApplicationContext, this is our IoC (Inversion of Control)
		container. Basically allows Spring to create, manage, and destroy beans as it sees fit.
	 */

}
