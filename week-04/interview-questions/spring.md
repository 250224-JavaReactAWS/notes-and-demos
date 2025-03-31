# General Questions from Client Playbook

- What is Spring? Spring Boot?
- How would you set up a spring boot project?
- What are some annotations you've used?
- What is the purpose of the @Component annotation
- What are Spring Beans?
- What Bean Scopes are you aware of?
- Describe Spring MVC Controllers?
- What is a "REST api"?
- How would you handle http calls/mappings using Spring?
- What is RestTemplate? What does it let us do?
- What is spring data? What are the JPA annotations?
- What does the @entity annotation do
- How do you handle database interactions with spring data?
- What is Autowiring?
- What is spring initializer?

## Spring Core

-  What are Spring Projects and Spring Modules?
    
-  What is IOC and what does the IOC Container do?
    
-  What is dependency injection and what are some of the benefits of using dependency injection?
    
-  What types of dependency injection does Spring support?
    
-  What is the Spring Bean lifecycle?
    
-  What is bean wiring? What about autowiring?
    
-  What are the different ways that Spring can wire beans?
    
-  What are the scopes of Spring beans? Which is default?
    
-  What is the concept of component scanning and how would you set it up?
    
-  What are the benefits and limitations of Java configuration?
    
-  What does the @Configuration and @Bean annotations do?
    
-  What is @Value used for?
    
-  What is Spring Expression Language? What can you reference using SpEL? What is the difference between $ and # in @value expressions?
    
<br>

## Spring Web
    
-  List some stereotype annotations. What are the differences between these?
    
-  How would you declare which HTTP requests you’d like a controller to process?
    
-  What is the difference between @RequestMapping and @GetMapping?
    
-  How to declare the data format your controller expects from requests or will create in responses?
    
-  How would you extract query and path parameters from a request URL in your controller?
    
-  What concerns is the controller layer supposed to handle vs the service layer?
    
-  How would you specify HTTP status codes to return from your controller?
    
-  How do you handle exceptions thrown in your code from your controller? What happens if you don’t set up any exception handling?
    
-  How would you consume an external web service using Spring?
    
<br>

## Spring Data JPA

-  What is Spring Data?
    
-  What is the Template design pattern and what is the JDBC template?
    
-  What does @Transactional do? 
        
-  What interfaces are available in Spring Data JPA?
    
-  What is the difference between JPARepository and CrudRepository?
    
-  What is the naming conventions for methods in Spring Data repositories?
    
-  How are Spring repositories implemented by Spring at runtime?
    
-  What is @Query used for?
    
<br>

## Spring Boot

-  How is Spring Boot different from legacy Spring applications? What does it mean that it is “opinionated”?
    
-  What does “convention over configuration” mean?
    
-  What annotation would you use for Spring Boot apps? What does it do behind the scenes?
    
-  How does Boot’s autoconfiguration work?
    
-  What is the advantage of having an embedded Tomcat server?
    
-  What is the significance of the Spring Boot starter POM?
    
-  What is the Spring Boot actuator? What information can it give you?
    
-  What files would you use to configure Spring Boot applications?
    
-  What is the benefit of using Spring Boot profiles?