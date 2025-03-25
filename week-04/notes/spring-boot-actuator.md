# Spring Boot DevTools

Spring Boot DevTools implements two useful features

-   Cache Disabling: cache is helpful in production, but can hinder development workflow, DevTools automatically diables caching
-   Automatic Restarts: anytime you make a change to your application, developement will server will restart automatically

# Spring Boot Actuator

Spring Boot Actuator is a Spring Library that exposes tools for monitoring and gatering metric about a running application

You can utilize Actuators predefined endpoints to view different information about your application:

-   /health: shows the applications health
-   /beans: shows a list of available beans in the BeanFactory
-   /env: return the current application properties
-   /info: return general data, this can be customized
-   /logfile: return the content of the logfile
-   /loggers: show or modify logger configurations
-   /mapping: show all @RequestMappings
-   /metrics: show metric information about the application
-   /shutdown: shutdown the application

In the application.properties you can turn on or off specific endpoints

## Additional Resources

- [Actuator](https://www.baeldung.com/spring-boot-actuators)
- [DevTools](https://www.baeldung.com/spring-boot-devtools)
- [Lombok](https://www.baeldung.com/intro-to-project-lombok)
- [Validation](https://www.baeldung.com/spring-boot-bean-validation)