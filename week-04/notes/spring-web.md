# Spring Web

Spring Web is a part of the Spring Framework that provides tools for building web applications and RESTful web services. It includes support for HTTP handling, request mapping, and integration with Spring's dependency injection features.

## RESTful Architecture

Spring Web enables the development of REST APIs using Spring MVC components but focuses on stateless communication via HTTP methods such as GET, POST, PUT, and DELETE.

## Spring Web Annotations

### @RestController

Marks a class as a RESTful controller, automatically converting return values into JSON responses.

```java
@RestController
@RequestMapping("/api")
public class MyController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }
}
```

### @RequestMapping

Used to define request handling at both class and method levels. It can specify HTTP methods, request parameters, and more.

```java
@RequestMapping(value = "/users", method = RequestMethod.GET)
public List<User> getUsers() {
    return userService.getAllUsers();
}
```

### @GetMapping, @PostMapping, @PutMapping, @DeleteMapping

Convenient shortcuts for defining specific HTTP method mappings.

```java
@GetMapping("/users/{id}")
public User getUser(@PathVariable Long id) {
    return userService.getUserById(id);
}
```

### @RequestParam and @PathVariable

Used to capture values from the URL.

```java
@GetMapping("/search")
public User searchUser(@RequestParam String name) {
    return userService.findByName(name);
}
```

```java
@GetMapping("/users/{id}")
public User getUser(@PathVariable Long id) {
    return userService.getUserById(id);
}
```

### @RequestBody

Used to extract JSON payloads from requests into Java objects.

```java
@PostMapping("/users")
public User createUser(@RequestBody User user) {
    return userService.saveUser(user);
}
```

### @ResponseBody

Automatically serializes return values into JSON responses.

```java
@GetMapping("/status")
@ResponseBody
public String status() {
    return "Service is running";
}
```

## ResponseEntity

`ResponseEntity` represents an HTTP response, including the status code, headers, and body. It provides more control over the response compared to just returning an object.

```java
@GetMapping("/users/{id}")
public ResponseEntity<User> getUser(@PathVariable Long id) {
    User user = userService.getUserById(id);
    if (user == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    return ResponseEntity.ok(user);
}
```

### Example with Custom Headers

```java
@GetMapping("/download")
public ResponseEntity<Resource> downloadFile() {
    Resource file = fileService.getFile();
    return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"file.txt\"")
            .body(file);
}
```

## HttpSession

`HttpSession` allows managing user sessions in a web application. It can be used to store user-related data between requests.

### Storing Data in a Session

```java
@PostMapping("/login")
public ResponseEntity<String> login(HttpSession session, @RequestParam String username) {
    session.setAttribute("user", username);
    return ResponseEntity.ok("User logged in");
}
```

### Retrieving Data from a Session

```java
@GetMapping("/profile")
public ResponseEntity<String> getProfile(HttpSession session) {
    String user = (String) session.getAttribute("user");
    if (user == null) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not logged in");
    }
    return ResponseEntity.ok("Logged in user: " + user);
}
```

### Invalidating a Session

```java
@PostMapping("/logout")
public ResponseEntity<String> logout(HttpSession session) {
    session.invalidate();
    return ResponseEntity.ok("User logged out");
}
```

## Exception Handling

Spring Web allows global exception handling using `@ControllerAdvice`.

```java
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleNotFound(UserNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
```

## Spring Web vs. Spring MVC

- **Spring Web** focuses on web-related features, including REST API development.
- **Spring MVC** is a subset of Spring Web, primarily for handling traditional web applications with views (JSP, Thymeleaf, etc.).

Spring Web is the preferred choice when building **RESTful APIs**, especially when using Spring Boot for quick and efficient web service development.

