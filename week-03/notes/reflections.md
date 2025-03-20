# Reflection Framework

It is an API for modifying the behavior of methods and classes at runtime. It's called "reflection" because you're reflecting/introspecting into the code (so that it can modify itself).

## Classes in the API:

- Class
- Method
- Modifier
- Parameter

NOTE: You can do things like check an if a class has a specific annotation, method or method signature, or modifier on a method. Frameworks like Spring heavily rely on Reflection to function such as detecting methods and loading classes dynamically. Even JUnit uses Reflection to detect methods with the @Test annotation on them.

### Disadvantages

- **Performance Overhead** 
    - Because reflection involves types that are dynamically resolved, certain Java virtual machine optimizations can not be performed. Consequently, reflective operations have slower performance than their non-reflective counterparts, and should be avoided in sections of code which are called frequently in performance-sensitive applications.

- **Security Restrictions**
    - Reflection requires a runtime permission which may not be present when running under a security manager. This is in an important consideration for code which has to run in a restricted security context, such as in an Applet.

- **Exposure of Internals**
    - Since reflection allows code to perform operations that would be illegal in non-reflective code, such as accessing private fields and methods, the use of reflection can result in unexpected side-effects, which may render code dysfunctional and may destroy portability. Reflective code breaks abstractions and therefore may change behavior with upgrades of the platform.
