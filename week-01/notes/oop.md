# The Four Pillars of OOP
There are four principles that are often referenced when talking about object-oriented programming. They are as follows:
* Abstraction
* Polymorphism
* Inheritance
* Encapsulation

An easy way to remember these is with the acronym **A PIE**. These concepts provide guidance when designing object-oriented programs. Let's walk through each of these "pillars" of OOP one by one.

# Inheritance
We start with inheritance as it is easiest to understand conceptually. In Java (and other OOP languages), classes contain a blueprint for the state and behavior of objects. Most languages have a method whereby classes (and thus, objects) can **inherit** the state and behavior (read: fields and methods) of other classes. The class from which other classes inherit from is called a "base" or "parent" class, and the class which inherit the parent is called a "child" or "sub"-class. 

In Java, all non-`private` fields and methods are inherited from a parent class when using the `extends` keyword in the class declaration. For example, we could have an `Animal` class as our base class which has a field `numOfLegs` and a method `speak`, and a `Dog` class which extends `Animal`. Thus `Dog` will also have the `numOfLegs` field and `speak` method:
```java
public class Animal {
  public int numOfLegs;
  
  public void speak() {
    System.out.println("*generic animal noise*");
  }
}

public class Dog extends Animal {}
```

`Dog` will get the `speak` method from `Animal`, but can **override** it and implement its own method which is specific to `Dog` if desired. This will be covered later with polymorphism.

The benefit of inheritance lies mainly in the **re-usability of code** - our `Dog` class does not need to redeclare the methods and fields it gets from `Animal`. Thus, we can abide by the common programming guideline **DRY (don't repeat yourself)**.

## Interfaces and the Diamond Problem
Another way for classes to inherit is through **interfaces**. Interfaces are like a contract which specify behaviors that other classes must provide. Interfaces only supply method signatures which other classes must implement and provide method bodies for. Thus, methods in interfaces are implicitly `public` and `abstract`, even when those keywords are not used. Interfaces can also have variables, which are implicitly `public static final` - meaning they are attached ot the interface itself and are constants that cannot be reassigned. Below is an example of an interface:

```java
public interface Purchaseable {
  int maxPrice; // this is implicitly static!
  
  boolean buy(Item i); // NOTE: no method body. This method is public abstract even though we did not use the keywords
}
```

In Java, classes can only extend from one other class - **there is no multiple inheritance via classes. However, we *can* have multi-level inhertance** - for example, class `C` extends `B` which extends `A`. If multiple inheritance were allowed, imagine what would happen if a class were to extend multiple other classes which both contain the same method. Which method implementation would the subclass inherit? This ambiguity is called the "diamond problem", shown below.

![diamond problem](https://cdn.journaldev.com/wp-content/uploads/2013/07/diamond-problem-multiple-inheritance.png)

In Java we can have multiple inheritance and still bypass the diamond problem by using interfaces. A class can implement an arbitrary number of interfaces. There is no ambiguity because interfaces do not have method bodies - the implementing class resolves any ambiguity because it must implement the methods defined in the interfaces.

# Abstraction
**Abstraction** is a programming principle in which we centralize common characteristics and generalize behavior into conceptual classes. In the example above, the `Animal` class contains characteristics and behaviors common to all animals.

Through abstraction, we hide underlying complexity through a simplified interface. Think of a car - you do not need to know how the car works, just how to use the accelerator, brake, and steering wheel. Thus, a car "abstracts" away the internal details of the engine, motor, driveshaft, and other parts. If our `Animal` class were part of a library for creating animals in Java, the user of the library wouldn't need to know exactly how each animal speaks, because the `speak` method is defined on the `Animal` class. We can also use the generic `Animal` type for reference variables without worrying about which specific animal the object is.

```java
Animal a = new Dog();
a.speak();
```

In the example above, `a` is of type `Animal`, not `Dog`. The advantage of writing code this way is that later if we decide we instead need to create a `Cat` here, we can easily change the constructor being invoked. Because the `.speak()` method belongs to the `Animal` class, it is gauranteed to exist for all animals. (Here we are assuming `Cat` would extend `Animal`.)

In Java, we achieve abstraction through abstract classes and interfaces. Abstract classes are classes which cannot be instantiated and are declared with the `abstract` keyword. Generally, it wouldn't make sense to instantiate instantiate our `Animal` class - instead, we use it as a general type and instantiate specific animals. So we could make the `Animal` class abstract instead of concrete.

## Abstract Classes and Interfaces
Abstract classes, as mentioned above, are more general classes which cannot be instantiated. They instead act as templates for other classes to extend from. Abstract classes can have both concrete and abstract methods - the `abstract` methods must be implemented by concrete subclasses.

Interfaces also cannot be instantiated. They instead serve as contracts for methods that classes must implement. In order to inherit from interfaces, a class declares that it `implements` some interface, or multiple interfaces. Methods declared on an interface are implicitly `public` and `abstract`. Interfaces can have variables, but they are implicitly `public`, `static`, and `final`. 

Abstract classes are better suited for defining *common characteristics* of objects and are named as nouns by convention, whereas interfaces are better for defining common *behavior* the implementing class promises to provide.

# Polymorphism
By definition, **polymorphism** means "taking on many forms". In the realm of programming, it describes how objects can behave differently in different contexts. The most common examples of polymorphism in Java are method overloading and overriding.

## Method Overloading
**Method overloading** is when there exist two or more methods in a class with the same method name, but different method signatures by changing the parameter list. For example:
```java
public class MyClass {
  public static void main(String[] args) {
    MyClass mc = new MyClass();
	mc.foo("str", 1); // prints "version 1"
	mc.foo("str");    // prints "version 2"
  }
  public void foo(String a, int b) {
    System.out.println("version 1");
  }
  
  public void foo(String a) {
    System.out.println("version 2");
  }
}
```

We can change the number of parameters (like above), the types of the parameters, or the order in which the parameters are passed. Which version of the method is executed is determined by the parameters passed when the method is invoked. Note that varying the return type of the method is **not** permitted - this will not compile.

Because the argument list is known at compilation, the compiler knows which version of the method will be executed. Therefore, method overloading is a type of **compile-time** - or **static** - polymorphism.

## Method Overriding
**Method overriding** is when a method in a child class has the same method signature as a method in the parent class, but with a different implementation. Thus, child classes can change the default behavior given by a parent's method. Overriding methods makes class hierarchies more flexible and dynamic. Let's change our `Dog` class we used before and have it override the `speak` method from `Animal`:
```java
public class Dog extends Animal {
  public static void main(String[] args){ 
    Animal d = new Dog();
	d.speak(); // Woof!
  }
  
  public void speak() {
    System.out.println("Woof!");
  }
}
```

When we declare the reference variable `d`, it uses the class `Animal` as its type but refers to an actual *instance* of a `Dog` in memory. So we can call the `speak` method declared in `Animal`, but since `d` refers to a `Dog` object, it will use that `Dog`'s implementation of `speak`. This is referred to as **virtual method invocation** and is key to method overriding. The `Animal` class (if it is abstract) does not even need to define any implementation for `speak`, since the method to be executed will be determined at runtime depending on the object referred to in memory. This is the reason why method overriding is classified as **runtime** - or **dynamic** - polymorphism.

One more item to note with method overriding is that `static` methods cannot be overriden. Instead, if a subclass implements the same `static` method as its parent, the method is hidden. **Method hiding** replaces the parent method in the calls defined in the child class.

#### Covariant return types
When overriding a method, we also have the option of changing the return type - _provided that the overriden return type **is a subtype of the original type**_. This is called **covariant return types**. We can also choose to change the access modifier of an overriden method - _provided that the new modifier for the overriding method provides **more, not less, access** than the overriden method_. An example is below:
```java
public class Thing {}
public class SpecificThing extends Thing {}

public class Foo {
  protected Thing get() {
    return new Thing();
  }
}

public class Bar extends Foo {
  public SpecificThing get() {
    return new SpecificThing();
  }
}
```

# Encapsulation
Finally, **encapsulation** is the OOP principle of containing related state and behavior together inside a class, and also hiding and preventing change to an object's data members. When an object is encapsulated, it controls the access to its internal state. This prevents arbitrary external interference, which could bring the object into an invalid or inconsistent state.

In Java, encapsulation is achieved through declaring data members as `private`, with public "getter" and "setter" methods.

```java
public class Person {
  private int age;
  
  public int getAge() {
    return this.age;
  }
  
  public void setAge(int age) {
    if (age > 0) {
      this.age = age;
	}
  }
}
```

In the `Person` class above, we prevent anything outside the class from changing the `age` of the person. We allow access to the field through the `getAge()` method, and we allow manipulation of the field through the `setAge()` method. Note that inside setter methods we can and should perform validation, like we do above - checking that the input number is a valid age (greater than 0).

## SOLID
There are another set of design principles that are important for OOP languages and programs, which are defined by the acronym SOLID:
* **S**ingle responsibility principle
* **O**pen-closed principle
* **L**iskov substitution principle
* **I**nterface segregation principle
* **D**ependency inversion principle

### Single Responsibility Principle
This principle, articulated by Robert Martin, says that

> A class should have only a single responsibility, that is, only changes to one part of the software's specification should be able to affect the specification of the class.

This means that a class has a specific purpose, is responsible for one single piece of functionality, and should have only one "reason to change". This principle relates to encapsulation in that only fields and methods related to the "single responsibility" should be contained in the class.

### Open-closed Principle
This principle states

> Software entities should be open for extension, but closed for modification.

This means that entities like classes should be able to have its behavior extended without modifying the class itself. This is primarily accomplished through inheritance - allowing child classes to add onto the functionality of a base class.

### Listkov Substitution Principle
This principle was articulated by Barbara Liskov and is paraphrased as:

> Objects in a program should be replaceable with instances of their subtypes without altering the correctness of that program. 

We've already seen how important this is with polymorphism and abstraction - substituting a `Cat` for a `Dog` in our program should be straightforward, if both extend from the `Animal` class and our program uses the methods defined there.

### Interface Segregation Principle
This principle states that

> Many client-specific interfaces are better than one general-purpose interface.

This prevents clients from having to depend on methods they do not use. Breaking up our interfaces into smaller, more specific ones decouples our code and makes refactoring easier.

### Dependency Inversion Principle
Put succintly,

> One should depend upon abstractions, not concretions.

In other words, instead of having concrete dependencies in our classes, we should instead depend on abstractions like interfaces. This makes our code more loosely coupled and adds a layer of abstraction which increases the re-usability of higher-level modules.