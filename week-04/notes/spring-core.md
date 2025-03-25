# Spring

Spring an umbrella term for a family of frameworks which can be utilized to rapidly create loosely coupled Java applications. These spring frameworks provide a comprehensive and configurable model for modern enterprise Java applications, which can be easily migrated to any kind of deployment platform. This ease is due to the core feature of the Spring frameworks, which focuses on dependency injection resulting from the framework acting as an inversion of control container.


## Frameworks - Overview
The Spring family of frameworks consist of close to 20 modules, each focusing on a particular task or service. These are grouped into the following layers: Core Container, Data Access/Integration, Messaging, Web, AOP, Aspects, Instrumentation and Test.

![Spring Modules](https://docs.spring.io/spring-framework/docs/4.0.x/spring-framework-reference/html/images/spring-overview.png)


# Spring Projects

<img src = "https://1.bp.blogspot.com/-4vTgRx2HlTE/YN9IoM8gMzI/AAAAAAAAuTk/Qk-GDPUDTEENOmwhl04bZLq65PrZUwBTACLcBGAsYHQ/s2048/Spring%2BEcosystem.png" width = 1000>

Back in June 2003, Rod Johnson created the Core Spring Framework

Spring Framework originally intended to make development of JavaEE applications simpler by reducing boilerplate code. This is the foundation on which everything is built

This eventually lead to the creation of the spring projects which build on top of the core MODULES but tailored to specific business needs.

For example, the Spring Security project was built to simplify the complexity of securing a java application…..and other projects like spring data was created to simplify data access in java applications.

This eventually lead to the creation of a particularly impactful project called spring boot.  Spring boot was a real game changer.  It provided a new and drastically faster way of building spring applications.

Up until Spring Boot, building a Spring application involved tough configuration choices and a cumbersome deployment model.  Spring Boot removed all of that by taking an opinionated view of building spring based application by creating sensible defaults for library choices and adding the ability to auto detect and auto configure other necessary components. Additionally,  It made running a Spring application as simple as running a single command.

Then came along Spring Cloud. Spring Cloud was built ontop of Spring Boot and made it easy to build applications that made use of distributed architectures (Like microservices).

# Spring Core

# Dependency Injection

As the name suggests, Dependency Injection is a design patters that removes dependencies of a program by providing the configuration in an external source, such as an ML file. This loosely coupled design then makes code easier to test, and implement in a wider variety of environments.

Dependency Injection can occur through the following methods:
* Constructor Injection: Dependency Injection accomplished when the container invokes a constructor with arguments to instantiate a bean in which each argument of said constructor represents a dependency.
* Setter Injection: Dependency Injection accomplished when the container calls setter methods on a bean after invoking a no-argument constructor to instatiate a bean.

## Constructor vs Setter Injection
* Constructor Injection is more secure, since dependencies are required to create an object, you are guaranteed to have each dependency populated
* Consturctor Injection enables the implementation of immutable objects
* Setter Injection allows for partial dependencies since Constructor injection requires all properties to be established upon bean instantiation.
* Setter Injection occurs after constructor injection, essentially putting giving setter injection precedence over constructor injection
* Setter Injection can easily change values, and does not create new bean instances, making it more flexible than constructor injection.
* Setter Injection can resolve circular references (i.e. if Object A and Object B are dependent on each other, setter injection can be used to resolve this, whereas Constructor injection would throw a BeanCurrentlyInCreationException).

# XML Based Consiguration

# Inversion of Control
---
Inversion of Control is a principle in software engineering by which the control of objects or portions of a program is transferred to a container or framework. IoC enables the framework to take control of the flow of a program and make calls to our custom code. The advantages of this architecture are:

- decoupling the execution of a task from its implementation
- making it easier to switch between different implementations
- greater modularity of a program
- greater ease in testing a program by isolating components

# Spring IOC Container aka Spring Context
---
In the Spring framework, the IoC container is represented by the interface `ApplicationContext`. The Spring container is responsible for instantiating, configuring and assembling objects known as beans, as well as managing their lifecycle. There are 24 implementations of the `ApplicationContext` interface, important ones to be familiar with include:

- `ClassPathXmlApplicationContext`
- `AnnotationConfigApplicationContext`
- `WebApplicationContext`

An ApplicationContext provides:

- Bean factory methods, inherited from `ListableBeanFactory`. 
  - This avoids the need for applications to use singletons.


- The ability to resolve messages, supporting internationalization. Inherited from the `MessageSource` interface.


- The ability to load file resources in a generic fashion. Inherited from the ResourceLoader interface.


- The ability to publish events. Implementations must provide a means of registering event listeners.

- Inheritance from a parent context. Definitions in a descendant context will always take priority. 
  - This means, for example, that a single parent context can be used by an entire web application, while each servlet has its own child context that is independent of that of any other servlet.

# What is a bean factory?
---
A bean factory is just that, a implementation of the factory design pattern which is used to create Spring beans. The `BeanFactory` interface is implemented by objects that hold a number of bean definitions, each uniquely identified by a String name. Depending on the bean definition, the factory will return either an independent instance of a the object, or a single shared instance (a singleton scoped to the factory instance). The point of this approach is that the BeanFactory is a central registry of application components, and centralizes configuration of application components.

# `ApplicationContext` vs `BeanFactory`
---
As the `ApplicationContext` includes all functionality of the `BeanFactory`, it is generally recommended that it be used in preference to the `BeanFactory`, except in applications where memory consumption might be critical and a few extra kilobytes might make a difference. However, for most 'typical' enterprise applications and systems, the `ApplicationContext` is what you will want to use.

**`BeanFactory` features:**
- bean instantiation/wiring

**`ApplicationContext` features:**
- bean instantiation/wiring
- `ApplicationEvent` publication
- Convenient `MessageSource` access (for internationalization)
    - internationalization is the process of designing a software application so that it can potentially be adapted to various languages and regions without engineering changes.

# Annotation Based Configuration

# Component Scanning / Autowiring

# Bean Scopes

When the `ApplicationContext` starts, it uses either an XML configuration file or component scanning to discover what Java classes (beans) it needs to manage for us. Once it discovers these beans, it will create bean defintions, which are just instructions for creating the bean. These definitions are stored in the bean container. The method in which Spring creates these beans is dependent upon the declared scope of the bean (using `scope` attribute on the `<bean>` tag in XML configuration, or using the `@Scope` annotation). If no specific scope is declared, then the default scope is singleton. The scopes which beans can be declared in are:

- **singleton** _(default)_
  - The Spring Container creates only one instance of the bean
  - This bean is cached into memory
  - All requests for the bean will return a shared reference to the same bean

- **prototype**
  - Creates a new bean instance for each container request

- **request**
  - Bean is scoped to an HTTP web request
  - Only used in web applications

- **session**
  - Bean is scoped to an HTTP web session
  - Only used in web applications

- **application**
  - Scopes a single bean definition to the lifecycle of a `ServletContext`
  - Only used in web applications

- **websocket**
  - Scopes a single bean definition to the lifecycle of a `WebSocket`
  - Only used in web applications

# Bean Lifecycle

The management of Beans, conducted by the BeanFactory or Application Context, includes instantiation, configuration and the eventual removal (or destruction) of beans. As a high-level overview:

1. Beans are first instantiated.
1. Their properties are set.
1. Any associated interfaces or objects are made aware of their existence.
1. The bean is made aware of any associated interfaces as well.
1. Any other methods, particularly custom created methods, are invoked.
1. Then the bean is ready for use.
1. Once the bean is no longer used, it is marked for removal and a destroy method is invoked for the bean
1. Custom destroy methods are invoked, if any.
1. Bean is the destroyed.



<img src = "https://howtodoinjava.com/wp-content/uploads/Spring-bean-life-cycle.png">


# Stereotype Annotations

## Overview
Stereotypes are a number of built in annotations which are used as markers to declare obects as a bean, define their name and clarify to a developer what the bean will be used for.

### `@Component`
The `@Component` annotation is a generic stereotype used to declare an objects as a bean, which will be injected into other classes/beans at some point in time. Spring also provides more specific use cases for `@Component` beans when the class serves a specific purpose, such as the persistance of data, a service or presentation. These annotations are `@Repository`, `@Service` and `@Controller` respectively.

```
@Component("account");
public class Account {
    private int id;

    @Override
    public class toString() {
        return "Account [id=" + id +"]";
    }

    public Account() {
        super();
    }

    public Account (int id) {
        super();
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
```


### `@Repository`
The `@Repository` annotation marks a class to be used as a for use with storing data within a repository or database. Specifically, the `@Repository` annotation provides benefits for objects that would otherwise be utilized as a Data Access Object (DAO).

```
@Repository("accountRepository")
public class AccountRepositoryImpl implments AccountRepository {
    Connection connection = null;
    PreparedStatement stmt = null;

    @Override
    public List<Account> getAllAccounts() {

        List<Account> accounts = new ArrayList<Account>();
        try {
            connection = DAOUtilities.getConnection();
            String sql = "SELECT * FROM accounts";
            stmt = connection.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Account account = new account(rs.getInt("id"));
                accounts.add(account);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    
        return accounts;
    }
}
```

### `@Service`
The `@Service` annotation marks a class as a Service for an application

```
@Service("accountService");
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public List<Account> findAll() {
        return accountRepository.getAllAcounts();
    }
}


```

### `@Controller`
The `@Controller` annotation marks a class as a Spring MVC Controller which allow the use of handler mapping annotations. Classes annotated with `@Controller` are autodetected through classpath scanning, and when used in comination with `@RequestMapping`, allows for quick configurations of a web application controller.

```
@Controller("accountController")
public class accountControllerImpl {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value="/accounts/all")
    public @ResponseBody List<Account> getAllAccounts() {
        Return accountService.findAll();
    }
}

```

In addition to readability, use of these stereotypes makes classes more suited for other processing tools, such as aspects or marking targets for pointcuts.