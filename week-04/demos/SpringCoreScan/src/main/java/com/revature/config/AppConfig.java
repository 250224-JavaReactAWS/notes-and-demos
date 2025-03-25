package com.revature.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // Marks class as a config class
@ComponentScan("com.revature")
public class AppConfig {

    /*
    Before the options we took to initialize our Beans was defining them in the XML file and then using Java to
    programmatically create them. Now we're going to use annotations to have them generated automatically.

    We'll use something called Component Scanning and this is where Spring will search through a specified package
    and look for anything with a Stereotype Annotation

    A Stereotype annotation is one you place at the of a class and it defines the class as a Bean, you can define things
    like scope as well as needed.

    @Component
        - General Spring Bean, everything other stereotype is a subtype of this one
    @Repository
        - Bean in charge of database logic
    @Service
        - Bean in charge of business logic
    @Controller
        - Bean in charge of web traffic
     */
}
