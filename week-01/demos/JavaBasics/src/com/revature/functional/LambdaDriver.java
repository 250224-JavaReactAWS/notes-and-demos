package com.revature.functional;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class LambdaDriver {
    /*
    Java 8 was a particularly interesting update to Java that occurred about 10 years ago. It introduced a lot of
    cool features which we'll view as time goes on.

    - Lambdas
    - Functional Interfaces
    - Improved Date/Time API
    - Stream API
    - Improvements to functionality of interfaces
    - Optional Class

    Lambdas and Functional Interfaces were introduced to give Java the ability to program in a more Functional
    Programming sort of way

    Functional Interface is an interface with EXACTLY ONE method in it.
     */

    public static void main(String[] args){

        // If I wanted to use the doMath function, let's look at how we'd implement this before
        // 1. Creating an implementing class
        MyFunctionalInterface mfi = new MyFunctionalClass();
        mfi.doMath(1, 2);
        // Reasons this is not great. I had to create a whole class to implement one method and then create an object
        // to actually use the method

        // 2. Providing an immediate implementation
        MyFunctionalInterface mfi2 = new MyFunctionalInterface() {
            @Override
            public int doMath(int a, int b) {
                return a-b;
            }
        };
        mfi2.doMath(4,3);
        // Again this works perfectly fine but it's pretty verbose and hard to read

        // Lambda Implementation
        // A lambda is similar to an Arrow function in JavaScript, it allows to provide a simple one line implementation
        // for the method in MyFunctionalInterface
        MyFunctionalInterface firstLambda = (a,b) -> a * b;
        // Benefits: Much cleaner and easy to understand. Implicitly implements the method from the functional interface

        // Other ways to declare a lambda
        // Slight syntax differences
        MyFunctionalInterface lambda2 = (int a, int b) -> a/b; // Datatypes can be given but typically inferred
        // Return statements
        MyFunctionalInterface lambda3 = (a,b) -> {return a + b;};
        // We can be explicit about returning a value by wrapping this in curly braces and adding in the return statement
        // Multiline implmentation
        MyFunctionalInterface squaredDifference = (a, b) -> {
            a = a * a;
            b = b * b;
            return a - b;
        };

        System.out.println(squaredDifference.doMath(5, 4));

        // Where are these used? They're used all the time in the Stream API
        // Filtering, applying function, producing values, consumer values

        /*
        Built-In Functional Interfaces
        - Supplier
            - Take in no value and return some value. They "supply" a value from nothing
        - Consumer
            - Opposite of Producer, takes in a value and returns nothing.
        - Predicate
            - These contain a method called Test, used for filtering to make sure a criteria is met
        - Function
            - Takes a value and returns a value, useful for applying different functions to multiple elements in set
         */

        Supplier<Integer> supplyMyFavoriteNumber = () -> 51;
        // The method being implemented here is called get()
        // This function takes in nothing and returns some value, in this case my favorite number 51;

        Consumer<Integer> consumeMyFavoriteNumber = (num) -> System.out.println("My Favorite number is " + num);
        // The method for this is called Accept, it takes in whatever type you pass as a generic and consumes the value

        int myFavoriteNumber = supplyMyFavoriteNumber.get();
        consumeMyFavoriteNumber.accept(myFavoriteNumber);

        // Let's try to create a couple of people and filter them based off their age
        Person p1 = new Person("John", 21);
        Person p2 = new Person("Jack", 17);
        Person p3 = new Person("Billy", 25);
        Person p4 = new Person("Janet", 18);

        // Let's say I want to perform some operation to validate they're of legal age
        // Let's create a predicate which is used for filtering
        Predicate<Person> ageFilter = (person) -> {
            // A predicate is function that returns true or false
            // We pass through the filter if true and are caught if false
            return person.getAge() >= 18;
        };
        // Predicate is a functional interface that includes a method called test and it will return true or false

        System.out.println(ageFilter.test(p1));
        System.out.println(ageFilter.test(p2));
        System.out.println(ageFilter.test(p3));
        System.out.println(ageFilter.test(p4));

        // Function
        // This takes in a value and returns a value
        Function<Person, Person> birthdayFunction = (person) -> {
            // The birthday function will increase the person's age by 1
            person.setAge(person.getAge() + 1);

            return person;
        };
        // The function is called apply
//        System.out.println(birthdayFunction.apply(p2));


        // Final example
        // Showcasing the Stream API
        // Stream API is used for data processing and allows you to perform several operations on a set of data in one
        // pass

        // Let's create a list of people
        List<Person> guestList = List.of(p1, p2, p3, p4);
        System.out.println(guestList);

        // Let's provide a stream that takes in the guest list
        // It will filter out those under the age of 18
        // It will filter out the names that don't begin with J
        // For the remaining people it will square their age

        List<Person> newGuestList = guestList.stream().filter((person) ->{
                                        return person.getAge() >= 18;
                                    }).filter(person -> {
                                        String name = person.getName();

                                        return name.startsWith("J");
                                    }).map((person) -> {
                                        person.setAge(person.getAge() * person.getAge());
                                        return person;
                                    }).collect(Collectors.toList());

        System.out.println(newGuestList);
    }
}

class Person {
    // This is a sample class so I can do some simple functions with
    private String name;

    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
