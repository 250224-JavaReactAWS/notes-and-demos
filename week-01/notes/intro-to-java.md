# Introduction to Java

## Java is a programming language that is:

High-leveled: Easy to read syntax, automatic mem management, garbage collection

Compiled: Progams are converted or compiled into Byte Code

Strongly Typed: Variables types must be defined at compile, and cannot be assigned

Object Oriented: Has constructs of classes and objects built in that allows programmers to follow the principles of Object Oriented Programming

## Advantages of Java (why we like to use it):

Java is platform idependent, you write once and run anywhere, this due to the JVM

It is widely popular with a rich API and countless libraries

It is Object Oriented

It has simple syntax to learn, based on the C programming language

It is free, and supported by Oracle

Has automatic mem management, and garbage collection

# JDK, JRE, JVM

<img src = "https://www.softwaretestinghelp.com/wp-content/qa/uploads/2020/02/All-Java-components-Diagram.png">

## Java Development Kit (JDK):

This provides developer tools to develop Java Applications, it comes with:

-   The JRE
-   Debugger
-   Devtools
-   Compiler

## Java Runtime Environment (JRE):

This provides the build in libraries that Java needs to run code, it comes with:

-   the JVM
-   all neccessary libraries to run java code
-   it is the minimum requirement to run a Java program

## Java Virtual Machine (JVM):

This converts your Java Byte Code into machine readible code

-   This is OS specific
-   Includes the Classloader, runtime data area, execution engine, and heap and stack area

# First Java Program

# Java Primitive Types w/Default Values

The only thing keeping Java from being completely Object Oriented,

The primitives include:

| Datatype | Size                             | Values                                     |
| -------- | -------------------------------- | ------------------------------------------ |
| boolean  | 1 bit                            | true or false                              |
| byte     | 8 bit integer                    | -128 to 127                                |
| short    | 16 bit integer                   | -32768 to 32767                            |
| int      | 32 bit integer                   | ~ -2 billion to 2 billion                  |
| long     | 64 bit integer                   | -2^64 to 2^64-1                            |
| float    | 32 bit floating point            | -3.40252357 x 10^34 to 1.40239846 x 10^-45 |
| double   | 64 bit floating point            | -1.7976... x 10^308 to 4.9407... x 10^-324 |
| char     | 16 bit unicode character         |                                            |
| String   | Not a prim, but treated like one |                                            |

## Data type Default value

-   boolean: false
-   char: \u000 (0)
-   int: 0
-   float: 0.0f
-   reference types (objects): null

## Datatype casting:

Widening: Will occur automatically, Java will convert a smaller data type to a larger type

Narrowing: Will need to be done manually, converting a larger data type to a smaller data type

# Java Classes vs Objects

## Classes in Java

A class is a blueprint for an object

-   It will contail all of the properties and methods that the object will have

## Objects in Java

An object is a virtualization of a real world object

Created from a class, and hold states, behaviors, and indentity

States: property attributes (fields)

Behaviors: methods (a function that is attached to an object)

Identity: the name of the object

## Modularization

Writing code that is available/reusable in different places

-   Break up the code into smaller reusable pieces
-   We use Classes and objects to achieve this
-   Allows us to simplify our code

# Java Methods and Parameters, main method

## Methods are blocks of code which only run when called

-   Declared inside of classes, they must have a return type, name, and parameter list followed by curly braces

`return type name(params, param2, param3, so on and so forth){}`

## Parameters are specified inside of the parenthesis of the method

There is a special method called `main`, it is where the program execution occurs

-   There is only one per "program"

# Packages/Imports

`package com.revature.mypackage;`

This line declares the package in which the class will reside. This must always be the first (non-commented) line in a .java file. Packages are a way of organizing classes, interfaces, and enums in a hierarchical manner. Packages follow a naming convention of lowercase characters separated by periods in the reverse way you would specify a web domain - thus, com.revature.mypackage instead of mypackage.revature.com.


Also, classes can be referenced anywhere in a program by their "fully qualified class name" - which is the package declaration followed by the class, in order to uniquely identify the class. In our example, the fully qualified class name is com.revature.mypackage.HelloWorld.


But typically we do not want to write out a verbose package and class name together. Instead, we can use an import statement after our package declaration to pull in other classes. We can then just use the class name without the package. By default, everything in the java.lang package is imported (which gives us the System class we used in the previous example). Other packages and classes must be imported by the programmer explicitly.

# Control Flow Statements

Java, like most other languages, has a few keywords that define statements which control the flow of program execution:
* `if/else if/else`
* `for`
* `while`
* `do-while`
* `switch`

## If statements
The basic syntax of `if` statements:
```java
if (condition) { // this is the only block that is required - others are optional
  statement1;
} else if (condition2) {
  statement2;
} else {
  statement3;
}
```

## For loops
For-loops are used for iteration, often in conjunction with data structures. They include 3 statements in parentheses - a declaration, condition, and statement (typically increment or decrement).
```java
for (int i=0; i < myData.length; i++) {
  // typical for loop
  System.out.println(myData[i]);
}
```

Any object which implements the `Iterable` interface can be iterated over using an **enhanced for-loop**. The syntax is given in an example:

```java
List<String> myList = getListOfStrings();
for (String myStr : listOfStrings) {
  System.out.println(myStr);
}
```

## While statements
While statements test a condition - if the condition evaluates to true the block of code is run, otherwise the block is skipped. The block is looped through as long as the condition remains `true`.
```java
while (true) {
  // infinite loop!
}
```

An alternative to `while` loops is the `do-while` loop. This guarantees that the block will always run at least once:
```java
do {
  // always runs at least once!
} while(condition); // condition evaluated after the block of code, and the do block will run subsequently until the condition evaluates to false
```

## Switch statements
`switch` statements attempt to match some variable with the value it contains. This type of statement works with `byte`, `short`, `char`, and `int` primitives, along with enumerated types (`enum`s) and - since Java 7 - `String`s. The basic syntax is:

```java
switch(variable) {
  case 'A': System.out.println("Case A matches!"); break; // break is REQUIRED, unless you want control flow to "fall through" to the next case, or unless your switch case returns something and exits the method
  case 'B': System.out.println("Case B matches!"); break;
  case 'C': System.out.println("Case C matches!"); break;
  default: System.out.println("this will run if other cases don't match"); break;
}
```
# Java Operators

| Operator             | Precedence                              |
| -------------------- | --------------------------------------- |
| postfix              | x++ x--                                 |
| prefix               | ++x --x                                 |
| multiplicative       | \* / %                                  |
| additive             | + -                                     |
| shift                | << >> >>>                               |
| relational           | < > <= >=                               |
| equality             | == !=                                   |
| bitwise AND          | &                                       |
| bitwise exclusive OR | ^                                       |
| bitwise OR           | \|                                      |
| logical AND          | &&                                      |
| logical OR           | \|\|                                    |
| ternary              | expression ? true option : false option |
| assignment           | = += -= /= %=                           |

### When we talk about logical AND
 | true && true = true   |
 | true && false = false |
 | false && true = false |
 | false && false = false|




### When we talk about logical OR

true || true = true
true || false = true
false || true = true
false || false = false

## Logical AND and OR will short circuit

-   the operation can determine the outcome by looking at only one side of the expression