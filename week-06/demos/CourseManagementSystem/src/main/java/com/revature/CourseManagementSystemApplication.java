package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.web.exchanges.HttpExchangeRepository;
import org.springframework.boot.actuate.web.exchanges.InMemoryHttpExchangeRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CourseManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseManagementSystemApplication.class, args);
	}

	@Bean
	public HttpExchangeRepository httpExchangeRepository(){
		// This is a bean that will log the last 100 http exchanges with the application
		return new InMemoryHttpExchangeRepository();
	}

	/*
	At this point we can write a Spring Boot application, but there are some additional tools/topics that we can cover
	to help us run our project better

	Transactions
		Recall that a transaction is a series of DML statements executed together in a block with an all-or-nothing
		mindset. Before we implemented transactions on the JDBC/DAO layer since we needed direct access to the
		connection object. Now we'll leverage @Transactional in the service class

		@Transactional can be used on top of a method or a class. If used on top of a method, it will execute the
		entire method as a single transaction, and at the top of the class applies this feature to every method. You
		can specify certain things like transaction isolation levels and read phenomena

	Spring Boot Actuator
		This is a sub-project in Spring and it allows you to track real-time metrics about your application. This is
		very useful for applications already in production environments if you want to check on their status and
		see how they're running.

		We can modify the endpoints that are enabled and exposed as well as their content inside the
		application.properties file. Health is the only endpoint enabled by default but we can change that in the
		settings. A couple sample endpoints are listed below

			- Health: Shows the health metrics and status of various application components
			- Beans: Shows all of the registered beans in the ApplicationContext (IOC Container)
			- Mappings: Shows all exposed endpoints from our applications
			- HttpExchanges: This will show a log of the most recent application HTTP exchanges

	Spring Boot Devtools
		This is another Spring Boot sub project. This has certain tools that make your life as a Spring developer
		easier. Sometimes these can somewhat hit or miss, but if they work they definitely help. The biggest draw to
		the Spring Boot Devtools is the automatic restarts

	Project Lombok
		Project Lombok is a Java Library designed to reduce boilerplate code. Boilerplate code is code that is
		basically the same throughout several sections of your program, is generally very bloated and very repeatable.
		Good examples of this are in our model classes. Lombok reduces this code by using annotations for writing
		things automatically

	Unit Testing a Spring Boot app
		Unit testing in a Spring Boot application is virtually identical to what we've seen before, but the major
		difference is the setup of the test class and the version of JUnit.
	 */

}
